package openblocks.common.item;

import openblocks.Config;
import openblocks.OpenBlocks;
import net.minecraft.item.Item;

public class ItemDagger extends Item{
	
	private int damage = 1;

	public ItemDagger() {
		super(Config.itemDagger);
		setCreativeTab(OpenBlocks.tabOpenBlocks);
		setMaxDamage(damage);
	}

}
