package net.mcreator.tnt.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

import net.mcreator.tnt.block.GlueBlockBlock;
import net.mcreator.tnt.TntModElements;
import net.mcreator.tnt.TntMod;

import java.util.Map;

@TntModElements.ModElement.Tag
public class GlueWaterUpdateTickProcedure extends TntModElements.ModElement {
	public GlueWaterUpdateTickProcedure(TntModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntMod.LOGGER.warn("Failed to load dependency x for procedure GlueWaterUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntMod.LOGGER.warn("Failed to load dependency y for procedure GlueWaterUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntMod.LOGGER.warn("Failed to load dependency z for procedure GlueWaterUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntMod.LOGGER.warn("Failed to load dependency world for procedure GlueWaterUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
				world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 10000);
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = GlueBlockBlock.block.getDefaultState();
			world.setBlockState(_bp, _bs, 3);
		}
	}
}
