
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ch.teamburnuts.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

import ch.teamburnuts.tnt_and_disparity.block.entity.RenewableEnergyBlockBlockEntity;
import ch.teamburnuts.tnt_and_disparity.block.entity.BBBBlockEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> BIG_BAD_BOOM = register("tnt_and_disparity:big_bad_boom", TntAndDisparityModBlocks.BIG_BAD_BOOM,
			BBBBlockEntity::new);
	public static final BlockEntityType<?> RENEWABLE_ENERGY_BLOCK = register("tnt_and_disparity:renewable_energy_block",
			TntAndDisparityModBlocks.RENEWABLE_ENERGY_BLOCK, RenewableEnergyBlockBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
