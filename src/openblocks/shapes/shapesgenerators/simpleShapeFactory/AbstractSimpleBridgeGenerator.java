package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.AbstractShapeGeneratorMove;
import openmods.shapes.IShapeable;


public abstract class AbstractSimpleBridgeGenerator extends AbstractShapeGeneratorMove 
{
	protected final int bridgeHeight = 2;
	protected final int bridgeDepth = 5;

	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) 
	{
		moriginX = xSize;
		moriginY = ySize;
		moriginZ = zSize;
		
		for(int y = 1; y <= bridgeHeight; y++)
		{
			for(int z = 0; z < bridgeDepth; z++)
			{
				if(y == 1 || (z == 0 || z == bridgeDepth-1))
					setBlockAux(moriginX,moriginY, moriginZ,y,z, shapeable);
			}
		}
	}
	
	
	@Override
	public int getSpaceToLimit() 
	{
		return 0;
	}

	@Override
	public int getSpaceToTop() 
	{
		return 0;
	}

	@Override
	public int getBlockToConstruct() 
	{
		return 0;
	}



	@Override
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos) 
	{
		return null;
	}

}
