package net.burnutsplus.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.burnutsplus.tnt_and_disparity.entity.DLKEntity;
import net.burnutsplus.tnt_and_disparity.client.model.ModelDLKModel;

public class DLKRenderer extends MobRenderer<DLKEntity, ModelDLKModel<DLKEntity>> {
	public DLKRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDLKModel(context.bakeLayer(ModelDLKModel.LAYER_LOCATION)), 1.2000000000000002f);
	}

	@Override
	public ResourceLocation getTextureLocation(DLKEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/dlk.png");
	}
}
