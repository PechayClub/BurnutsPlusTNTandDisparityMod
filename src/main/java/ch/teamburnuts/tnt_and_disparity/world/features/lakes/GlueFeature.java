
package ch.teamburnuts.tnt_and_disparity.world.features.lakes;

import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import java.util.Set;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModBlocks;

public class GlueFeature extends LakeFeature {
	public static final GlueFeature FEATURE = (GlueFeature) new GlueFeature().setRegistryName("tnt_and_disparity:glue");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new BlockStateConfiguration(TntAndDisparityModBlocks.GLUE.defaultBlockState()))
			.rangeUniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)).squared().rarity(8);
	public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("ocean"), new ResourceLocation("beach"),
			new ResourceLocation("the_void"), new ResourceLocation("river"), new ResourceLocation("swamp"));

	public GlueFeature() {
		super(BlockStateConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;
		if (dimensionType == ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("tnt_and_disparity:dlk_land")))
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return false;
		return super.place(context);
	}
}
