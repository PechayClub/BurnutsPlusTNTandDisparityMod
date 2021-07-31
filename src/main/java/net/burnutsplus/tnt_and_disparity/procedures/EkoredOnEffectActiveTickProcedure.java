package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;

public class EkoredOnEffectActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency entity for procedure EkoredOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 1, (int) 10, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 1, (int) 10, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 1, (int) 10, (false), (false)));
	}
}
