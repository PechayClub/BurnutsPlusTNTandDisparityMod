
package net.burnutsplus.tnt_and_disparity.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import twilightforest.entity.monster.CarminiteGhastguard;
import twilightforest.entity.monster.CarminiteGhastling;
import twilightforest.entity.monster.CarminiteGolem;
import twilightforest.entity.monster.TowerBroodling;
import twilightforest.entity.monster.TowerwoodBorer;
import twilightforest.entity.boss.UrGhast;

import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModItems;
import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModEntities;

@Mod.EventBusSubscriber
public class StickmanEntity extends PathfinderMob {
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TntAndDisparityModEntities.STICKMAN, 20, 1, 4));
	}

	public StickmanEntity(FMLPlayMessages.SpawnEntity packet, Level world) {
		this(TntAndDisparityModEntities.STICKMAN, world);
	}

	public StickmanEntity(EntityType<StickmanEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 3, true));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers(this.getClass()));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 2));
		this.goalSelector.addGoal(4, new TemptGoal(this, 3, Ingredient.of(TntAndDisparityModItems.STICKMAN_SPAWN), false));
		this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, StickmanEntity.class, (float) 0.1, 2, 3));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Monster.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, CarminiteGhastguard.class, false, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, CarminiteGhastling.class, false, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, CarminiteGolem.class, false, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, TowerBroodling.class, false, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, TowerwoodBorer.class, false, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, UrGhast.class, false, false));
		this.goalSelector.addGoal(14, new FloatGoal(this));
		this.goalSelector.addGoal(15, new LeapAtTargetGoal(this, (float) 2));
		this.goalSelector.addGoal(16, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(17, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(18, new MoveBackToVillageGoal(this, 0.6, false));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof Player)
			return false;
		return super.hurt(source, amount);
	}

	public static void init() {
		SpawnPlacements.register(TntAndDisparityModEntities.STICKMAN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 1);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		return builder;
	}
}
