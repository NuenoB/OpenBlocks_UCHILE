package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleHoleGeneratorOE implements IFactorySimpleShapeGeneratorXX{

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleRailGeneratorOE();
	}

}