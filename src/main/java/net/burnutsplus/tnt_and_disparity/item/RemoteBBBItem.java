
package net.burnutsplus.tnt_and_disparity.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.burnutsplus.tnt_and_disparity.procedures.RemoteBBBParticleProcedure;
import net.burnutsplus.tnt_and_disparity.procedures.RemoteBBBExplodeProcedure;

public class RemoteBBBItem extends Item {
	public RemoteBBBItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.COMMON));
		setRegistryName("remote_bbb");
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
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		RemoteBBBParticleProcedure.execute(world, x, y, z);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		RemoteBBBExplodeProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ());
		return retval;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		RemoteBBBExplodeProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		RemoteBBBExplodeProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		RemoteBBBParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		RemoteBBBParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			RemoteBBBParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
		RemoteBBBParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		RemoteBBBParticleProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
		return true;
	}
}
