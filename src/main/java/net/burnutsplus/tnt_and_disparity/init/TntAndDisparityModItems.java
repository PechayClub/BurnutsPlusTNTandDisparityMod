
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.burnutsplus.tnt_and_disparity.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.burnutsplus.tnt_and_disparity.item.TeleportationRodItem;
import net.burnutsplus.tnt_and_disparity.item.StickmanSpawnItem;
import net.burnutsplus.tnt_and_disparity.item.ShootableBBBItem;
import net.burnutsplus.tnt_and_disparity.item.RemoteBBBItem;
import net.burnutsplus.tnt_and_disparity.item.GlueItem;
import net.burnutsplus.tnt_and_disparity.item.EkorSoundItem;
import net.burnutsplus.tnt_and_disparity.item.EkorShooterItem;
import net.burnutsplus.tnt_and_disparity.item.DrillBBBItem;
import net.burnutsplus.tnt_and_disparity.item.DisulfideItem;
import net.burnutsplus.tnt_and_disparity.item.DLKLandItem;
import net.burnutsplus.tnt_and_disparity.item.BBBResistantArmorArmorItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TntAndDisparityModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item BBB = register(TntAndDisparityModBlocks.BBB, CreativeModeTab.TAB_COMBAT);
	public static final Item REMOTE_BBB = register(new RemoteBBBItem());
	public static final Item SHOOTABLE_BBB = register(new ShootableBBBItem());
	public static final Item BOUNCE_BLOCK = register(TntAndDisparityModBlocks.BOUNCE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item RENEWABLE_ENERGY_BLOCK = register(TntAndDisparityModBlocks.RENEWABLE_ENERGY_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DRILL_BBB = register(new DrillBBBItem());
	public static final Item DLK = register(
			new SpawnEggItem(TntAndDisparityModEntities.DLK, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("dlk_spawn_egg"));
	public static final Item GLUE_BLOCK = register(TntAndDisparityModBlocks.GLUE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DLK_LAND_PORTAL_FRAME = register(TntAndDisparityModBlocks.DLK_LAND_PORTAL_FRAME, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item STICKMAN = register(
			new SpawnEggItem(TntAndDisparityModEntities.STICKMAN, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("stickman_spawn_egg"));
	public static final Item BBB_RESISTANT_ARMOR_ARMOR_HELMET = register(new BBBResistantArmorArmorItem.Helmet());
	public static final Item BBB_RESISTANT_ARMOR_ARMOR_CHESTPLATE = register(new BBBResistantArmorArmorItem.Chestplate());
	public static final Item BBB_RESISTANT_ARMOR_ARMOR_LEGGINGS = register(new BBBResistantArmorArmorItem.Leggings());
	public static final Item BBB_RESISTANT_ARMOR_ARMOR_BOOTS = register(new BBBResistantArmorArmorItem.Boots());
	public static final Item STICKMAN_SPAWN = register(new StickmanSpawnItem());
	public static final Item DLK_KING = register(
			new SpawnEggItem(TntAndDisparityModEntities.DLK_KING, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("dlk_king_spawn_egg"));
	public static final Item EKOR_PUPPET = register(new EkorShooterItem());
	public static final Item EKOR_SOUND = register(new EkorSoundItem());
	public static final Item EKOR = register(
			new SpawnEggItem(TntAndDisparityModEntities.EKOR, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("ekor_spawn_egg"));
	public static final Item GLUE_STAIRS = register(TntAndDisparityModBlocks.GLUE_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GLUE_SLAB = register(TntAndDisparityModBlocks.GLUE_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GLUE_FENCE = register(TntAndDisparityModBlocks.GLUE_FENCE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GLUE_FENCE_GATE = register(TntAndDisparityModBlocks.GLUE_FENCE_GATE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item GLUE_TRAP_DOOR = register(TntAndDisparityModBlocks.GLUE_TRAP_DOOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item TELEPORTATION_ROD = register(new TeleportationRodItem());
	public static final Item GLUE_BUCKET = register(new GlueItem());
	public static final Item GLOW = register(TntAndDisparityModBlocks.GLOW, CreativeModeTab.TAB_MISC);
	public static final Item DISULFIDE_BUCKET = register(new DisulfideItem());
	public static final Item DLK_LAND = register(new DLKLandItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
