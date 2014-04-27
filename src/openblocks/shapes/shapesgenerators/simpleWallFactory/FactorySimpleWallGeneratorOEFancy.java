package openblocks.shapes.shapesgenerators.simpleWallFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleWallGeneratorOEFancy implements
		IFactorySimpleWallGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorOEFancy();
	}

}
