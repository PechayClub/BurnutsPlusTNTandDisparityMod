
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "ekorekors"), new SoundEvent(new ResourceLocation("tnt_and_disparity", "ekorekors")));
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "dlkdies"), new SoundEvent(new ResourceLocation("tnt_and_disparity", "dlkdies")));
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "dlkdlks"), new SoundEvent(new ResourceLocation("tnt_and_disparity", "dlkdlks")));
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "dlkhurt"), new SoundEvent(new ResourceLocation("tnt_and_disparity", "dlkhurt")));
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "dlkkingsaying"),
				new SoundEvent(new ResourceLocation("tnt_and_disparity", "dlkkingsaying")));
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "dryout"), new SoundEvent(new ResourceLocation("tnt_and_disparity", "dryout")));
		REGISTRY.put(new ResourceLocation("tnt_and_disparity", "dlkkingstickman"),
				new SoundEvent(new ResourceLocation("tnt_and_disparity", "dlkkingstickman")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
