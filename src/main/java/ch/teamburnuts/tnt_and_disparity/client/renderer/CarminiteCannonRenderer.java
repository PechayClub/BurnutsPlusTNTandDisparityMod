package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import ch.teamburnuts.tnt_and_disparity.entity.CarminiteCannonEntity;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelCarminiteCannon;

public class CarminiteCannonRenderer extends MobRenderer<CarminiteCannonEntity, ModelCarminiteCannon<CarminiteCannonEntity>> {
	public CarminiteCannonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCarminiteCannon(context.bakeLayer(ModelCarminiteCannon.LAYER_LOCATION)), 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(CarminiteCannonEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/carminitecannon.png");
	}
}
