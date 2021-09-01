package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.IWorld;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class WarningDisplayOverlayIngameProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure WarningDisplayOverlayIngame!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return WarningDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("world", world));
	}
}
