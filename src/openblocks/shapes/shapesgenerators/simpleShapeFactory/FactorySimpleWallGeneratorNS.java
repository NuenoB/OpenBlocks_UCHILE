package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;
 
public class FactorySimpleWallGeneratorNS implements
		IFactorySimpleShapeGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorNS();
	}

}
