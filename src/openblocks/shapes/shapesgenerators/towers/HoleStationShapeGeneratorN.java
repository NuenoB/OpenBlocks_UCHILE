package openblocks.shapes.shapesgenerators.towers;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;

public class HoleStationShapeGeneratorN extends HoleStationShapeGenerator {
	
@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos, World worldObj) {
	
		ArrayList<BlockRepresentation> oList = super.fill(entityPos, worldObj);
		
		for (int cont = -2; cont < 3 ; cont++){
			if(cont == -1)
				continue;		
			oList.add(new BlockRepresentation(
					entityPos.posX + moriginX + cont,
					entityPos.posY + moriginY - height, 
					entityPos.posZ + moriginZ + 2, 
					Block.rail.blockID, 
					0x0,
					0));
		}
		
		for (int cont = -2; cont < 3 ; cont++){
			if(cont == -1)
				continue;
			oList.add(new BlockRepresentation(
					entityPos.posX + moriginX + cont,
					entityPos.posY + moriginY - height, 
					entityPos.posZ + moriginZ - 2, 
					Block.rail.blockID, 
					0x0,
					0));}
		
		for (int cont = -1; cont < 2 ; cont++){
			if (cont == 0)
				continue;
			oList.add(new BlockRepresentation(
					entityPos.posX + moriginX + 2,
					entityPos.posY + moriginY - height, 
					entityPos.posZ + moriginZ + cont, 
					Block.rail.blockID, 
					0x0,
					0));
			
		}
	
		oList.add(new BlockRepresentation(
				  entityPos.posX + moriginX - 1,
				  entityPos.posY + moriginY - height - 1, 
				  entityPos.posZ + moriginZ + 2, 
				  Block.blockRedstone.blockID, 
				  0x0,
				  0));
		
		oList.add(new BlockRepresentation(
				  entityPos.posX + moriginX - 1,
				  entityPos.posY + moriginY - height - 1, 
				  entityPos.posZ + moriginZ - 2, 
				  Block.blockRedstone.blockID, 
				  0x0,
				  0));
		
		oList.add(new BlockRepresentation(
				  entityPos.posX + moriginX + 2,
				  entityPos.posY + moriginY - height, 
				  entityPos.posZ + moriginZ , 
				  Block.railPowered.blockID, 
				  0x0,
				  0));
		
		oList.add(new BlockRepresentation(
				  entityPos.posX + moriginX - 1,
				  entityPos.posY + moriginY - height, 
				  entityPos.posZ + moriginZ + 2, 
				  Block.railPowered.blockID, 
				  0x0,
				  0));
		
		oList.add(new BlockRepresentation(
				  entityPos.posX + moriginX - 1,
				  entityPos.posY + moriginY - height, 
				  entityPos.posZ + moriginZ - 2, 
				  Block.railPowered.blockID, 
				  0x0,
				  0));
		return oList;
	}

}
