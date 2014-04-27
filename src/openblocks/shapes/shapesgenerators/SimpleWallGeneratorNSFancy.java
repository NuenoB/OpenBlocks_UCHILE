package openblocks.shapes.shapesgenerators;

import openmods.shapes.IShapeable;

public class SimpleWallGeneratorNSFancy extends SimpleWallGeneratorNS {
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize,IShapeable shapeable) {
	
		super.generateShape(xSize, ySize, zSize, shapeable);
		shapeable.setBlock(xSize, ySize + wallHeight, zSize - 1);
		shapeable.setBlock(xSize, ySize + wallHeight, zSize + wallDepth - 2);
		
	}

}
