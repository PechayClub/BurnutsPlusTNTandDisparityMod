package net.burnutsplus.tnt_and_disparity.procedures;

public class BBBResistantArmorArmorBootsTickEventProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency entity for procedure BBBResistantArmorArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency x for procedure BBBResistantArmorArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency y for procedure BBBResistantArmorArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency z for procedure BBBResistantArmorArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure BBBResistantArmorArmorBootsTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 999999999, (int) 5, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 5, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 999999999, (int) 2, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2, (false), (false)));
		world.addParticle(ParticleTypes.CRIT, x, y, z, 0, 0, 0);
	}

}
