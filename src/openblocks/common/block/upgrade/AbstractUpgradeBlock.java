package openblocks.common.block.upgrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import openblocks.OpenBlocks.Blocks;
import openblocks.common.block.OpenBlock;
import openblocks.common.block.BlockScreenPrinter.Icons;
import openblocks.shapes.BlockRepresentation;

public abstract class AbstractUpgradeBlock extends OpenBlock {
	
	protected int metadata;
	
	public static class Icons {
		public static Icon ends;
		public static Icon side;
	}

	protected AbstractUpgradeBlock(int id, int metadata) {
		super(id, Material.ground);
		this.metadata=metadata;
	}
	
	@Override
	public boolean shouldRenderBlock() {
		return true;
	}

	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public boolean useTESRForInventory() {
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister registry) {
		abstResgisterIcons(registry);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.getBlockId(x, y-1, z)==Blocks.canbeupgradedblock.blockID){// &&
				//world.getBlockMetadata(x, y-1, z)==metadata){

			for(BlockRepresentation b : getList(setDeltas())){
				world.setBlock(b.getCoord().posX+x, b.getCoord().posY+y, b.getCoord().posZ+z, b.getBlockId(), b.getMetaData(), 2);
			}
			world.destroyBlock(x, y, z, false);
			
		}
		else{
		}
		return false;
		
	}
	
	public abstract void abstResgisterIcons(IconRegister registry);
	
	public abstract ArrayList<BlockRepresentation> getList(ChunkCoordinates entityPos);
	
	public abstract void setRecipe(List<IRecipe> recipeList);
	
	public abstract ChunkCoordinates setDeltas();

}
