package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModMobEffects;

public class EkoredOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(DamageSource.GENERIC,
				(float) (2 * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TntAndDisparityModMobEffects.EKORED)
						? _livEnt.getEffect(TntAndDisparityModMobEffects.EKORED).getAmplifier()
						: 0)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TntAndDisparityModMobEffects.EKORED)
							? _livEnt.getEffect(TntAndDisparityModMobEffects.EKORED).getAmplifier()
							: 0,
					(false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TntAndDisparityModMobEffects.EKORED)
							? _livEnt.getEffect(TntAndDisparityModMobEffects.EKORED).getAmplifier()
							: 0,
					(false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TntAndDisparityModMobEffects.EKORED)
							? _livEnt.getEffect(TntAndDisparityModMobEffects.EKORED).getAmplifier()
							: 0,
					(false), (false)));
	}
}
