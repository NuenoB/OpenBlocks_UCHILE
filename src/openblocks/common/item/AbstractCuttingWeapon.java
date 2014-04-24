package openblocks.common.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import openblocks.OpenBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public abstract class AbstractCuttingWeapon extends Item{

	protected double damage;
	protected int durability;
	protected int maxQuantity; 
	protected String name;
	
	public AbstractCuttingWeapon(int id, double damage, int durability, int maxQuan,String name){
		super(id);
		this.damage=damage;
		this.durability=durability;
		this.maxQuantity=maxQuan;
		this.name=name;
		setCreativeTab(OpenBlocks.tabOpenBlocks);
		setMaxDamage(durability); //indica maxima cantidad de veces que se puede ocupar un item
		setMaxStackSize(maxQuantity);
	}
	
	/** Registrar la imagen del item **/
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		itemIcon = registry.registerIcon("openblocks:"+name);
	}

	/** Efecto cuando se golpea un enemigo **/
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player){
		item.damageItem(1, player);
		return true;
	}
	
	/** Entrega usos maximos del item **/
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return durability;
	}

	/** Accion cuando se presiona el click derecho **/
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
	}
	
	/** Agrega información del objeto **/
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add("Damage: "+ damage);
		list.add("Max uses: "+ durability);
	}

}
