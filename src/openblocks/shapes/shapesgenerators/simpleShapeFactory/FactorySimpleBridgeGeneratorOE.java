package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleBridgeGeneratorOE implements IFactorySimpleShapeGeneratorXX 
{

	@Override
	public IShapeGenenratorMove generateAWall() 
	{
		return new SimpleBridgeGeneratorOE();
	}

}
