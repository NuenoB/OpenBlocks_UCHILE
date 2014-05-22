package openblocks.common.item;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import openblocks.Config;
import openblocks.OpenBlocks;
import openmods.utils.ItemUtils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
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

/* Nuevo item. Corresponde a una daga, que hace poco daño, pero tiene mucha durabilidad,
 * y agrega velocidad al golpear un enemigo */
public class ItemDagger extends AbstractCuttingWeapon{ 

	public ItemDagger(int idItem) {
		super(idItem,1.5,100000,"dagger");
	}
	
	public ItemDagger(int idItem, String name) {
		super(idItem,1.5,100000,name);
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase player){
		//Agrega velocidad al personaje
		return super.hitEntity(item, enemy, player);
	}
	
	 public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count)
	 {	player.addPotionEffect(new PotionEffect(1,10));
		 
	   }
	
	

	
}