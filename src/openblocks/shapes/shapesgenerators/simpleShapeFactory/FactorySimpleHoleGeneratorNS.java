package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;

public class FactorySimpleHoleGeneratorNS implements IFactorySimpleShapeGeneratorXX{

	@Override
	public IShapeGenenratorMove generateAWall() {
		// TODO Auto-generated method stub
		return new SimpleRailGeneratorNS();
	}

}
