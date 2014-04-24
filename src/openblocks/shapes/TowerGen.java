package openblocks.shapes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.common.tileentity.TileEntityRopeLadder;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.BlockNotifyFlags;
import openmods.utils.MathUtils;

public class TowerGen implements IShapebleGen {

	private final int height = 8;
	private final int width = 3;
	private final int depth = 3;
	
	@Override
	public void generateShape(int x, int y, int z, IShapeable shapeable) {

		new ShapeRoofCylinderGen().generateShape(depth, height, width, shapeable);
		new ShapeXPlaneGen().generateShape(depth, height, width, shapeable);
	}
	

	@Override
	public void fill(ChunkCoordinates coord, World worldObj) {		
		new ShapeRoofCylinderGen().fill(coord, worldObj);
		worldObj.setBlockToAir(coord.posX-1, coord.posY+height, coord.posZ);
		int y=coord.posY+height+1;
		while(y-->0){
			if(!worldObj.isAirBlock(coord.posX-1, y, coord.posZ)){
				break;
			}
			worldObj.setBlock(coord.posX-1, y, coord.posZ, openblocks.OpenBlocks.Blocks.ropeLadder.blockID,
					5,3);
			
		}
		for (int h = coord.posY+3; h < coord.posY+height; h=h+2) { //ventanas
			worldObj.setBlock(coord.posX+depth, h, coord.posZ, Block.glass.blockID);
			worldObj.setBlock(coord.posX-depth, h, coord.posZ, Block.glass.blockID);
			worldObj.setBlock(coord.posX, h, coord.posZ+width, Block.glass.blockID);
			worldObj.setBlock(coord.posX, h, coord.posZ-width, Block.glass.blockID);
		}
		
	}

}
