
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.ArrayList;

import ch.teamburnuts.tnt_and_disparity.entity.TeleportationRodEntity;
import ch.teamburnuts.tnt_and_disparity.entity.StickmanEntity;
import ch.teamburnuts.tnt_and_disparity.entity.ShootableBBBEntity;
import ch.teamburnuts.tnt_and_disparity.entity.LiveHomingRocketEntity;
import ch.teamburnuts.tnt_and_disparity.entity.GhostArmorEntity;
import ch.teamburnuts.tnt_and_disparity.entity.EkorShooterEntity;
import ch.teamburnuts.tnt_and_disparity.entity.EkorEntity;
import ch.teamburnuts.tnt_and_disparity.entity.DLKKingEntity;
import ch.teamburnuts.tnt_and_disparity.entity.DLKEntity;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteLauncherCannonEntity;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingForPlayerEntity;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingEntity;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<ShootableBBBEntity> SHOOTABLE_BIG_BAD_BOOM = register("projectile_shootable_big_bad_boom",
			EntityType.Builder.<ShootableBBBEntity>of(ShootableBBBEntity::new, MobCategory.MISC).setCustomClientFactory(ShootableBBBEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<DLKEntity> DLK = register("dlk",
			EntityType.Builder.<DLKEntity>of(DLKEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128)
					.setUpdateInterval(3).setCustomClientFactory(DLKEntity::new).sized(1.2000000000000002f, 2.3000000000000003f));
	public static final EntityType<StickmanEntity> STICKMAN = register("stickman",
			EntityType.Builder.<StickmanEntity>of(StickmanEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StickmanEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<DLKKingEntity> DLK_KING = register("dlk_king",
			EntityType.Builder.<DLKKingEntity>of(DLKKingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128)
					.setUpdateInterval(3).setCustomClientFactory(DLKKingEntity::new).sized(1.2f, 2.3000000000000003f));
	public static final EntityType<EkorShooterEntity> EKOR_PUPPET = register("projectile_ekor_puppet",
			EntityType.Builder.<EkorShooterEntity>of(EkorShooterEntity::new, MobCategory.MISC).setCustomClientFactory(EkorShooterEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<EkorEntity> EKOR = register("ekor", EntityType.Builder.<EkorEntity>of(EkorEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EkorEntity::new).sized(3f, 3f));
	public static final EntityType<TeleportationRodEntity> TELEPORTATION_ROD = register("projectile_teleportation_rod",
			EntityType.Builder.<TeleportationRodEntity>of(TeleportationRodEntity::new, MobCategory.MISC)
					.setCustomClientFactory(TeleportationRodEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<GhostArmorEntity> GHOST_ARMOR = register("ghost_armor",
			EntityType.Builder.<GhostArmorEntity>of(GhostArmorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(GhostArmorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<CarminiteLauncherCannonEntity> CARMINITE_LAUNCHER_CANNON = register("projectile_carminite_launcher_cannon",
			EntityType.Builder.<CarminiteLauncherCannonEntity>of(CarminiteLauncherCannonEntity::new, MobCategory.MISC)
					.setCustomClientFactory(CarminiteLauncherCannonEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<CarminiteCannonEntity> CARMINITE_CANNON = register("carminite_cannon",
			EntityType.Builder.<CarminiteCannonEntity>of(CarminiteCannonEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CarminiteCannonEntity::new).fireImmune().sized(2f, 2f));
	public static final EntityType<CarminiteCannonFlyingEntity> CARMINITE_CANNON_FLYING = register("carminite_cannon_flying",
			EntityType.Builder.<CarminiteCannonFlyingEntity>of(CarminiteCannonFlyingEntity::new, MobCategory.MISC)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3)
					.setCustomClientFactory(CarminiteCannonFlyingEntity::new).fireImmune().sized(2f, 2f));
	public static final EntityType<CarminiteCannonFlyingForPlayerEntity> CARMINITE_CANNON_FLYING_FOR_PLAYER = register(
			"carminite_cannon_flying_for_player",
			EntityType.Builder.<CarminiteCannonFlyingForPlayerEntity>of(CarminiteCannonFlyingForPlayerEntity::new, MobCategory.MISC)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3)
					.setCustomClientFactory(CarminiteCannonFlyingForPlayerEntity::new).fireImmune().sized(2f, 2f));
	public static final EntityType<LiveHomingRocketEntity> LIVE_HOMING_ROCKET = register("live_homing_rocket",
			EntityType.Builder.<LiveHomingRocketEntity>of(LiveHomingRocketEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(LiveHomingRocketEntity::new).sized(0.5f, 0.5f));

	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		EntityType<T> entityType = (EntityType<T>) entityTypeBuilder.build(registryname).setRegistryName(registryname);
		REGISTRY.add(entityType);
		return entityType;
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new EntityType[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DLKEntity.init();
			StickmanEntity.init();
			DLKKingEntity.init();
			EkorEntity.init();
			GhostArmorEntity.init();
			CarminiteCannonEntity.init();
			CarminiteCannonFlyingEntity.init();
			CarminiteCannonFlyingForPlayerEntity.init();
			LiveHomingRocketEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DLK, DLKEntity.createAttributes().build());
		event.put(STICKMAN, StickmanEntity.createAttributes().build());
		event.put(DLK_KING, DLKKingEntity.createAttributes().build());
		event.put(EKOR, EkorEntity.createAttributes().build());
		event.put(GHOST_ARMOR, GhostArmorEntity.createAttributes().build());
		event.put(CARMINITE_CANNON, CarminiteCannonEntity.createAttributes().build());
		event.put(CARMINITE_CANNON_FLYING, CarminiteCannonFlyingEntity.createAttributes().build());
		event.put(CARMINITE_CANNON_FLYING_FOR_PLAYER, CarminiteCannonFlyingForPlayerEntity.createAttributes().build());
		event.put(LIVE_HOMING_ROCKET, LiveHomingRocketEntity.createAttributes().build());
	}
}
