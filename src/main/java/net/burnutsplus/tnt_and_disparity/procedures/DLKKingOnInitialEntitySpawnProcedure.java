package net.burnutsplus.tnt_and_disparity.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
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
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency x for procedure DLKKingOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency y for procedure DLKKingOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency z for procedure DLKKingOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntAndDisparityMod.LOGGER.warn("Failed to load dependency world for procedure DLKKingOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnt_and_disparity:dlkkingsaying")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnt_and_disparity:dlkkingsaying")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Do you wanna challenge me? Then lets fight."), (false));
		}
	}
}
