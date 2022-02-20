package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.burnutsplus.tnt_and_disparity.network.TntAndDisparityModVariables;

public class BattleModeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int) Double.POSITIVE_INFINITY, 1, (false), (false)));
			TntAndDisparityModVariables.WorldVariables.get(world).BattleModeEnabled = true;
			TntAndDisparityModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
