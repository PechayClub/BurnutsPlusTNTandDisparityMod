
package net.burnutsplus.tnt_and_disparity.item;

import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.ToolAction;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;

import net.burnutsplus.tnt_and_disparity.procedures.RemoteBBBParticleProcedure;
import net.burnutsplus.tnt_and_disparity.procedures.DrillBBBDigProcedure;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class DrillBBBItem extends TieredItem {
	public DrillBBBItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 2000f;
			}

			public float getAttackDamageBonus() {
				return 198f;
			}

			public int getLevel() {
				return 20;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
		setRegistryName("drill_bbb");
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState blockstate) {
		int tier = 20;
		if (tier < 3 && blockstate.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
			return false;
		} else if (tier < 2 && blockstate.is(BlockTags.NEEDS_IRON_TOOL)) {
			return false;
		} else {
			return tier < 1 && blockstate.is(BlockTags.NEEDS_STONE_TOOL)
					? false
					: (blockstate.is(BlockTags.MINEABLE_WITH_AXE) || blockstate.is(BlockTags.MINEABLE_WITH_HOE)
							|| blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE) || blockstate.is(BlockTags.MINEABLE_WITH_SHOVEL));
		}
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction)
				|| ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction)
				|| ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return 2000f;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE,
					new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 198f, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED,
					new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", 4, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity sourceentity) {
		stack.hurtAndBreak(2, sourceentity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Level world = entity.level;

		DrillBBBDigProcedure.execute(world, x, y, z);
		return true;
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
		stack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		DrillBBBDigProcedure.execute(world, x, y, z);
		return true;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		DrillBBBDigProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ());
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			RemoteBBBParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
		RemoteBBBParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}
}
