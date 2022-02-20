
package net.burnutsplus.tnt_and_disparity.fluid;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

import net.burnutsplus.tnt_and_disparity.procedures.DisulfideExplodeOnChangeProcedure;
import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModItems;
import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModFluids;
import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModBlocks;

public abstract class DisulfideFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TntAndDisparityModFluids.DISULFIDE,
			() -> TntAndDisparityModFluids.FLOWING_DISULFIDE,
			FluidAttributes
					.builder(new ResourceLocation("tnt_and_disparity:blocks/disulfide"), new ResourceLocation("tnt_and_disparity:blocks/disulfide"))

					.density(1500).viscosity(750)

					.rarity(Rarity.UNCOMMON).sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty"))))
							.explosionResistance(0f).canMultiply().tickRate(10)

							.slopeFindDistance(8).bucket(() -> TntAndDisparityModItems.DISULFIDE_BUCKET)
							.block(() -> (LiquidBlock) TntAndDisparityModBlocks.DISULFIDE);

	private DisulfideFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.DRIPPING_WATER;
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(2.5);
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState blockstate) {
		DisulfideExplodeOnChangeProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	public static class Source extends DisulfideFluid {
		public Source() {
			super();
			setRegistryName("disulfide");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DisulfideFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_disulfide");
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
