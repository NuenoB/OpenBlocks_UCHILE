package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleBridgeGeneratorNS implements
		IFactorySimpleShapeGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() 
	{
		return new SimpleBridgeGeneratorNS();
	}

}
