package ch.teamburnuts.tnt_and_disparity.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModBlocks;

public class GlueWaterUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.getBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
				world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), 10000);
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = TntAndDisparityModBlocks.GLUE_BLOCK.defaultBlockState();
			world.setBlock(_bp, _bs, 3);
		}
	}
}
