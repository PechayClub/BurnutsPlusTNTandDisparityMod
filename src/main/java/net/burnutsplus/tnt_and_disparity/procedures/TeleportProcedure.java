package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;
import java.util.Collections;

public class TeleportProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency entity for procedure Teleport!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency x for procedure Teleport!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency y for procedure Teleport!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency z for procedure Teleport!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure Teleport!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((Math.floor(x)), (Math.floor(y)), (Math.floor(z)));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.floor(x)), (Math.floor(y)), (Math.floor(z)), _ent.rotationYaw,
						_ent.rotationPitch, Collections.emptySet());
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "tp");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager()
					.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((Math.floor(x)), (Math.floor(y)), (Math.floor(z))),
							Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
									.withFeedbackDisabled(),
							"tp");
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, (Math.floor(x)), (Math.floor(y)), (Math.floor(z)), (int) 10, 3, 3, 3, 1);
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
					SoundCategory.AMBIENT, (float) 1, (float) 1);
		} else {
			((World) world).playSound((Math.floor(x)), (Math.floor(y)), (Math.floor(z)),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
					SoundCategory.AMBIENT, (float) 1, (float) 1, false);
		}
		if ((Math.random() < 0.05)) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new EndermiteEntity(EntityType.ENDERMITE, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
