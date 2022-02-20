
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.burnutsplus.tnt_and_disparity.client.model.ModelStickmanModel;
import net.burnutsplus.tnt_and_disparity.client.model.ModelEkorModel;
import net.burnutsplus.tnt_and_disparity.client.model.ModelDLKModel;
import net.burnutsplus.tnt_and_disparity.client.model.ModelDLKKingModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TntAndDisparityModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelDLKModel.LAYER_LOCATION, ModelDLKModel::createBodyLayer);
		event.registerLayerDefinition(ModelStickmanModel.LAYER_LOCATION, ModelStickmanModel::createBodyLayer);
		event.registerLayerDefinition(ModelEkorModel.LAYER_LOCATION, ModelEkorModel::createBodyLayer);
		event.registerLayerDefinition(ModelDLKKingModel.LAYER_LOCATION, ModelDLKKingModel::createBodyLayer);
	}
}
