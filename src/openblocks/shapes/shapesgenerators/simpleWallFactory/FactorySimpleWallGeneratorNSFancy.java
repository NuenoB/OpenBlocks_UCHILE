package openblocks.shapes.shapesgenerators.simpleWallFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleWallGeneratorNSFancy implements
		IFactorySimpleWallGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorNSFancy();
	}

}
