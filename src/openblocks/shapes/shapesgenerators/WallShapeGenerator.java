package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.IFactorySimpleShapeGeneratorXX;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.SimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.SimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.SimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.SimpleWallGeneratorOEFancy;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.MathUtils;
 
public class WallShapeGenerator extends AbstractShape 
{

		
	@Override
	protected void nsLeft(IShapeable shapeable) 
	{
		initX+= -3;
		finX += 4;
		mWall = new FactorySimpleWallGeneratorNS();
		mFancyWall = new FactorySimpleWallGeneratorNSFancy();
	}

	@Override
	protected void oeLeft(IShapeable shapeable) 
	{
		initZ+=-2;
		finZ += 5;
		mWall = new FactorySimpleWallGeneratorOE();
		mFancyWall = new FactorySimpleWallGeneratorOEFancy();
	}

	@Override
	protected void nsRight(IShapeable shapeable) 
	{
		initX+= 4;
		finX +=-3;
		mWall = new FactorySimpleWallGeneratorNS();
		mFancyWall = new FactorySimpleWallGeneratorNSFancy();
	}

	@Override
	protected void oeRight(IShapeable shapeable) 
	{
		initZ+= 5;
		finZ +=-2;
		mWall = new FactorySimpleWallGeneratorOE();
		mFancyWall = new FactorySimpleWallGeneratorOEFancy();
	}

	@Override
	protected void turents() 
	{
		mFinealTower = new TurretGenerator();
		mInitialTower = new TurretGenerator();
	}

}
