package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;

public class DLKKingItIsStruckByLightningProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency entity for procedure DLKKingItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency x for procedure DLKKingItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency y for procedure DLKKingItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency z for procedure DLKKingItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure DLKKingItIsStruckByLightning!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("NOOOOOOOOOOOOOOO!!!"), (false));
		}
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 80, Explosion.Mode.DESTROY);
		}
	}
}
