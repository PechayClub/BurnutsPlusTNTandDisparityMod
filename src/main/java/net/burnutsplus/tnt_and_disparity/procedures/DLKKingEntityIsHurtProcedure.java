package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModEntities;
import net.burnutsplus.tnt_and_disparity.entity.DLKEntity;

public class DLKKingEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new DLKEntity(TntAndDisparityModEntities.DLK, _level);
			entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
	}
}
