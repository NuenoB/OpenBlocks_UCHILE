package openblocks.common.item;

import openblocks.client.model.ModelSonicGlasses;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class FireHelmet extends AbstractElementalArmor {
	
	@SideOnly(Side.CLIENT)
	private ModelFireHelmet model;
	
	public FireHelmet(int armorId, EnumArmorMaterial material, int renderMaterial) {
		super(armorId,material,renderMaterial,0);
		
	}

}
