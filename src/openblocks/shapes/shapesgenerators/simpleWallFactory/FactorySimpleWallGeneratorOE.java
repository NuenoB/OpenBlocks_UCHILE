package openblocks.shapes.shapesgenerators.simpleWallFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleWallGeneratorOE implements
		IFactorySimpleWallGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorOE();
	}

}
