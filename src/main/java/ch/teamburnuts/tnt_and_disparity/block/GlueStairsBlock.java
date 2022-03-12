
package ch.teamburnuts.tnt_and_disparity.block;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModItems;

public class GlueStairsBlock extends StairBlock {
	public GlueStairsBlock() {
		super(() -> new Block(BlockBehaviour.Properties.of(Material.ICE).sound(SoundType.STONE).strength(100f, 2400f).dynamicShape())
				.defaultBlockState(), BlockBehaviour.Properties.of(Material.ICE).sound(SoundType.STONE).strength(100f, 2400f).dynamicShape());
		setRegistryName("glue_stairs");
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public ItemStack getPickBlock(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(TntAndDisparityModItems.DRILL_BIG_BAD_BOOM);
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.IGNORE;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}
}
