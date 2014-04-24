package openblocks.common.item;

import openblocks.Config;
import openblocks.OpenBlocks;
import openblocks.common.entity.player.EntityPlayerExt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMPBottle extends Item {

	public ItemMPBottle(int par1) {
		super(Config.itemMPBottle);
		setContainerItem(this);
		setCreativeTab(OpenBlocks.tabOpenBlocks);
		setMaxStackSize(1);
	}
	
	public void onItemRightClick(ItemStack item, World world, EntityPlayerExt player){
		player.restoreMP(30);
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

		// TODO Auto-generated constructor stub
}
