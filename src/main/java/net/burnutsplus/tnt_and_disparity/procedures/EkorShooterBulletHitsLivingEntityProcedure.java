package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.burnutsplus.tnt_and_disparity.potion.EkoredPotionEffect;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;

public class EkorShooterBulletHitsLivingEntityProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency entity for procedure EkorShooterBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(EkoredPotionEffect.potion, (int) 300, (int) 1, (true), (true)));
	}
}
