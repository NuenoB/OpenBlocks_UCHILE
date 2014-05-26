package openblocks.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDamage {
	private double bonusDamage;
	
	public ItemDamage(Item item){
		if(item instanceof CuttingWeapon){
			CuttingWeapon i = (CuttingWeapon)item;
			bonusDamage=i.getBonusDamage();
		}
		else
			bonusDamage=0;
			
	}
	
	public double getBonusDamage(){
		return bonusDamage;
	}
}
