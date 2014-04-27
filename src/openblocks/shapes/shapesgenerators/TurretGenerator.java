package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;

public class TurretGenerator implements IShapeGenenratorMove {

	//the dimensions of the tower
	int height = 6;
	int wide = 4;// this is from the center to the side
	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) {
		for(int y = 0; y <= height; y++){
			for(int x = 0; x < wide;x++)
				for(int z = 0; z < wide;z++)
					if(((z == 0 || z == wide-1 || x == 0 || x == wide-1 ) && (y <= height && y > height -2 && y!= height-1))
							|| y == height - 1
							||((Math.abs(z - x) != 0 && Math.abs(z - x) != wide-1 ) && (z == 0 || z == wide-1 || x == 0 || x == wide-1 ))&&(y <= height - 2))
						shapeable.setBlock(x-2 + xSize, y + ySize, z-1 + zSize);
		}
		shapeable.setBlock(xSize         -2, ySize + height+1, zSize       -1);
		shapeable.setBlock(xSize         -2, ySize + height+1, zSize + wide-2);
		shapeable.setBlock(xSize + wide-1-2, ySize + height+1, zSize       -1);
		shapeable.setBlock(xSize + wide-1-2, ySize + height+1, zSize + wide-2);

	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpaceToLimit() {
		return wide/2;
	}

	@Override
	public Block getBlockToConstruct() {
		return Block.stoneBrick;
	}

}
