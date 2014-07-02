package openblocks.common.item;

import openblocks.client.model.ModelFireIronHelmet;
import openblocks.client.model.ModelSonicGlasses;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class FireHelmet extends AbstractElementalArmor {
	
	private boolean ready = false;
	
	public FireHelmet(int armorId, EnumArmorMaterial material, int renderMaterial) {
		super(armorId,material,renderMaterial,0);
		
	}
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
    {	itemStack.addEnchantment(Enchantment.fireProtection, 1);
    }
}
