package openblocks.common.block;

import openblocks.Config;
import openblocks.common.block.BlockGuide.Icons;
import openblocks.shapes.BlockRepresentation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockScreenPrinter extends OpenBlock{
	
	private int width = 4;
	private int depth = 4;
	private int height = 2;
	
	public static class Icons {
		public static Icon ends;
		public static Icon side;
	}

	public BlockScreenPrinter() {
		super(Config.blockScreenPrinter, Material.ground);
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
		Icons.ends = registry.registerIcon("openblocks:grave");
		Icons.side = registry.registerIcon("openblocks:guide2");

		setTexture(ForgeDirection.UP, Icons.ends);
		setTexture(ForgeDirection.DOWN, Icons.ends);
		setTexture(ForgeDirection.EAST, Icons.side);
		setTexture(ForgeDirection.WEST, Icons.side);
		setTexture(ForgeDirection.NORTH, Icons.side);
		setTexture(ForgeDirection.SOUTH, Icons.side);
		setDefaultTexture(Icons.ends);
	}
	
	@Override
	public void onBlockAdded(World worldObj, int xCoord, int yCoord ,int zCoord){
		String res = "";
		for(int x=-width; x<=width;x++){
			for(int y=-height; y<=height;y++){
				for(int z=-depth; z<=depth;z++){
					if((y>=0 && worldObj.getBlockId(xCoord+x, yCoord+y, zCoord+z)==0) ||
							(y==0 && x==0 && z==0) ||
							worldObj.getBlockId(xCoord+x, yCoord+y, zCoord+z)==12){
						//nada
					}
					else{
						res+="array.add(new BlockRepresentation(entityPos.posX+"+x+", entityPos.posY+"+y+", entityPos.posZ+"+z+", "
								+worldObj.getBlockId(xCoord+x, yCoord+y, zCoord+z)+", "+worldObj.getBlockMetadata(xCoord+x, yCoord+y, zCoord+z)+", 3));     ";
					}
				}
			}
		}
		System.out.println(res);
	}

}

