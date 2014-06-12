package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleHoleGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleHoleGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleHoleGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleHoleGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.IFactorySimpleShapeGeneratorXX;
import openblocks.shapes.shapesgenerators.towers.DummyStationFactory;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGenerator;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorE;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorFactory;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorN;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorO;
import openblocks.shapes.shapesgenerators.towers.HoleStationShapeGeneratorS;
import openblocks.shapes.shapesgenerators.towers.IStationFactory;
import openblocks.shapes.shapesgenerators.towers.RailIntermedioShapeGeneratorFactory;
import openmods.shapes.IShapeable;

public class SubwayShapeGenerator extends AbstractShape{
	
	private Subway mMain;
	private Subway mSecnd;
	private boolean isMiddel = false;
	
	@Override
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos) 
	{
		ArrayList<BlockRepresentation> objectList = new ArrayList<BlockRepresentation>();
		
		for(int cont = 1; cont < 3; cont++)
			objectList.add(new BlockRepresentation(entityPos.posX, entityPos.posY + cont, entityPos.posZ, Block.blockGold.blockID));

		return objectList;
	}
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
		isMiddel = false;
		if(xSize != 0 && zSize != 0){
			mMain = new Subway(new HoleStationShapeGeneratorFactory(), new RailIntermedioShapeGeneratorFactory());
			mSecnd = new Subway(new DummyStationFactory(),new HoleStationShapeGeneratorFactory());
			
			mMain.generateShape(0, ySize, zSize, shapeable);
			mSecnd.setRelativeOrigin(0, ySize, zSize);
			mSecnd.generateShape(xSize, ySize, 0, shapeable);
			isMiddel = true;
		}
		else{
			mMain = new Subway();
			mMain.generateShape(xSize, ySize, zSize, shapeable);
		}
	}
	
	@Override
	protected void nsLeft(IShapeable shapeable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void oeLeft(IShapeable shapeable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void nsRight(IShapeable shapeable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void oeRight(IShapeable shapeable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void turents() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getSpaceToLimit() 
	{
		return mMain.getSpaceToLimit();
	}


	@Override
	public int getBlockToConstruct() 
	{
		return mMain.getBlockToConstruct();
	}
	
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) 
	{
		ArrayList<BlockRepresentation> blockList = new ArrayList<BlockRepresentation>();
		blockList.addAll(mMain.fill(entityPos, worldObj));
		if (isMiddel)
			blockList.addAll(mSecnd.fill(entityPos, worldObj));
		return blockList;
	}
	private class Subway extends AbstractShape{
		
		protected IStationFactory mInitial;
		protected IStationFactory mFinal;
		private final int powerDistance = 5;
	
		public Subway(){
			super();
			mInitial = new HoleStationShapeGeneratorFactory();
			mFinal   = new HoleStationShapeGeneratorFactory();
		}
	
		public Subway(IStationFactory init, IStationFactory fin){
			super();
			mInitial = init;
			mFinal   = fin;
		}

		@Override
		protected void nsLeft(IShapeable shapeable) 
		{
			initX+=-3;
			finX += 3;
			for(int amount = 0; amount < powerDistance; amount++)
				mWall.add(new FactorySimpleHoleGeneratorNS());
			mWall.add(new FactorySimpleHoleGeneratorNSFancy());
			mInitialTower = mInitial.produceN();
			mFinealTower  = mFinal.produceS();
		}

		@Override
		protected void oeLeft(IShapeable shapeable) 
		{
			initZ+=-3;
			finZ += 3;
			for(int amount = 0; amount < powerDistance; amount++)
				mWall.add(new FactorySimpleHoleGeneratorOE());
			mWall.add(new FactorySimpleHoleGeneratorOEFancy());
			mInitialTower = mInitial.produceO();
			mFinealTower  = mFinal.produceE();
		}

		@Override
		protected void nsRight(IShapeable shapeable) 
		{
			initX+= 3;
			finX +=-3;
			
			for(int amount = 0; amount < powerDistance; amount++)
				mWall.add(new FactorySimpleHoleGeneratorNS());
			mWall.add(new FactorySimpleHoleGeneratorNSFancy());
			mInitialTower = mInitial.produceS();
			mFinealTower  = mFinal.produceN();
		}
		
		@Override
		protected void oeRight(IShapeable shapeable) 
		{
			initZ+= 3;
			finZ +=-3;
			for(int amount = 0; amount < powerDistance; amount++)
				mWall.add(new FactorySimpleHoleGeneratorOE());
			mWall.add(new FactorySimpleHoleGeneratorOEFancy());
			mInitialTower = mInitial.produceE();
			mFinealTower  = mFinal.produceO();
		}
		
		@Override
		protected void turents() {
			
		}

	}

}
