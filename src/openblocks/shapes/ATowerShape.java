package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.cond.OneBlockSt;
import openblocks.shapes.simpleshapes.FloorShape;
import openblocks.shapes.simpleshapes.FourWallGen;
import openblocks.shapes.simpleshapes.ShapeEquilateralSquareGen;
import openblocks.shapes.simpleshapes.ShapeXPlaneGen;
import openmods.shapes.IShapeable;

public abstract class ATowerShape extends AShape {
	
	protected int height;
	protected int width;
	protected int depth;
	
	protected int dx;
	protected int dy;
	protected int dz;
	
	protected abstract void generateBodyShape(int xSize, int ySize, int zSize,
			IShapeable shapeable);
	
	protected void generateTopShape(int xSize, int ySize, int zSize,
			IShapeable shapeable){
		
		new FloorShape(-depth+dx, -width+dz, depth+dx, width+dz).generateShape(xSize, dy+height, zSize, shapeable);
		new FourWallGen(-depth+dx, -width+dz, depth+dx, width+dz, 1).generateShape(xSize, dy+height+1, zSize, shapeable);
		
		shapeable.setBlock(dx, dy+height+2, dz+width);
		shapeable.setBlock(dx, dy+height+2, dz-width);
		shapeable.setBlock(dx+depth, dy+height+2, dz);
		shapeable.setBlock(dx-depth, dy+height+2, dz);
		
		shapeable.setBlock(dx-depth, dy+height+2, dz+width);
		shapeable.setBlock(dx+depth, dy+height+2, dz+width);
		shapeable.setBlock(dx+depth, dy+height+2, dz-width);
		shapeable.setBlock(dx-depth, dy+height+2, dz-width);
	}
	
	protected abstract ArrayList<BlockRepresentation> specificFill(ChunkCoordinates entityPos,
			World worldObj);
	
	/**
	 * 
	 * @param x delta x
	 * @param y delta y
	 * @param z delta z
	 * @param h height
	 * @param w width
	 * @param d depth
	 */
	protected ATowerShape(int x, int y, int z, int h, int w, int d){
		super(new OneBlockSt());
		dx=x;
		dy=y;
		dz=z;
		height=h;
		width=w;
		depth=d;
	}

	@Override
	public void generateShape(int x, int y, int z, IShapeable shapeable) {
		
		generateBodyShape(width, height, depth, shapeable);
		generateTopShape(width, height, depth, shapeable);

	}
	
	protected ChunkCoordinates stairsPos(ChunkCoordinates entityPos){
		return new ChunkCoordinates(entityPos.posX, entityPos.posY+height, entityPos.posZ);
	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates worldEntityPos,
			World worldObj) {
		
		ChunkCoordinates entityPos = stairsPos(worldEntityPos);

		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		worldObj.setBlockToAir(entityPos.posX+dx, entityPos.posY+dy, entityPos.posZ+dz);
		
		int y=entityPos.posY+1+dy;
		while(y-->0){
			if(!worldObj.isAirBlock(entityPos.posX+dx, y, entityPos.posZ+dz)){
				break;
			}
			array.add(new BlockRepresentation(entityPos.posX+dx, y, entityPos.posZ+dz,
					openblocks.OpenBlocks.Blocks.ropeLadder.blockID,5,3));
			
		}
		
		array.addAll(specificFill(worldEntityPos, worldObj));
		
		return array;
	}

}
