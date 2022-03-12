
package ch.teamburnuts.tnt_and_disparity.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import ch.teamburnuts.tnt_and_disparity.procedures.BBBResistantArmorArmorBootsTickEventProcedure;
import ch.teamburnuts.tnt_and_disparity.procedures.ArmorEffectProcedure;
import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModBlocks;

public abstract class BBBResistantArmorArmorItem extends ArmorItem {
	public BBBResistantArmorArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 0;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{0, 0, 0, 0}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 0;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TntAndDisparityModBlocks.RENEWABLE_ENERGY_BLOCK));
			}

			@Override
			public String getName() {
				return "big_bad_boom_resistant_armor_armor";
			}

			@Override
			public float getToughness() {
				return 10f;
			}

			@Override
			public float getKnockbackResistance() {
				return 5f;
			}
		}, slot, properties);
	}

	public static class Helmet extends BBBResistantArmorArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("big_bad_boom_resistant_armor_armor_helmet");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "tnt_and_disparity:textures/models/armor/bbbresistantarmor_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			ArmorEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}

	public static class Chestplate extends BBBResistantArmorArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("big_bad_boom_resistant_armor_armor_chestplate");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "tnt_and_disparity:textures/models/armor/bbbresistantarmor_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			ArmorEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}

	public static class Leggings extends BBBResistantArmorArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("big_bad_boom_resistant_armor_armor_leggings");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "tnt_and_disparity:textures/models/armor/bbbresistantarmor_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			ArmorEffectProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}

	public static class Boots extends BBBResistantArmorArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
			setRegistryName("big_bad_boom_resistant_armor_armor_boots");
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "tnt_and_disparity:textures/models/armor/bbbresistantarmor_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			BBBResistantArmorArmorBootsTickEventProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		}
	}
}
