
package net.burnutsplus.tnt_and_disparity.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

import net.burnutsplus.tnt_and_disparity.init.TntAndDisparityModFluids;

public class GlueBlock extends LiquidBlock {
	public GlueBlock() {
		super(TntAndDisparityModFluids.GLUE, BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
		setRegistryName("glue");
	}
}
