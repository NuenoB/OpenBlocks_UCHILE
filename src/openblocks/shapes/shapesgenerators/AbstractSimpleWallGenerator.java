package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public abstract class AbstractSimpleWallGenerator implements IShapeGenenratorMove {

	protected final int wallHeight = 3;
	protected final int wallDepth = 4;
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
		for(int y = 0; y < wallHeight; y++){
			for(int z = 0; z < wallDepth; z++){
				if(y < wallHeight-1 || ((z == 0|| z == wallDepth-1) && (y == wallHeight-1)))
					setBlockAux(xSize,ySize, zSize,y,z, shapeable);
			}
		}

	}

	abstract public void setBlockAux(int xSize, int ySize, int zSize, int y, int z, IShapeable shapeable);
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) {
		return null;
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		return null;
	}

	@Override
	public int getSpaceToLimit() {
		return 0;
	}

	@Override
	public Block getBlockToConstruct() {
		return null;
	}

}
