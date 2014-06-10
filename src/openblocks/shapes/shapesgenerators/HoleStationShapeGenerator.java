package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public class HoleStationShapeGenerator extends AbstractShapeGeneratorMove{

	final protected int height = 6;
	final protected int wide   = 2;
	
	@Override
	public int getSpaceToLimit() {
		return 6;
	}

	@Override
	public int getSpaceToTop() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getBlockToConstruct() {
		
		return 0;
	}

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z,
			IShapeable shapeable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) {
		
		moriginX = xSize;
		moriginY = ySize;
		moriginZ = zSize;
		
		for(int x = -wide; x <= wide; x++)
		{
			for(int y = 0; y >= -height; y--)
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


}
