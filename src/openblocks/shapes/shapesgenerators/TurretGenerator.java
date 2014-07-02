package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;
 
public class TurretGenerator extends AbstractShapeGeneratorMove {

	//the dimensions of the tower
	final int height = 6;
	final int wide = 6;// this is from the center to the side
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
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos) 
	{
		ArrayList<BlockRepresentation> objectList = new ArrayList<BlockRepresentation>();
		
		for(int cont = 1; cont <= 3; cont++)
			objectList.add(new BlockRepresentation(entityPos.posX, entityPos.posY + cont, entityPos.posZ, Block.blockGold.blockID));
		
		return objectList;
	}

	@Override
	public int getSpaceToLimit() 
	{
		return wide;
	}

	@Override
	public Block getBlockToConstruct() 
	{
		return Block.stoneBrick;
	}

	@Override
	public int getSpaceToTop() 
	{
		return height + 1;
	}

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z, IShapeable shapeable) 
	{
		
	}

	
}
