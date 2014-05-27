package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openmods.shapes.IShapeable;

public class SimpleBridgeGeneratorOE extends AbstractSimpleBridgeGenerator {

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z,IShapeable shapeable) 
	{
		shapeable.setBlock(xSize + z - bridgeDepth/2, ySize + y, zSize );
	}

}
