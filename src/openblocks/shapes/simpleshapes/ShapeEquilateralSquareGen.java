package openblocks.shapes.simpleshapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;
import openmods.utils.render.GeometryUtils;

public class ShapeEquilateralSquareGen implements IShapeGen {

	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
		GeometryUtils.line2D(ySize, xSize, zSize, -xSize, zSize, shapeable);
		GeometryUtils.line2D(ySize, -xSize, zSize, -xSize, -zSize, shapeable);
		GeometryUtils.line2D(ySize, -xSize, -zSize, xSize, -zSize, shapeable);
		GeometryUtils.line2D(ySize, xSize, -zSize, xSize, zSize, shapeable);
	}

	@Override
	public ArrayList<BlockRepresentation> fill(
			ChunkCoordinates chunkCoordinates, World worldObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		//sin restricciones de construccion
		return new ArrayList<BlockRepresentation>();
	}

}
