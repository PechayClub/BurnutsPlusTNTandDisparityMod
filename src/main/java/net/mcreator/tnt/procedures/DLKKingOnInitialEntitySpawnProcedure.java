package net.mcreator.tnt.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tnt.TntModElements;
import net.mcreator.tnt.TntMod;

import java.util.Map;

@TntModElements.ModElement.Tag
public class DLKKingOnInitialEntitySpawnProcedure extends TntModElements.ModElement {
	public DLKKingOnInitialEntitySpawnProcedure(TntModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntMod.LOGGER.warn("Failed to load dependency entity for procedure DLKKingOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Do you wanna challenge me? Then lets fight."), (false));
		}
	}
}
