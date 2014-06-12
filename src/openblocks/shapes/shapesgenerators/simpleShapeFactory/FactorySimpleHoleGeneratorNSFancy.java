package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleHoleGeneratorNSFancy implements IFactorySimpleShapeGeneratorXX{

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleRailGeneratorNSFancy();
	}

}
