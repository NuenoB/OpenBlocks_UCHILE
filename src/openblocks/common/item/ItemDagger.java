package openblocks.common.item;

import java.util.List;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import openblocks.Config;
import openblocks.OpenBlocks;
import openmods.utils.ItemUtils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import openblocks.Config;
import openblocks.OpenBlocks;
import openmods.utils.EnchantmentUtils;
import openmods.utils.ItemUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/* Nuevo item. Corresponde a una daga, que hace poco daño, pero tiene mucha durabilidad */
public class ItemDagger extends Item{
	
	private double damage = 1.5;
	private int durability = 100000;
	private int maxQuantity = 1; 

	public ItemDagger(int idItem) {
		super(idItem);
		setCreativeTab(OpenBlocks.tabOpenBlocks);
		setMaxDamage(durability); //indica maxima cantidad de veces que se puede ocupar un item
		setMaxStackSize(maxQuantity);
	}
	
	/** Registrar la imagen del item **/
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		itemIcon = registry.registerIcon("openblocks:dagger");
	}

	/** Efecto cuando se golpea un enemigo **/
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player){
		item.damageItem(1, player);
		player.setFire(10);
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
		//player.addPotionEffect()
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
