package ch.teamburnuts.tnt_and_disparity.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import ch.teamburnuts.tnt_and_disparity.entity.LiveHomingRocketEntity;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelLiveHomingRocket;

public class LiveHomingRocketRenderer extends MobRenderer<LiveHomingRocketEntity, ModelLiveHomingRocket<LiveHomingRocketEntity>> {
	public LiveHomingRocketRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLiveHomingRocket(context.bakeLayer(ModelLiveHomingRocket.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(LiveHomingRocketEntity entity) {
		return new ResourceLocation("tnt_and_disparity:textures/live_homing_rocket.png");
	}
}
