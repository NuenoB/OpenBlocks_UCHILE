package openblocks.shapes.simpleshapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;

public class FloorShape implements IShapeGen {
	
	private int x0, x1, z0, z1;
	
	public FloorShape(int x0, int z0, int x1, int z1){
		this.x0=x0;
		this.x1=x1;
		this.z0=z0;
		this.z1=z1;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
			
		for(int i=x0; i<=x1; i++){
			for(int j=z0; j<=z1; j++){
				shapeable.setBlock(i, 0, j);
			}	
		}

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

}
