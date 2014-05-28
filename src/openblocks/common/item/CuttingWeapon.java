package openblocks.common.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface CuttingWeapon {

	public void registerIcons(IconRegister registry);

	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player);
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack);

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4); 
	
	public double getBonusDamage();
}
