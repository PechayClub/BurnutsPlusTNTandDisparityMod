package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import ch.teamburnuts.tnt_and_disparity.entity.DLKKingEntity;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelDLKKingModel;

public class DLKKingRenderer extends MobRenderer<DLKKingEntity, ModelDLKKingModel<DLKKingEntity>> {
	public DLKKingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDLKKingModel(context.bakeLayer(ModelDLKKingModel.LAYER_LOCATION)), 1.2000000000000002f);
	}

	@Override
	public ResourceLocation getTextureLocation(DLKKingEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/dlkking.png");
	}
}
