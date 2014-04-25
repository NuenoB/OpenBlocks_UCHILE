package openblocks.common.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ItemHeavySword extends AbstractCuttingWeapon{

	public ItemHeavySword(int id) {
		super(id,10.5,72000,"heavy_sword");
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player){
		player.addPotionEffect(new PotionEffect(2,2000));//Hace lento al personaje
		return super.hitEntity(item, enemy, player);
	}

}
