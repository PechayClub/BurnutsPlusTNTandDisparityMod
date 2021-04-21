package net.mcreator.tnt.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

import net.mcreator.tnt.TntModElements;
import net.mcreator.tnt.TntMod;

import java.util.Map;

@TntModElements.ModElement.Tag
public class BBBExplodeProcedure extends TntModElements.ModElement {
	public BBBExplodeProcedure(TntModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntMod.LOGGER.warn("Failed to load dependency x for procedure BBBExplode!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntMod.LOGGER.warn("Failed to load dependency y for procedure BBBExplode!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntMod.LOGGER.warn("Failed to load dependency z for procedure BBBExplode!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntMod.LOGGER.warn("Failed to load dependency world for procedure BBBExplode!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 80, Explosion.Mode.DESTROY);
		}
	}
}
