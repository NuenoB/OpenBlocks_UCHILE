package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeable;

public abstract class ATowerShape extends AShape {
	
	protected int height;
	protected int width;
	protected int depth;
	
	private int dx;
	private int dy;
	private int dz;
	
	protected abstract void generateBodyShape(int xSize, int ySize, int zSize,
			IShapeable shapeable);
	
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
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		generateBodyShape(dx+width, dy+height, dz+depth, shapeable);
		
		new ShapeXPlaneGen().generateShape(dx+depth, dy+height, dz+width, shapeable);
		new ShapeEquilateralSquareGen().generateShape(dx+depth, dy+height+1, dz+width, shapeable);
		
		shapeable.setBlock(dx, dy+height+2, dz+width);
		shapeable.setBlock(dx, dy+height+2, dz-width);
		shapeable.setBlock(dx+depth, dy+height+2, dz);
		shapeable.setBlock(dx-depth, dy+height+2, dz);
		
		shapeable.setBlock(dx-depth, dy+height+2, dz+width);
		shapeable.setBlock(dx+depth, dy+height+2, dz+width);
		shapeable.setBlock(dx+depth, dy+height+2, dz-width);
		shapeable.setBlock(dx-depth, dy+height+2, dz-width);

	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		
		entityPos = new ChunkCoordinates(dx+entityPos.posX, dy+entityPos.posY, dz+entityPos.posZ);

		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		worldObj.setBlockToAir(entityPos.posX, entityPos.posY+height, entityPos.posZ);
		
		int y=entityPos.posY+height+1;
		while(y-->0){
			if(!worldObj.isAirBlock(entityPos.posX, y, entityPos.posZ)){
				break;
			}
			array.add(new BlockRepresentation(entityPos.posX, y, entityPos.posZ,
					openblocks.OpenBlocks.Blocks.ropeLadder.blockID,5,3));
			
		}
		
		array.addAll(specificFill(entityPos, worldObj));
		
		return array;
	}

}
