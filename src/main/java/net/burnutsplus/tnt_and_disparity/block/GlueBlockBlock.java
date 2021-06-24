
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
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.burnutsplus.tnt_and_disparity.item.DrillBBBItem;
import net.burnutsplus.tnt_and_disparity.TntAndDisparityModElements;

import java.util.List;
import java.util.Collections;

@TntAndDisparityModElements.ModElement.Tag
public class GlueBlockBlock extends TntAndDisparityModElements.ModElement {
	@ObjectHolder("tnt_and_disparity:glue_block")
	public static final Block block = null;
	public GlueBlockBlock(TntAndDisparityModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ICE).sound(SoundType.GROUND).hardnessAndResistance(1000f, 100f).setLightLevel(s -> 0));
			setRegistryName("glue_block");
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
