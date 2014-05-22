package openblocks.common.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class ItemFireDagger extends ItemDagger {
	
	public ItemFireDagger(int idItem){
		super(idItem,"fire_dagger");
	}
	
	@Override
	/** Efecto cuando se golpea un enemigo **/
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player){
		enemy.setFire(10);
		return super.hitEntity(item, enemy, player);
	}


}
