package openblocks.shapes.shapesgenerators.simpleWallFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleWallGeneratorNS implements
		IFactorySimpleWallGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorNS();
	}

}
