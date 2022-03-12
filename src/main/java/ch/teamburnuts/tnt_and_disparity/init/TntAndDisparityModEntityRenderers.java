
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import ch.teamburnuts.tnt_and_disparity.client.renderer.StickmanRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.GhostArmorRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.EkorRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.DLKRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.DLKKingRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.CarminiteLauncherCannonRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.CarminiteCannonRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.CarminiteCannonFlyingRenderer;
import ch.teamburnuts.tnt_and_disparity.client.renderer.CarminiteCannonFlyingForPlayerRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TntAndDisparityModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TntAndDisparityModEntities.SHOOTABLE_BIG_BAD_BOOM, ThrownItemRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.DLK, DLKRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.STICKMAN, StickmanRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.DLK_KING, DLKKingRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.EKOR_PUPPET, ThrownItemRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.EKOR, EkorRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.TELEPORTATION_ROD, ThrownItemRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.GHOST_ARMOR, GhostArmorRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.CARMINITE_LAUNCHER_CANNON, CarminiteLauncherCannonRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.CARMINITE_CANNON, CarminiteCannonRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.CARMINITE_CANNON_FLYING, CarminiteCannonFlyingRenderer::new);
		event.registerEntityRenderer(TntAndDisparityModEntities.CARMINITE_CANNON_FLYING_FOR_PLAYER, CarminiteCannonFlyingForPlayerRenderer::new);
	}
}
