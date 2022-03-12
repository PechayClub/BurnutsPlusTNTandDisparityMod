
package ch.teamburnuts.tnt_and_disparity.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import ch.teamburnuts.tnt_and_disparity.init.TntAndDisparityModFluids;

public class GlueItem extends BucketItem {
	public GlueItem() {
		super(() -> TntAndDisparityModFluids.GLUE,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
		setRegistryName("glue_bucket");
	}
}
