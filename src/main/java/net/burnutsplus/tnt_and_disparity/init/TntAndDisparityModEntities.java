
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.burnutsplus.tnt_and_disparity.entity.TeleportationRodEntity;
import net.burnutsplus.tnt_and_disparity.entity.StickmanEntity;
import net.burnutsplus.tnt_and_disparity.entity.ShootableBBBEntity;
import net.burnutsplus.tnt_and_disparity.entity.EkorShooterEntity;
import net.burnutsplus.tnt_and_disparity.entity.EkorEntity;
import net.burnutsplus.tnt_and_disparity.entity.DLKKingEntity;
import net.burnutsplus.tnt_and_disparity.entity.DLKEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<ShootableBBBEntity> SHOOTABLE_BBB = register("entitybulletshootable_bbb",
			EntityType.Builder.<ShootableBBBEntity>of(ShootableBBBEntity::new, MobCategory.MISC).setCustomClientFactory(ShootableBBBEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<DLKEntity> DLK = register("dlk",
			EntityType.Builder.<DLKEntity>of(DLKEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128)
					.setUpdateInterval(3).setCustomClientFactory(DLKEntity::new).sized(1.2000000000000002f, 2.1999999999999997f));
	public static final EntityType<StickmanEntity> STICKMAN = register("stickman",
			EntityType.Builder.<StickmanEntity>of(StickmanEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StickmanEntity::new).sized(0.6f, 1.4f));
	public static final EntityType<DLKKingEntity> DLK_KING = register("dlk_king",
			EntityType.Builder.<DLKKingEntity>of(DLKKingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128)
					.setUpdateInterval(3).setCustomClientFactory(DLKKingEntity::new).sized(1.2f, 2.1999999999999997f));
	public static final EntityType<EkorShooterEntity> EKOR_PUPPET = register("entitybulletekor_puppet",
			EntityType.Builder.<EkorShooterEntity>of(EkorShooterEntity::new, MobCategory.MISC).setCustomClientFactory(EkorShooterEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<EkorEntity> EKOR = register("ekor", EntityType.Builder.<EkorEntity>of(EkorEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EkorEntity::new).sized(4f, 4f));
	public static final EntityType<TeleportationRodEntity> TELEPORTATION_ROD = register("entitybulletteleportation_rod",
			EntityType.Builder.<TeleportationRodEntity>of(TeleportationRodEntity::new, MobCategory.MISC)
					.setCustomClientFactory(TeleportationRodEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));

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
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DLK, DLKEntity.createAttributes().build());
		event.put(STICKMAN, StickmanEntity.createAttributes().build());
		event.put(DLK_KING, DLKKingEntity.createAttributes().build());
		event.put(EKOR, EkorEntity.createAttributes().build());
	}
}
