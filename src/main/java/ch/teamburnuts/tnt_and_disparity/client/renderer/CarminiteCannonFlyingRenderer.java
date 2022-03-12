package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonFlyingEntity;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelCarminiteCannonFlying;

public class CarminiteCannonFlyingRenderer extends MobRenderer<CarminiteCannonFlyingEntity, ModelCarminiteCannonFlying<CarminiteCannonFlyingEntity>> {
	public CarminiteCannonFlyingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCarminiteCannonFlying(context.bakeLayer(ModelCarminiteCannonFlying.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(CarminiteCannonFlyingEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/carminitecannonflying.png");
	}
}
