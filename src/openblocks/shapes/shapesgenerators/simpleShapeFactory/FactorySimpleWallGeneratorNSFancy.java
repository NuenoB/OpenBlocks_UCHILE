package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleWallGeneratorNSFancy implements
		IFactorySimpleShapeGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorNSFancy();
	}

}
