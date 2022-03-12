
package ch.teamburnuts.tnt_and_disparity.potion;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import ch.teamburnuts.tnt_and_disparity.procedures.EkoredOnEffectActiveTickProcedure;

public class EkoredMobEffect extends MobEffect {
	public EkoredMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
		setRegistryName("ekored");
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnt_and_disparity.ekored";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		EkoredOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
