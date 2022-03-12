package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import ch.teamburnuts.tnt_and_disparity.entity.GhostArmorEntity;

public class GhostArmorRenderer extends HumanoidMobRenderer<GhostArmorEntity, HumanoidModel<GhostArmorEntity>> {
	public GhostArmorRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(GhostArmorEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/ghostarmor.png");
	}
}
