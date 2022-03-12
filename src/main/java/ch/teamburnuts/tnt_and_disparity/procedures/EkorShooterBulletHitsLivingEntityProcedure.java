package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModMobEffects;

public class EkorShooterBulletHitsLivingEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(TntAndDisparityModMobEffects.EKORED, 300, 1, (true), (true)));
	}
}
