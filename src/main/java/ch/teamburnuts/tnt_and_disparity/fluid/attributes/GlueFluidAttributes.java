
package ch.teamburnuts.tnt_and_disparity.fluid.attributes;

import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.function.BiFunction;

public class GlueFluidAttributes extends FluidAttributes {
	public static class CustomBuilder extends FluidAttributes.Builder {
		protected CustomBuilder(ResourceLocation stillTexture, ResourceLocation flowingTexture,
				BiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> factory) {
			super(stillTexture, flowingTexture, factory);
		}
	}

	public static CustomBuilder builder(ResourceLocation stillTexture, ResourceLocation flowingTexture) {
		return new CustomBuilder(stillTexture, flowingTexture, GlueFluidAttributes::new);
	}

	protected GlueFluidAttributes(Builder builder, Fluid fluid) {
		super(builder, fluid);
	}

	@Override
	public int getColor(BlockAndTintGetter world, BlockPos pos) {
		return Minecraft.getInstance().level.getBiome(pos).getWaterFogColor() | 0xFF000000;
	}
}