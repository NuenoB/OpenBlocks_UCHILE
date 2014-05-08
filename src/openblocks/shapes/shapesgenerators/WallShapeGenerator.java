package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openblocks.shapes.shapesgenerators.simpleWallFactory.FactorySimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleWallFactory.FactorySimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleWallFactory.FactorySimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleWallFactory.FactorySimpleWallGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.simpleWallFactory.IFactorySimpleWallGeneratorXX;
import openblocks.shapes.shapesgenerators.simpleWallFactory.SimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleWallFactory.SimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleWallFactory.SimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleWallFactory.SimpleWallGeneratorOEFancy;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.MathUtils;

public class WallShapeGenerator extends AbstractShapeGeneratorMove {

	protected IShapeGenenratorMove mFinealTower;
	protected IShapeGenenratorMove mInitialTower = new TurretGenerator();
	protected IFactorySimpleWallGeneratorXX mWall;
	protected IFactorySimpleWallGeneratorXX mFancyWall;
	protected ArrayList<IShapeGenenratorMove> mListOfConstructions;
	//this value defines in which side of the tower the wall begins;
	protected double mAngleBetweenTower;
	
	protected int initX, initY, initZ;
	protected int finX, finY, finZ;
	
	protected Block mMaterialToBuild;
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
				
		//the two turret are define
		mListOfConstructions = new ArrayList<IShapeGenenratorMove>();
		mListOfConstructions.add(mInitialTower);
		mListOfConstructions.add(mFinealTower);
		mFinealTower = new TurretGenerator();
		mFinealTower.generateShape(xSize, ySize, zSize, shapeable);
		mInitialTower.generateShape(0, 0, 0, shapeable);
		// the angle that forms the distance vetor between them and the x axis, and set the values between pi/2 and -pi/2
		mAngleBetweenTower = angleBetweenm180p180(Math.atan2(zSize,xSize));
		// the coordinates of the simple wall
		initX = 0;
		initZ = 0;
		initY = 0;
		finX = xSize;
		finY = ySize;
		finZ = zSize;
		
		// the orientation of the wall
		if(Math.abs(mAngleBetweenTower) <= Math.PI/4 ){
			initX+= 4;
			finX +=-3;
			mWall = new FactorySimpleWallGeneratorNS();
			mFancyWall = new FactorySimpleWallGeneratorNSFancy();
		}
		else if(Math.abs(mAngleBetweenTower) >= 3*Math.PI/4){
			initX+= -3;
			finX += 4;
			mWall = new FactorySimpleWallGeneratorNS();
			mFancyWall = new FactorySimpleWallGeneratorNSFancy();
		}
		else if(Math.abs(mAngleBetweenTower - Math.PI/2) <= Math.PI/4){
			initZ+= 5;
			finZ +=-2;
			mWall = new FactorySimpleWallGeneratorOE();
			mFancyWall = new FactorySimpleWallGeneratorOEFancy();
		}
		else if(Math.abs(mAngleBetweenTower + Math.PI/2) <= Math.PI/4){
			initZ+=-2;
			finZ += 5;
			mWall = new FactorySimpleWallGeneratorOE();
			mFancyWall = new FactorySimpleWallGeneratorOEFancy();
		}

		if( Math.abs(zSize) >= mFinealTower.getSpaceToLimit() || Math.abs(xSize) > mFinealTower.getSpaceToLimit())
			wallParts(ySize, initX, initZ, finX, finZ, mWall, mFancyWall, shapeable);
		
	}
		
	static public double angleBetweenm180p180(double angle)
	{
		if(Math.abs(angle) <= Math.PI)
			return angle;
		else if(angle > Math.PI)
			return angleBetweenm180p180(-2*Math.PI + angle);
		else
			return angleBetweenm180p180(2*Math.PI + angle);
	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,World worldObj) 
	{
		ArrayList<BlockRepresentation> blockList = new ArrayList<BlockRepresentation>();
		for(IShapeGenenratorMove shape : mListOfConstructions)
			blockList.addAll(shape.fill(entityPos, worldObj));
		return blockList;
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos) 
	{
		ArrayList<BlockRepresentation> objectList = new ArrayList<BlockRepresentation>();
		for(IShapeGenenratorMove construction : mListOfConstructions)
			objectList.addAll(construction.fillConditions(entityPos));
		
		return objectList;
	}

	@Override
	public int getSpaceToLimit() 
	{
		return mFinealTower.getSpaceToLimit();
	}


	@Override
	public Block getBlockToConstruct() {
		return mFinealTower.getBlockToConstruct();
	}

	private void wallParts(int y, int x0, int z0, int x1, int z1, IFactorySimpleWallGeneratorXX wall, IFactorySimpleWallGeneratorXX fancyWall,IShapeable shapeable) {
		int dx = Math.abs(x1 - x0), sx = x0 < x1? 1 : -1;
		int dy = -Math.abs(z1 - z0), sy = z0 < z1? 1 : -1;
		int err = dx + dy, e2;
		IShapeGenenratorMove drawMe = wall.generateAWall();
		
		int cambio = 1;

		for (;;) {
			drawMe.generateShape(x0, y, z0, shapeable);
			mListOfConstructions.add(drawMe);
			if (x0 == x1 && z0 == z1) break;
			e2 = 2 * err;
			if (e2 >= dy) {
				err += dy;
				x0 += sx;
			} /* e_xy+e_x > 0 */
			if (e2 <= dx) {
				err += dx;
				z0 += sy;
			} /* e_xy+e_y < 0 */
			cambio*=-1;
			if(cambio > 0)
				drawMe = wall.generateAWall();
			else
				drawMe = fancyWall.generateAWall();
		}
	}

}
