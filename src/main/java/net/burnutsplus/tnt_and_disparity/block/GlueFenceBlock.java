
package net.burnutsplus.tnt_and_disparity.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityModElements;

import java.util.List;
import java.util.Collections;

@TntAndDisparityModElements.ModElement.Tag
public class GlueFenceBlock extends TntAndDisparityModElements.ModElement {
	@ObjectHolder("tnt_and_disparity:glue_fence")
	public static final Block block = null;
	public GlueFenceBlock(TntAndDisparityModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends FenceBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WATER).sound(SoundType.GROUND).hardnessAndResistance(1000f, 100f).setLightLevel(s -> 0)
					.harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("glue_fence");
		}

		@Override
		public boolean canConnect(BlockState state, boolean checkattach, Direction face) {
			boolean flag = state.getBlock() instanceof FenceBlock && state.getMaterial() == this.material;
			boolean flag1 = state.getBlock() instanceof FenceGateBlock && FenceGateBlock.isParallel(state, face);
			return !cannotAttach(state.getBlock()) && checkattach || flag || flag1;
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
