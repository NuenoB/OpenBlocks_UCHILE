package openblocks.shapes.shapesgenerators.towers;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.AbstractShapeGeneratorMove;
import openmods.shapes.IShapeable;
import sun.awt.X11.Depth;

public class RailIntermedioShapeGenerator extends HoleStationShapeGenerator{

	final protected int height = 6;
	final protected int wide   = 2;
	
	
	
	

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {

		moriginX = xSize;
		moriginY = ySize;
		moriginZ = zSize;
		
		for(int x = -wide; x <= wide; x++)
		{
			for(int y = -height; y < -height + wide; y++)
			{
				for(int z = -wide; z <= wide; z++)
				{
					if(true)
					{
						shapeable.setBlock(x + xSize, y + ySize, z + zSize);
					}
				}
			}
		}
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos, World worldObj) {
		
		ArrayList<BlockRepresentation> oList = new ArrayList<BlockRepresentation>();
		
		for (int contx = -2; contx < 3 ; contx++)
			for (int contz = -2; contz < 3 ; contz++){

				oList.add(new BlockRepresentation(
					entityPos.posX + moriginX + contx,
					entityPos.posY + moriginY - height + wide, 
					entityPos.posZ + moriginZ + contz, 
					Block.brick.blockID, 
					0x0,
					0));
				
				oList.add(new BlockRepresentation(
						entityPos.posX + moriginX + contx,
						entityPos.posY + moriginY - height - 1, 
						entityPos.posZ + moriginZ + contz, 
						Block.brick.blockID, 
						0x0,
						0));
			
			}
		
		
		
		return oList;
	}

}
