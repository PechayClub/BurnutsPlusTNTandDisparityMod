
package ch.teamburnuts.tnt_and_disparity.potion;

import net.minecraftforge.client.EffectRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiComponent;

import com.mojang.blaze3d.vertex.PoseStack;

import ch.teamburnuts.tnt_and_disparity.procedures.ExplodeEffectStartedappliedProcedure;

public class ExplodeMobEffect extends MobEffect {
	public ExplodeMobEffect() {
		super(MobEffectCategory.HARMFUL, -39424);
		setRegistryName("explode");
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnt_and_disparity.explode";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ExplodeEffectStartedappliedProcedure.execute(world, x, y, z, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.EffectRenderer> consumer) {
		consumer.accept(new EffectRenderer() {
			@Override
			public boolean shouldRender(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(MobEffectInstance effect) {
				return false;
			}

			@Override
			public void renderInventoryEffect(MobEffectInstance effect, EffectRenderingInventoryScreen<?> gui, PoseStack mStack, int x, int y,
					float z) {
			}

			@Override
			public void renderHUDEffect(MobEffectInstance effect, GuiComponent gui, PoseStack mStack, int x, int y, float z, float alpha) {
			}
		});
	}
}
