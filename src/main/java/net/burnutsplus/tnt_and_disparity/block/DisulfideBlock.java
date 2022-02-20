
package net.burnutsplus.tnt_and_disparity.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.burnutsplus.tnt_and_disparity.procedures.DisulfideExplodeProcedure;
import net.burnutsplus.tnt_and_disparity.procedures.DisulfideExplodeOnChangeProcedure;
import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModFluids;

import java.util.Random;

public class DisulfideBlock extends LiquidBlock {
	public DisulfideBlock() {
		super(TntAndDisparityModFluids.DISULFIDE, BlockBehaviour.Properties.of(Material.WATER).strength(0f)

		);
		setRegistryName("disulfide");
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 200;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 1;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 6;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.getBlockTicks().scheduleTick(pos, this, 10);
		DisulfideExplodeOnChangeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		DisulfideExplodeOnChangeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
		super.tick(blockstate, world, pos, random);
		DisulfideExplodeOnChangeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.getBlockTicks().scheduleTick(pos, this, 10);
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		DisulfideExplodeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
