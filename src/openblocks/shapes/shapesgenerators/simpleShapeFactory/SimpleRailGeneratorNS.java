package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public class SimpleRailGeneratorNS extends AbstractSimpleHoleGenerator{

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z,
			IShapeable shapeable) {
		shapeable.setBlock(xSize, ySize + y, zSize + z);
		
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) 
	{
		ArrayList<BlockRepresentation> oList = super.fill(entityPos, worldObj);
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
										  entityPos.posY + moriginY - holeHeight, 
										  entityPos.posZ + moriginZ + holeDepth, 
										  getRailId(), 
										  0x0,
										  0));
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
										  entityPos.posY + moriginY - holeHeight, 
										  entityPos.posZ + moriginZ - holeDepth, 
										  getRailId(), 
										  0x0,
										  0));
		
		for(int cont = -1; cont <= hight;cont++){
			oList.add(new BlockRepresentation(
					  entityPos.posX + moriginX ,
					  entityPos.posY + moriginY - holeHeight + cont, 
					  entityPos.posZ + moriginZ + holeDepth + 1, 
					  getWallId(), 
					  0x0,
					  0));
			oList.add(new BlockRepresentation(
					  entityPos.posX + moriginX ,
					  entityPos.posY + moriginY - holeHeight + cont, 
					  entityPos.posZ + moriginZ - holeDepth - 1, 
					  getWallId(), 
					  0x0,
					  0));
		}
		
		for(int cont = -holeDepth; cont <= holeDepth; cont++){
			oList.add(new BlockRepresentation(
					  entityPos.posX + moriginX ,
					  entityPos.posY + moriginY - holeHeight + hight, 
					  entityPos.posZ + moriginZ + cont, 
					  getWallId(), 
					  0x0,
					  0));
		}
		
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
				  entityPos.posY + moriginY - holeHeight - 1, 
				  entityPos.posZ + moriginZ + holeDepth, 
				  getUnderRailId(), 
				  0x0,
				  0));

		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
			  	  entityPos.posY + moriginY - holeHeight - 1, 
			  	  entityPos.posZ + moriginZ - holeDepth, 
			  	  getUnderRailId(), 
			  	  0x0,
			  	  0));
		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
				  entityPos.posY + moriginY - holeHeight - 1, 
				  entityPos.posZ + moriginZ + holeDepth - 1, 
				  getWallId(), 
				  0x0,
				  0));

		oList.add(new BlockRepresentation(entityPos.posX + moriginX ,
			  	  entityPos.posY + moriginY - holeHeight - 1, 
			  	  entityPos.posZ + moriginZ - holeDepth + 1, 
			  	  getWallId(), 
			  	  0x0,
			  	  0));

		return oList;
		
		
	}
	
	protected int getRailId(){
		return Block.rail.blockID;
	}
	
	protected int getWallId(){
		return Block.brick.blockID;
	}
	
	protected int getUnderRailId(){
		return getWallId();
	}
	

}
