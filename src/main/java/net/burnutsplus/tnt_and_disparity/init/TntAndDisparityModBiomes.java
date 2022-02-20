
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

import net.burnutsplus.tnt_and_disparity.world.biome.DLKForestBiome;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModBiomes {
	private static final List<Biome> REGISTRY = new ArrayList<>();
	public static Biome DLK_FOREST = register("dlk_forest", DLKForestBiome.createBiome());

	private static Biome register(String registryname, Biome biome) {
		REGISTRY.add(biome.setRegistryName(new ResourceLocation(TntAndDisparityMod.MODID, registryname)));
		return biome;
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Biome[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DLKForestBiome.init();
		});
	}
}
