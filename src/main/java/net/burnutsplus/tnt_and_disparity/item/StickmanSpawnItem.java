
package net.burnutsplus.tnt_and_disparity.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.InteractionResult;

import net.burnutsplus.tnt_and_disparity.procedures.StickmanSpawnRightClickedOnBlockProcedure;

public class StickmanSpawnItem extends Item {
	public StickmanSpawnItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("stickman_spawn");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		StickmanSpawnRightClickedOnBlockProcedure.execute(context.getLevel(), context.getPlayer());
		return retval;
	}
}
