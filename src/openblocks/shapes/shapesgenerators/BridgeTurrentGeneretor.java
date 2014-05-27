package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public class BridgeTurrentGeneretor extends AbstractShapeGeneratorMove 
{
	final protected int height = 6;
	final protected int wide   = 2;
	
	@Override
	public int getSpaceToLimit() 
	{
		return wide + 1;
	}

	@Override
	public Block getBlockToConstruct() 
	{
		return Block.wood;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) 
	{
		for(int x = -wide; x <= wide; x++)
		{
			for(int y = 0; y <= height; y++)
			{
				for(int z = -wide; z <= wide; z++)
				{
					if(y == 0 || y == height ||
							(y == 1 && (x != -wide && z != -wide && z != wide && x != wide)) ||
							((Math.abs(x) == wide && Math.abs(z) == wide ) ))
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

	@Override
	public int getSpaceToTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z,
			IShapeable shapeable) {
		// TODO Auto-generated method stub
		
	}

}
