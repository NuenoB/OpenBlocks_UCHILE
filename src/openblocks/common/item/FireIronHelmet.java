package openblocks.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;

public class FireIronHelmet extends FireHelmet {
	
	@SideOnly(Side.CLIENT)
	private ModelFireHelmet model;

	public FireIronHelmet(int armorId) {
		super(armorId, EnumArmorMaterial.IRON, 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) {
		if (armorSlot == ARMOR_TYPE) {
			if (model == null) model = new ModelFireIronHelmet();
			return model;
		}

		return null;
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("openblocks:fire_iron_helmet");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "openblocks:textures/models/fire_iron_helmet.png";
	}

}
