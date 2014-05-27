package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import java.util.ArrayList; 

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public class SimpleWallGeneratorNSFancy extends SimpleWallGeneratorNS {
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) {
	
		super.generateShape(xSize, ySize, zSize, shapeable);
		shapeable.setBlock(xSize, ySize + wallHeight, zSize - 1);
		shapeable.setBlock(xSize, ySize + wallHeight, zSize + wallDepth - 2);
		
	}
	
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) {
		ArrayList<BlockRepresentation> oList = new ArrayList<BlockRepresentation>();
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
										  entityPos.posY + moriginY + wallHeight , 
										  entityPos.posZ + moriginZ , 
										  Block.torchWood.blockID, 
										  0x3,
										  0));
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
										  entityPos.posY + moriginY + wallHeight, 
										  entityPos.posZ + moriginZ +wallDepth- 3, 
										  Block.torchWood.blockID, 
										  0x4,
										  0));
		return oList;
	}
	
}
