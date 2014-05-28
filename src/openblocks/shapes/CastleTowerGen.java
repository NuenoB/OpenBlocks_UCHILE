package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeable;

class CastleTowerGen extends ATowerShape {

	public CastleTowerGen(int x, int y, int z) {
		super(x, y, z, 8, 1, 1);
	}
	
	@Override
	protected void generateTopShape(int xSize, int ySize, int zSize,
			IShapeable shapeable){
		new ShapeXPlaneGen().generateShape(xSize, ySize-1, zSize, shapeable);
		new ShapeEquilateralSquareGen().generateShape(xSize+1, ySize, zSize+1, shapeable);
		
		shapeable.setBlock(xSize-depth, ySize+1, zSize+1);
		shapeable.setBlock(xSize-depth, ySize+1, zSize-2*width-1);
		shapeable.setBlock(xSize+1, ySize+1, zSize-width);
		shapeable.setBlock(xSize-2*depth-1, ySize+1, zSize-width-1);
		
		shapeable.setBlock(xSize-2*depth-1, ySize+1, zSize+1);
		shapeable.setBlock(xSize+1, ySize+1, zSize+1);
		shapeable.setBlock(xSize+1, ySize+1, zSize-2*width-1);
		shapeable.setBlock(xSize-2*depth-1, ySize+1, zSize-2*width-1);
		
	}

	@Override
	protected void generateBodyShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		for(int i=0; i<ySize; i++){
			new ShapeEquilateralSquareGen().generateShape(xSize, i, zSize, shapeable);
		}

	}

	@Override
	protected ArrayList<BlockRepresentation> specificFill(
			ChunkCoordinates entityPos, World worldObj) {
		
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		return array;
	}
	
	@Override
	protected ChunkCoordinates stairsPos(ChunkCoordinates entityPos){
		return new ChunkCoordinates(entityPos.posX, entityPos.posY+height-1, entityPos.posZ);
	}

}
