
package net.burnutsplus.tnt_and_disparity.block;

import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.BiomeColors;

import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModBlocks;

import java.util.List;
import java.util.Collections;

public class BounceBlockBlock extends FallingBlock {
	public BounceBlockBlock() {
		super(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.SLIME_BLOCK).strength(1f, 400f).friction(0.1f).speedFactor(0f)
				.jumpFactor(10f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
		setRegistryName("bounce_block");
	}

	@Override
	public float[] getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return new float[]{0f, 0f, 0f};
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 7;
	}

	@Override
	public MaterialColor defaultMaterialColor() {
		return MaterialColor.GRASS;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(TntAndDisparityModBlocks.BOUNCE_BLOCK, renderType -> renderType == RenderType.translucent());
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor();
		}, TntAndDisparityModBlocks.BOUNCE_BLOCK);
	}
}
