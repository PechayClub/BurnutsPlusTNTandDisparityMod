
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.burnutsplus.tnt_and_disparity.client.renderer.StickmanRenderer;
import net.burnutsplus.tnt_and_disparity.client.renderer.EkorRenderer;
import net.burnutsplus.tnt_and_disparity.client.renderer.DLKRenderer;
import net.burnutsplus.tnt_and_disparity.client.renderer.DLKKingRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TntAndDisparityModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TntAndDisparityModEntities.SHOOTABLE_BBB, ThrownItemRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.DLK, DLKRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.STICKMAN, StickmanRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.DLK_KING, DLKKingRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.EKOR_PUPPET, ThrownItemRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.EKOR, EkorRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.TELEPORTATION_ROD, ThrownItemRenderer::new);
	}
}
