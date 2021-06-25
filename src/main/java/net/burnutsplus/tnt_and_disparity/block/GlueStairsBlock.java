
package net.burnutsplus.tnt_and_disparity.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.burnutsplus.tnt_and_disparity.item.DrillBBBItem;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityModElements;

import java.util.List;
import java.util.Collections;

@TntAndDisparityModElements.ModElement.Tag
public class GlueStairsBlock extends TntAndDisparityModElements.ModElement {
	@ObjectHolder("tnt_and_disparity:glue_stairs")
	public static final Block block = null;
	public GlueStairsBlock(TntAndDisparityModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(
					Block.Properties.create(Material.ICE).sound(SoundType.GROUND).hardnessAndResistance(100f, 2400f).setLightLevel(s -> 0))
							.getDefaultState(),
					Block.Properties.create(Material.ICE).sound(SoundType.GROUND).hardnessAndResistance(100f, 2400f).setLightLevel(s -> 0));
			setRegistryName("glue_stairs");
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(DrillBBBItem.block, (int) (1));
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
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
}
