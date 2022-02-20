package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Collections;

public class TeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo((Math.floor(x)), (Math.floor(y)), (Math.floor(z)));
			if (_ent instanceof ServerPlayer _serverPlayer) {
				_serverPlayer.connection.teleport((Math.floor(x)), (Math.floor(y)), (Math.floor(z)), _ent.getYRot(), _ent.getXRot(),
						Collections.emptySet());
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "tp");
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((Math.floor(x)), (Math.floor(y)), (Math.floor(z))), Vec2.ZERO,
							_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "tp");
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.PORTAL, (Math.floor(x)), (Math.floor(y)), (Math.floor(z)), 50, 1, 1, 1, 1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.AMBIENT, 1, 1);
			} else {
				_level.playLocalSound((Math.floor(x)), (Math.floor(y)), (Math.floor(z)),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.AMBIENT, 1, 1, false);
			}
		}
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = (true);
				_player.onUpdateAbilities();
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof Player _player) {
						_player.getAbilities().flying = (false);
						_player.onUpdateAbilities();
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 30);
		}
		if (Math.random() < 0.05) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new Endermite(EntityType.ENDERMITE, _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
