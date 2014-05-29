package openblocks.common.item;

import openblocks.Config;
import openblocks.OpenBlocks;
import openblocks.client.model.ModelSonicGlasses;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public abstract class AbstractElementalArmor extends ItemArmor implements IElementalArmor{

	protected int ARMOR_TYPE;
	protected int armorId;
	
	public AbstractElementalArmor(int armorId,EnumArmorMaterial material, 
			int renderMaterial ,int armorType) {
		super(armorId, material,renderMaterial,armorType);
		setCreativeTab(OpenBlocks.ourArmorTab);
		this.armorId=armorId;
		this.ARMOR_TYPE=armorType;
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return armorType == ARMOR_TYPE;
	}

	@Override
	public abstract void registerIcons(IconRegister register);

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return itemIcon;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public abstract ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot);

	@Override
	public abstract String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer);
	
	public int getDefense(){
		return this.damageReduceAmount;
	}

}
