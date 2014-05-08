package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import java.util.ArrayList; 

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public class SimpleWallGeneratorOEFancy extends SimpleWallGeneratorOE {
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) {
	
		super.generateShape(xSize, ySize, zSize, shapeable);
		
		shapeable.setBlock(xSize + wallDepth - 3  , ySize + wallHeight, zSize);
		shapeable.setBlock(xSize - 2 , ySize + wallHeight, zSize);
		
	}
	
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) {
		ArrayList<BlockRepresentation> oList = new ArrayList<BlockRepresentation>();
		oList.add(new BlockRepresentation(entityPos.posX + moriginX + wallDepth - 4,
										  entityPos.posY + moriginY + wallHeight , 
										  entityPos.posZ + moriginZ , 
										  Block.torchWood.blockID, 
										  0x2,
										  0));
		oList.add(new BlockRepresentation(entityPos.posX + moriginX - 1,
										  entityPos.posY + moriginY + wallHeight, 
										  entityPos.posZ + moriginZ , 
										  Block.torchWood.blockID, 
										  0x1,
										  0));
		return oList;
	}

}
