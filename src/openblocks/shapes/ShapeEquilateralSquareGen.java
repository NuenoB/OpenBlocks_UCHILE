package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
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

}
