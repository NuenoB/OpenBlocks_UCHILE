package openblocks.shapes.simpleshapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;

public class FourWallGen implements IShapeGen {
	
	private int x0, x1, z0, z1, height;
	
	public FourWallGen(int x0, int z0, int x1, int z1, int height){
		this.x0=x0;
		this.x1=x1;
		this.z0=z0;
		this.z1=z1;
		this.height=height;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		new SimpleWallShape(x0, z0, x0, z1, height).generateShape(xSize, ySize, zSize, shapeable);
		new SimpleWallShape(x0, z1, x1, z1, height).generateShape(xSize, ySize, zSize, shapeable);
		new SimpleWallShape(x1, z1, x1, z0, height).generateShape(xSize, ySize, zSize, shapeable);
		new SimpleWallShape(x1, z0, x0, z0, height).generateShape(xSize, ySize, zSize, shapeable);

	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		// TODO Auto-generated method stub
		return  new ArrayList<BlockRepresentation>();
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		// TODO Auto-generated method stub
		return  new ArrayList<BlockRepresentation>();
	}

}
