package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleWallGeneratorOE implements
		IFactorySimpleShapeGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorOE();
	}

}
