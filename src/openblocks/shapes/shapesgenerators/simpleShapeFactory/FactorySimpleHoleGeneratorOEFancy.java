package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleHoleGeneratorOEFancy implements IFactorySimpleShapeGeneratorXX{

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleRailGeneratorOEFancy();
	}

}