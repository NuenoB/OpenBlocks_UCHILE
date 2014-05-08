package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleBridgeGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleBridgeGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.IFactorySimpleShapeGeneratorXX;
import openmods.shapes.IShapeable;

public class BridgShapeGenerator extends AbstractShape
{
	@Override
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos) 
	{
		ArrayList<BlockRepresentation> objectList = new ArrayList<BlockRepresentation>();

		for(int cont = 1; cont < 3; cont++)
			objectList.add(new BlockRepresentation(entityPos.posX, entityPos.posY + cont, entityPos.posZ, Block.blockGold.blockID));

		return objectList;
	}


	@Override
	protected void nsLeft() 
	{
		initX-= mFinealTower.getSpaceToLimit();
		finX += mFinealTower.getSpaceToLimit();
		mWall = new FactorySimpleBridgeGeneratorNS();
		mFancyWall = new FactorySimpleBridgeGeneratorNS();
	}

	@Override
	protected void oeLeft() 
	{
		initZ-= mFinealTower.getSpaceToLimit();
		finZ += mFinealTower.getSpaceToLimit();
		mWall = new FactorySimpleBridgeGeneratorOE();
		mFancyWall = new FactorySimpleBridgeGeneratorOE();
	}

	@Override
	protected void nsRight() 
	{
		initX+= mFinealTower.getSpaceToLimit();
		finX -= mFinealTower.getSpaceToLimit();
		mWall = new FactorySimpleBridgeGeneratorNS();
		mFancyWall = new FactorySimpleBridgeGeneratorNS();
	}

	@Override
	protected void oeRight() 
	{
		initZ+= mFinealTower.getSpaceToLimit();
		finZ -= mFinealTower.getSpaceToLimit();
		mWall = new FactorySimpleBridgeGeneratorOE();
		mFancyWall = new FactorySimpleBridgeGeneratorOE();
	}

	@Override
	protected void turents() 
	{
		mFinealTower = new BridgeTurrentGeneretor();
		mInitialTower = new BridgeTurrentGeneretor();
	}
	

}
