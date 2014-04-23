package openblocks.common.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFireDagger extends ItemDagger {
	
	public ItemFireDagger(int idItem){
		super(idItem);
	}
	
	/** Registrar la imagen del item **/
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		itemIcon = registry.registerIcon("openblocks:fire_dagger");
	}
	
	@Override
	/** Efecto cuando se golpea un enemigo **/
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player){
		item.damageItem(1, player);
		enemy.setFire(10);
		return true;
	}
	
	/** Agrega información del objeto **/
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		super.addInformation(itemStack, player, list, par4);
		list.add("Burns the enemy");
	}

}
