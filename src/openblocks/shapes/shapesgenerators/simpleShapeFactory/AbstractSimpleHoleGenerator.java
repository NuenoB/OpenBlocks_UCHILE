package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.AbstractShapeGeneratorMove;
import openmods.shapes.IShapeable;

public abstract class AbstractSimpleHoleGenerator extends AbstractShapeGeneratorMove{

	protected final int holeDepth = 2;
	protected final int holeHeight = 6;
	protected final int hight = 2;
	
	@Override
	public int getSpaceToLimit() {
		return 0;
	}

	@Override
	public int getSpaceToTop() {
		return 0;
	}

	@Override
	public int getBlockToConstruct() {
		return 0;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
		moriginX = xSize;
		moriginY = ySize;
		moriginZ = zSize;
		for(int y = 0; y < hight; y++)
		{
			for(int z = -holeDepth; z <= holeDepth; z++)
			{
				setBlockAux(moriginX,moriginY, moriginZ,y - holeHeight,z, shapeable);
			}
		}
		
	}
	
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) 
	{
		ArrayList<BlockRepresentation> oList = new ArrayList<BlockRepresentation>();
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
										  entityPos.posY + moriginY - holeHeight - 2, 
										  entityPos.posZ + moriginZ , 
										  Block.blockRedstone.blockID, 
										  0x3,
										  0));
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
										  entityPos.posY + moriginY - holeHeight - 1, 
										  entityPos.posZ + moriginZ , 
										  Block.redstoneLampActive.blockID, 
										  0x4,
										  0));
		return oList;
		
		
	}

}
