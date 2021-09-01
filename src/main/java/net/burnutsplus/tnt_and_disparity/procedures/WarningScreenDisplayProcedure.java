package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;

import twilightforest.TwilightForestMod; // Mainly where that game rule is.

import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;
import java.util.HashMap;

public class WarningScreenDisplayProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure WarningScreenDisplay!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(TwilightForestMod.ENFORCED_PROGRESSION_RULE)) == (false))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				WarningDisplayOverlayIngameProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
