
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.burnutsplus.tnt_and_disparity.fluid.GlueFluid;
import net.burnutsplus.tnt_and_disparity.fluid.DisulfideFluid;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModFluids {
	private static final List<Fluid> REGISTRY = new ArrayList<>();
	public static final FlowingFluid GLUE = register(new GlueFluid.Source());
	public static final FlowingFluid FLOWING_GLUE = register(new GlueFluid.Flowing());
	public static final FlowingFluid DISULFIDE = register(new DisulfideFluid.Source());
	public static final FlowingFluid FLOWING_DISULFIDE = register(new DisulfideFluid.Flowing());

	private static FlowingFluid register(FlowingFluid fluid) {
		REGISTRY.add(fluid);
		return fluid;
	}

	@SubscribeEvent
	public static void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Fluid[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(GLUE, renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GLUE, renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DISULFIDE, renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_DISULFIDE, renderType -> renderType == RenderType.translucent());
		}
	}
}
