package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.burnutsplus.tnt_and_disparity.entity.StickmanEntity;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityModElements;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;

@TntAndDisparityModElements.ModElement.Tag
public class StickmanSpawnRightClickedOnBlockProcedure extends TntAndDisparityModElements.ModElement {
	public StickmanSpawnRightClickedOnBlockProcedure(TntAndDisparityModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency x for procedure StickmanSpawnRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency y for procedure StickmanSpawnRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency z for procedure StickmanSpawnRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure StickmanSpawnRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new StickmanEntity.CustomEntity(StickmanEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles(x, y, z, (float) 1, (float) 0);
			entityToSpawn.setRenderYawOffset((float) 1);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
	}
}
