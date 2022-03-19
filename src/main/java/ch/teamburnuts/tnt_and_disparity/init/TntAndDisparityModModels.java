
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import ch.teamburnuts.tnt_and_disparity.client.model.ModelStickmanModel;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelLiveHomingRocket;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelEkorModel;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelDLKModel;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelDLKKingModel;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelCarminiteRocket;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelCarminiteCannonFlying;
import ch.teamburnuts.tnt_and_disparity.client.model.ModelCarminiteCannon;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TntAndDisparityModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelDLKModel.LAYER_LOCATION, ModelDLKModel::createBodyLayer);
		event.registerLayerDefinition(ModelStickmanModel.LAYER_LOCATION, ModelStickmanModel::createBodyLayer);
		event.registerLayerDefinition(ModelEkorModel.LAYER_LOCATION, ModelEkorModel::createBodyLayer);
		event.registerLayerDefinition(ModelCarminiteCannon.LAYER_LOCATION, ModelCarminiteCannon::createBodyLayer);
		event.registerLayerDefinition(ModelCarminiteCannonFlying.LAYER_LOCATION, ModelCarminiteCannonFlying::createBodyLayer);
		event.registerLayerDefinition(ModelLiveHomingRocket.LAYER_LOCATION, ModelLiveHomingRocket::createBodyLayer);
		event.registerLayerDefinition(ModelDLKKingModel.LAYER_LOCATION, ModelDLKKingModel::createBodyLayer);
		event.registerLayerDefinition(ModelCarminiteRocket.LAYER_LOCATION, ModelCarminiteRocket::createBodyLayer);
	}
}
