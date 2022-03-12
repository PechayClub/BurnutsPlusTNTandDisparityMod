package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModMobEffects;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingForPlayerEntity;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingEntity;
import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonEntity;

public class ExplodeEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof CarminiteCannonEntity || entity instanceof CarminiteCannonFlyingEntity
				|| entity instanceof CarminiteCannonFlyingForPlayerEntity
				|| (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false))) {
			if (!(entity instanceof Player)) {
				if (!entity.level.isClientSide())
					entity.discard();
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z,
						(float) (4 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TntAndDisparityModMobEffects.EXPLODE)
								? _livEnt.getEffect(TntAndDisparityModMobEffects.EXPLODE).getAmplifier()
								: 0) * 2),
						Explosion.BlockInteraction.NONE);
		}
	}
}
