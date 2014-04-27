package openblocks.shapes.shapesgenerators;

import openmods.shapes.IShapeable;

public class SimpleWallGeneratorOEFancy extends SimpleWallGeneratorOE {
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) {
	
		super.generateShape(xSize, ySize, zSize, shapeable);
		
		shapeable.setBlock(xSize - 2, ySize + wallHeight, zSize);
		shapeable.setBlock(xSize + wallDepth -3, ySize + wallHeight, zSize);
		
	}

}
