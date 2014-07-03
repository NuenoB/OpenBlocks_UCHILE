package openblocks.shapes.shapesgenerators;

import java.awt.Point;
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
	private int xMiddle,zMiddle;
	
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
			xMiddle = xSize;
			zMiddle = zSize;
		}
		else{
			mMain = new Subway();
			mMain.generateShape(xSize, ySize, zSize, shapeable);
		}
	}
	
	@Override
	protected void nsLeft(IShapeable shapeable) {}

	@Override
	protected void oeLeft(IShapeable shapeable) {}

	@Override
	protected void nsRight(IShapeable shapeable) {}

	@Override
	protected void oeRight(IShapeable shapeable) {}

	@Override
	protected void turents() {}
	
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
		if (isMiddel){
			blockList.addAll(mSecnd.fill(entityPos, worldObj));
			int xil,xfl,zil,zfl,xir,xfr,zir,zfr;
			
			xil =-2;
			xir = 2;
			
			zil = zir = zMiddle + (zMiddle>0?-2:2);
			
			xfr = xfl = (xMiddle>0?2:-2);
			
			zfl = zMiddle + 2;
			zfr = zMiddle - 2;
			
			if ((xir != xfr || zir != zfr) && (xil != xfl || zil != zfl)){
				int tmp = xfr;
				xfr = xfl;
				xfl = tmp;
				
				tmp = zfr;
				zfr = zfl;
				zfl = tmp;
			}
			
			blockList.add(new BlockRepresentation(
					entityPos.posX + moriginX + xil,
					entityPos.posY + moriginY - 6, 
					entityPos.posZ + moriginZ + zil, 
					Block.rail.blockID, 
					0x4,
					0));
			
			blockList.add(new BlockRepresentation(
					entityPos.posX + moriginX + xir,
					entityPos.posY + moriginY - 6, 
					entityPos.posZ + moriginZ + zir, 
					Block.rail.blockID, 
					0x4,
					0));
			
			blockList.add(new BlockRepresentation(
					entityPos.posX + moriginX + xfl,
					entityPos.posY + moriginY - 6, 
					entityPos.posZ + moriginZ + zfl, 
					Block.rail.blockID, 
					0x4,
					0));
			
			blockList.add(new BlockRepresentation(
					entityPos.posX + moriginX + xfr,
					entityPos.posY + moriginY - 6, 
					entityPos.posZ + moriginZ + zfr, 
					Block.rail.blockID, 
					0x4,
					0));
			
			for(int cont = zil; cont != zfl; cont+= zil>zfl?-1:1){
				blockList.add(new BlockRepresentation(
						entityPos.posX + moriginX + xil,
						entityPos.posY + moriginY - 6, 
						entityPos.posZ + moriginZ + cont, 
						Block.rail.blockID, 
						0x4,
						0));
			}
			
			for(int cont = zir; cont != zfr; cont+= zir>zfr?-1:1){
				blockList.add(new BlockRepresentation(
						entityPos.posX + moriginX + xir,
						entityPos.posY + moriginY - 6, 
						entityPos.posZ + moriginZ + cont, 
						Block.rail.blockID, 
						0x4,
						0));
			}
			
			for(int cont = xil; cont != xfl; cont+= xil>xfl?-1:1){
				blockList.add(new BlockRepresentation(
						entityPos.posX + moriginX + cont,
						entityPos.posY + moriginY - 6, 
						entityPos.posZ + moriginZ + zfl, 
						Block.rail.blockID, 
						0x4,
						0));
			}
			
			for(int cont = xir; cont != xfr; cont+= xir>xfr?-1:1){
				blockList.add(new BlockRepresentation(
						entityPos.posX + moriginX + cont,
						entityPos.posY + moriginY - 6, 
						entityPos.posZ + moriginZ + zfr, 
						Block.rail.blockID, 
						0x4,
						0));
			}
			
		}
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
		protected void turents() {}
		

	}

}
