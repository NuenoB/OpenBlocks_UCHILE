package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openmods.shapes.IShapeable;

public class SimpleBridgeGeneratorNS extends AbstractSimpleBridgeGenerator {

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z,IShapeable shapeable) 
	{
		shapeable.setBlock(xSize, ySize + y, zSize + z - bridgeDepth/2);
	}

}
