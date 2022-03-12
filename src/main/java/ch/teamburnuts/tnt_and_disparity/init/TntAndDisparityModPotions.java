
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModPotions {
	private static final List<Potion> REGISTRY = new ArrayList<>();
	public static final Potion EXPLODING_POTION = register(
			new Potion(new MobEffectInstance(TntAndDisparityModMobEffects.EXPLODE, 3600, 0, true, true)).setRegistryName("exploding_potion"));
	public static final Potion EXPLODING_POTION_ENHANCED = register(
			new Potion(new MobEffectInstance(TntAndDisparityModMobEffects.EXPLODE, 3600, 1, true, true))
					.setRegistryName("exploding_potion_enhanced"));

	private static Potion register(Potion potion) {
		REGISTRY.add(potion);
		return potion;
	}

	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Potion[0]));
	}
}
