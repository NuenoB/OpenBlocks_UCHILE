package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import openblocks.shapes.shapesgenerators.IShapeGenenratorMove;
 
public class FactorySimpleWallGeneratorOEFancy implements
		IFactorySimpleShapeGeneratorXX {

	@Override
	public IShapeGenenratorMove generateAWall() {
		return new SimpleWallGeneratorOEFancy();
	}

}
