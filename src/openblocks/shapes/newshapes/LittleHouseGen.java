package openblocks.shapes.newshapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.AShape;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.cond.ICondStrategy;
import openblocks.shapes.cond.OneBlockSt;
import openblocks.shapes.simpleshapes.FloorShape;
import openblocks.shapes.simpleshapes.FourWallGen;
import openmods.shapes.IShapeable;

public class LittleHouseGen extends AShape{

	private int x0 = -2;
	private int z0 = -4;
	private int x1 = 3;
	private int z1 = 5;
	private int height = 4;
	private int dy = 0;
	
	
	public LittleHouseGen(int dx, int dy, int dz) {
		super(new OneBlockSt());
		this.dy=dy;
		x0+=dx;
		x1+=dx;
		z0+=dz;
		z1+=dz;
	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		//ventanas
		array.add(new BlockRepresentation(entityPos.posX+x0+2,entityPos.posY+height, entityPos.posZ+z0+2, Block.glass.blockID));
		array.add(new BlockRepresentation(entityPos.posX+x0+3,entityPos.posY+height, entityPos.posZ+z0+2, Block.glass.blockID));
		array.add(new BlockRepresentation(entityPos.posX+x0+2,entityPos.posY+height, entityPos.posZ+z0+3, Block.glass.blockID));
		array.add(new BlockRepresentation(entityPos.posX+x0+3,entityPos.posY+height, entityPos.posZ+z0+3, Block.glass.blockID));
		
		array.add(new BlockRepresentation(entityPos.posX+x0+2,entityPos.posY+height, entityPos.posZ+z0+6, Block.glass.blockID));
		array.add(new BlockRepresentation(entityPos.posX+x0+3,entityPos.posY+height, entityPos.posZ+z0+6, Block.glass.blockID));
		array.add(new BlockRepresentation(entityPos.posX+x0+2,entityPos.posY+height, entityPos.posZ+z0+7, Block.glass.blockID));
		array.add(new BlockRepresentation(entityPos.posX+x0+3,entityPos.posY+height, entityPos.posZ+z0+7, Block.glass.blockID));
		
		//puerta
		array.add(new BlockRepresentation(entityPos.posX+x0+2, entityPos.posY+dy,
				entityPos.posZ+z0+9, Block.doorWood.blockID, 3, 2));
		array.add(new BlockRepresentation(entityPos.posX+x0+2, entityPos.posY+1+dy,
				entityPos.posZ+z0+9, Block.doorWood.blockID, 8, 2));
		
		
		return array;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		new FourWallGen(x0, z0, x1, z1, height).generateShape(xSize, dy, zSize, shapeable);
		
		new FourWallGen(x0+1, z0+1, x0+4, z0+4, 2).generateShape(xSize, height, zSize, shapeable);
		shapeable.setBlock(x0+1, height+2, z0+1);
		shapeable.setBlock(x0+4, height+2, z0+1);
		shapeable.setBlock(x0+1, height+2, z0+4);
		shapeable.setBlock(x0+4, height+2, z0+4);
		
		new FourWallGen(x0+1, z0+5, x0+4, z0+8, 2).generateShape(xSize, height, zSize, shapeable);
		shapeable.setBlock(x0+1, height+2, z0+5);
		shapeable.setBlock(x0+1, height+2, z0+8);
		shapeable.setBlock(x0+4, height+2, z0+5);
		shapeable.setBlock(x0+4, height+2, z0+8);
		
		
	}

}
