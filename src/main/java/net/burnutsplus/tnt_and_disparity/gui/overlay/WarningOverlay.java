
package net.burnutsplus.tnt_and_disparity.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.burnutsplus.tnt_and_disparity.procedures.WarningDisplayOverlayIngameProcedure;

import com.google.common.collect.ImmutableMap;

@Mod.EventBusSubscriber
public class WarningOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (WarningDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("world", world))) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Twilight Forest progrssion is broken.", posX + -210,
						posY + -97, -65536);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "There is no way to reverse this. Make a new world instead.",
						posX + -210, posY + -87, -65536);
			}
		}
	}
}
