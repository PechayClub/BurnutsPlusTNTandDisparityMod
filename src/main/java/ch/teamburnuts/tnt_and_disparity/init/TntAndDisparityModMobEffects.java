
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.effect.MobEffect;

import java.util.List;
import java.util.ArrayList;

import ch.teamburnuts.tnt_and_disparity.potion.ExplodeMobEffect;
import ch.teamburnuts.tnt_and_disparity.potion.EkoredMobEffect;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModMobEffects {
	private static final List<MobEffect> REGISTRY = new ArrayList<>();
	public static final MobEffect EKORED = register(new EkoredMobEffect());
	public static final MobEffect EXPLODE = register(new ExplodeMobEffect());

	private static MobEffect register(MobEffect effect) {
		REGISTRY.add(effect);
		return effect;
	}

	@SubscribeEvent
	public static void registerMobEffects(RegistryEvent.Register<MobEffect> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MobEffect[0]));
	}
}
