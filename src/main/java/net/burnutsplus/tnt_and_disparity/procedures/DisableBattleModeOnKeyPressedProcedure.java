package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;

import net.burnutsplus.tnt_and_disparity.network.TntAndDisparityModVariables;

public class DisableBattleModeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (TntAndDisparityModVariables.WorldVariables.get(world).BattleModeEnabled == true) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
			TntAndDisparityModVariables.WorldVariables.get(world).BattleModeEnabled = false;
			TntAndDisparityModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
