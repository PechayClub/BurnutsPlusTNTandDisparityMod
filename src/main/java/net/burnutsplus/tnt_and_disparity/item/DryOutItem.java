
package net.burnutsplus.tnt_and_disparity.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.burnutsplus.tnt_and_disparity.TntAndDisparityModElements;

import java.util.List;

@TntAndDisparityModElements.ModElement.Tag
public class DryOutItem extends TntAndDisparityModElements.ModElement {
	@ObjectHolder("tnt_and_disparity:dry_out")
	public static final Item block = null;
	public DryOutItem(TntAndDisparityModElements instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TntAndDisparityModElements.sounds.get(new ResourceLocation("tnt_and_disparity:dryout")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("dry_out");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Credit to DJVI for the Music from Free Download."));
		}
	}
}
