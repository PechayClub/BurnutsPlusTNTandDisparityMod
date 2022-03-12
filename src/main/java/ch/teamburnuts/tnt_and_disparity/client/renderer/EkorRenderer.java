package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import ch.teamburnuts.tnt_and_disparity.entity.EkorEntity;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelEkorModel;

public class EkorRenderer extends MobRenderer<EkorEntity, ModelEkorModel<EkorEntity>> {
	public EkorRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEkorModel(context.bakeLayer(ModelEkorModel.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EkorEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/ekor.png");
	}
}
