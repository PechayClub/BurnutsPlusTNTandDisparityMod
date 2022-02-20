
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.burnutsplus.tnt_and_disparity.block.RenewableEnergyBlockBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueTrapDoorBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueStairsBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueSlabBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueFenceGateBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueFenceBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueBlockBlock;
import net.burnutsplus.tnt_and_disparity.block.GlueBlock;
import net.burnutsplus.tnt_and_disparity.block.GlowBlock;
import net.burnutsplus.tnt_and_disparity.block.DisulfideBlock;
import net.burnutsplus.tnt_and_disparity.block.DLKLandPortalFrameBlock;
import net.burnutsplus.tnt_and_disparity.block.DLKLandPortalBlock;
import net.burnutsplus.tnt_and_disparity.block.BounceBlockBlock;
import net.burnutsplus.tnt_and_disparity.block.BBBBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block BBB = register(new BBBBlock());
	public static final Block BOUNCE_BLOCK = register(new BounceBlockBlock());
	public static final Block RENEWABLE_ENERGY_BLOCK = register(new RenewableEnergyBlockBlock());
	public static final Block GLUE_BLOCK = register(new GlueBlockBlock());
	public static final Block DLK_LAND_PORTAL_FRAME = register(new DLKLandPortalFrameBlock());
	public static final Block GLUE_STAIRS = register(new GlueStairsBlock());
	public static final Block GLUE_SLAB = register(new GlueSlabBlock());
	public static final Block GLUE_FENCE = register(new GlueFenceBlock());
	public static final Block GLUE_FENCE_GATE = register(new GlueFenceGateBlock());
	public static final Block GLUE_TRAP_DOOR = register(new GlueTrapDoorBlock());
	public static final Block GLUE = register(new GlueBlock());
	public static final Block GLOW = register(new GlowBlock());
	public static final Block DISULFIDE = register(new DisulfideBlock());
	public static final Block DLK_LAND_PORTAL = register(new DLKLandPortalBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			BounceBlockBlock.registerRenderLayer();
			GlowBlock.registerRenderLayer();
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			BounceBlockBlock.blockColorLoad(event);
		}
	}
}
