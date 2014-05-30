package openblocks.common.block;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import openblocks.Config;

public class BlockScreenPrinter extends OpenBlock{

	private int width = 5;
	private int depth = 5;
	private int height = 10;

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
		PrintWriter writer;
		try {
			writer = new PrintWriter("the-file-name.txt", "UTF-8");

			for(int x=-width; x<=width;x++){
				for(int y=-height; y<=1;y++){
					for(int z=-depth; z<=depth;z++){
						if(blockConditions(worldObj.getBlockId(xCoord+x, yCoord+y, zCoord+z))){
							//nada
						}
						else{
							writer.println("array.add(new BlockRepresentation(entityPos.posX+"+x+", entityPos.posY+"+y+", entityPos.posZ+"+z+", "
									+worldObj.getBlockId(xCoord+x, yCoord+y, zCoord+z)+", "+worldObj.getBlockMetadata(xCoord+x, yCoord+y, zCoord+z)+", 3));     ");
							//						res+="array.add(new BlockRepresentation(entityPos.posX+"+x+", entityPos.posY+"+y+", entityPos.posZ+"+z+", "
							//								+worldObj.getBlockId(xCoord+x, yCoord+y, zCoord+z)+", "+worldObj.getBlockMetadata(xCoord+x, yCoord+y, zCoord+z)+", 3));     ";
						}
					}
				}
			}
			writer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean blockConditions(int id){
		return (id==Block.stone.blockID);
	}

}

