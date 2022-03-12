package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.level.LevelAccessor;

import ch.teamburnuts.tnt_and_disparity.network.TntAndDisparityModVariables;

public class BattleModeOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(LevelAccessor world) {
		return TntAndDisparityModVariables.WorldVariables.get(world).BattleModeEnabled == true;
	}
}
