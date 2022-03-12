package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModItems;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModEntities;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingForPlayerEntity;

public class DeployCarminiteCannonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new CarminiteCannonFlyingForPlayerEntity(TntAndDisparityModEntities.CARMINITE_CANNON_FLYING_FOR_PLAYER, _level);
			entityToSpawn.moveTo(x, y, z, 0, 1);
			entityToSpawn.setYBodyRot(0);
			entityToSpawn.setYHeadRot(0);
			entityToSpawn.setDeltaMovement(2, 1, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TntAndDisparityModItems.CARMINITE_CANNON_PACKAGE);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
