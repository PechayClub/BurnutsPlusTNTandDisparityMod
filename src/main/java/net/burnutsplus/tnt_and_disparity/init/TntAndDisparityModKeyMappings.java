
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fmlclient.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.burnutsplus.tnt_and_disparity.network.DisableBattleModeMessage;
import net.burnutsplus.tnt_and_disparity.network.BattleModeMessage;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TntAndDisparityModKeyMappings {
	public static final KeyMapping BATTLE_MODE = new KeyMapping("key.tnt_and_disparity.battle_mode", GLFW.GLFW_KEY_N, "key.categories.misc");
	public static final KeyMapping DISABLE_BATTLE_MODE = new KeyMapping("key.tnt_and_disparity.disable_battle_mode", GLFW.GLFW_KEY_M,
			"key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(BATTLE_MODE);
		ClientRegistry.registerKeyBinding(DISABLE_BATTLE_MODE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == BATTLE_MODE.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						TntAndDisparityMod.PACKET_HANDLER.sendToServer(new BattleModeMessage(0, 0));
						BattleModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == DISABLE_BATTLE_MODE.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						TntAndDisparityMod.PACKET_HANDLER.sendToServer(new DisableBattleModeMessage(0, 0));
						DisableBattleModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
