package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import ch.teamburnuts.tnt_and_disparity.entity.StickmanEntity;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelStickmanModel;

public class StickmanRenderer extends MobRenderer<StickmanEntity, ModelStickmanModel<StickmanEntity>> {
	public StickmanRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStickmanModel(context.bakeLayer(ModelStickmanModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StickmanEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/stickman.png");
	}
}
