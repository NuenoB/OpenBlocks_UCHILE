package openblocks.shapes.simpleshapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;
import openmods.utils.render.GeometryUtils;

public class SimpleWallShape implements IShapeGen {
	
	private int x0, x1, z0, z1, height;
	
	/**
	 * 
	 * @param x0 X0
	 * @param z0 Z0
	 * @param x1 X1
	 * @param z1 Z1
	 * @param height Height
	 */
	public SimpleWallShape(int x0, int z0, int x1, int z1, int height){
		this.x0=x0;
		this.x1=x1;
		this.z0=z0;
		this.z1=z1;
		this.height=height;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		for(int i = ySize; i<height+ySize; i++){
			GeometryUtils.line2D(i, x0, z0, x1, z1, shapeable);
		}

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
