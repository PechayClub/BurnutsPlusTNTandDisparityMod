
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import ch.teamburnuts.tnt_and_disparity.world.features.lakes.GlueFeature;
import ch.teamburnuts.tnt_and_disparity.world.features.DLKHouseFeature;
import ch.teamburnuts.tnt_and_disparity.world.features.DLKCastleFeature;
import ch.teamburnuts.tnt_and_disparity.world.features.CarminiteBaseFeature;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(DLKCastleFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DLKCastleFeature.GENERATE_BIOMES,
				DLKCastleFeature.CONFIGURED_FEATURE));
		REGISTRY.put(CarminiteBaseFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES,
				CarminiteBaseFeature.GENERATE_BIOMES, CarminiteBaseFeature.CONFIGURED_FEATURE));
		REGISTRY.put(DLKHouseFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DLKHouseFeature.GENERATE_BIOMES,
				DLKHouseFeature.CONFIGURED_FEATURE));
		REGISTRY.put(GlueFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.LAKES, GlueFeature.GENERATE_BIOMES, GlueFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
