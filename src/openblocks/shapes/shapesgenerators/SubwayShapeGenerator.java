package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleHoleGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleHoleGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorE;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorN;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorO;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorS;
import openmods.shapes.IShapeable;

public class SubwayShapeGenerator extends AbstractShape{
	
	@Override
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos) 
	{
		ArrayList<BlockRepresentation> objectList = new ArrayList<BlockRepresentation>();

		for(int cont = 1; cont < 3; cont++)
			objectList.add(new BlockRepresentation(entityPos.posX, entityPos.posY + cont, entityPos.posZ, Block.blockGold.blockID));

		return objectList;
	}

	@Override
	protected void nsLeft(IShapeable shapeable) 
	{
		initX+=-3;
		finX += 3;
		mWall      = new FactorySimpleHoleGeneratorNS();
		mFancyWall = new FactorySimpleHoleGeneratorNS();
		mInitialTower = new HoleStationShapeGeneratorN();
		mFinealTower  = new HoleStationShapeGeneratorS();
	}

	@Override
	protected void oeLeft(IShapeable shapeable) 
	{
		initZ+=-3;
		finZ += 3;
		mWall      = new FactorySimpleHoleGeneratorOE();
		mFancyWall = new FactorySimpleHoleGeneratorOE();
		mInitialTower = new HoleStationShapeGeneratorO();
		mFinealTower  = new HoleStationShapeGeneratorE();
	}

	@Override
	protected void nsRight(IShapeable shapeable) 
	{
		initX+= 3;
		finX +=-3;
		mWall      = new FactorySimpleHoleGeneratorNS();
		mFancyWall = new FactorySimpleHoleGeneratorNS();
		mInitialTower = new HoleStationShapeGeneratorS();
		mFinealTower  = new HoleStationShapeGeneratorN();
	}

	@Override
	protected void oeRight(IShapeable shapeable) 
	{
		initZ+= 3;
		finZ +=-3;
		mWall     = new FactorySimpleHoleGeneratorOE();
		mFancyWall = new FactorySimpleHoleGeneratorOE();
		mInitialTower = new HoleStationShapeGeneratorE();
		mFinealTower  = new HoleStationShapeGeneratorO();
	}

	@Override
	protected void turents() {}


	


}
