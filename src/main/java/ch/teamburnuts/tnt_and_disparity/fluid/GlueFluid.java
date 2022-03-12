
package ch.teamburnuts.tnt_and_disparity.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModItems;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModFluids;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModBlocks;
import ch.teamburnuts.tnt_and_disparity.fluid.attributes.GlueFluidAttributes;

public abstract class GlueFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TntAndDisparityModFluids.GLUE,
			() -> TntAndDisparityModFluids.FLOWING_GLUE,
			GlueFluidAttributes
					.builder(new ResourceLocation("tnt_and_disparity:blocks/gluewater"), new ResourceLocation("tnt_and_disparity:blocks/gluewater"))

					.density(25000).viscosity(25000)

					.color(-16448205)).explosionResistance(100f)

							.bucket(() -> TntAndDisparityModItems.GLUE_BUCKET).block(() -> (LiquidBlock) TntAndDisparityModBlocks.GLUE);

	private GlueFluid() {
		super(PROPERTIES);
	}

	public static class Source extends GlueFluid {
		public Source() {
			super();
			setRegistryName("glue");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends GlueFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_glue");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
