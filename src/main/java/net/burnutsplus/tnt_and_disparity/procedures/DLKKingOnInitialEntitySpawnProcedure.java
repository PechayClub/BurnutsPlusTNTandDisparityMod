package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityModElements;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityMod;

import java.util.Map;

@TntAndDisparityModElements.ModElement.Tag
public class DLKKingOnInitialEntitySpawnProcedure extends TntAndDisparityModElements.ModElement {
	public DLKKingOnInitialEntitySpawnProcedure(TntAndDisparityModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency entity for procedure DLKKingOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Do you wanna challenge me? Then lets fight."), (false));
		}
	}
}
