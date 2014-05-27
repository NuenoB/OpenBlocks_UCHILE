package openblocks.shapes.newshapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.ATowerShape;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.simpleshapes.FourWallGen;
import openblocks.shapes.simpleshapes.ShapeEquilateralSquareGen;
import openblocks.shapes.simpleshapes.ShapeXPlaneGen;
import openmods.shapes.IShapeable;

public class CastleTowerGen extends ATowerShape {

	public CastleTowerGen(int x, int y, int z) {
		super(x, y, z, 8, 1, 1);
	}
	
	@Override
	protected void generateTopShape(int xSize, int ySize, int zSize,
			IShapeable shapeable){
		
		new FourWallGen(-depth+dx-1, -width+dz-1, depth+dx+1, width+dz+1, 1).generateShape(xSize, dy+height, zSize, shapeable);
		
		shapeable.setBlock(dx, dy+height+1, dz+width+1);
		shapeable.setBlock(dx, dy+height+1, dz-width-1);
		shapeable.setBlock(dx+depth+1, dy+height+1, dz);
		shapeable.setBlock(dx-depth-1, dy+height+1, dz);
		
		shapeable.setBlock(dx-depth-1, dy+height+1, dz+width+1);
		shapeable.setBlock(dx+depth+1, dy+height+1, dz+width+1);
		shapeable.setBlock(dx+depth+1, dy+height+1, dz-width-1);
		shapeable.setBlock(dx-depth-1, dy+height+1, dz-width-1);
		
	}

	@Override
	protected void generateBodyShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		new FourWallGen(-depth+dx, -width+dz, depth+dx, width+dz, height).generateShape(xSize, dy, zSize, shapeable);

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
