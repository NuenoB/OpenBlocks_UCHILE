package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNS;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorNSFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOE;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.FactorySimpleWallGeneratorOEFancy;
import openblocks.shapes.shapesgenerators.simpleShapeFactory.IFactorySimpleShapeGeneratorXX;
import openmods.shapes.IShapeable;

public abstract class AbstractShape extends AbstractShapeGeneratorMove 
{
	protected IShapeGenenratorMove mFinealTower;
	protected IShapeGenenratorMove mInitialTower;
	protected IShapeGenenratorMove mMiddleTower;
	protected List <IFactorySimpleShapeGeneratorXX> mWall;

	protected ArrayList<IShapeGenenratorMove> mListOfConstructions;
	//this value defines in which side of the tower the wall begins;
	protected double mAngleBetweenTower;
	
	protected int minitX = 0, minitY = 0, minitZ = 0;
	protected int initX, initY, initZ;
	protected int finX, finY, finZ;

	
	protected Block mMaterialToBuild;
	
	public void setRelativeOrigin(int x, int y, int z){
		minitX = x;
		minitY = y;
		minitZ = z;
	}
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) 
	{				
		//the two turret are define
		mListOfConstructions = new ArrayList<IShapeGenenratorMove>();
		mWall = new ArrayList <IFactorySimpleShapeGeneratorXX>();
		
		turents();
		
		// the angle that forms the distance vetor between them and the x axis, and set the values between pi/2 and -pi/2
		mAngleBetweenTower = angleBetweenm180p180(Math.atan2(zSize,xSize));
		// the coordinates of the simple wall
		initX = 0 + minitX;
		initZ = 0 + minitZ;
		initY = 0 + minitY;
		finX = xSize + minitX;
		finY = ySize + minitY;
		finZ = zSize + minitZ;
		
		// the orientation of the wall
		if(Math.abs(mAngleBetweenTower) <= Math.PI/4 )
		{
			nsRight(shapeable);
		}
		else if(Math.abs(mAngleBetweenTower) >= 3*Math.PI/4)
		{
			nsLeft(shapeable);
		}
		else if(Math.abs(mAngleBetweenTower - Math.PI/2) <= Math.PI/4)
		{
			oeRight(shapeable);
		}
		else if(Math.abs(mAngleBetweenTower + Math.PI/2) <= Math.PI/4)
		{
			oeLeft(shapeable);
		}
		
		mFinealTower.generateShape(xSize + minitX, ySize + minitY, zSize + minitZ, shapeable);
		mInitialTower.generateShape(0, 0, 0, shapeable);
		mListOfConstructions.add(mInitialTower);
		mListOfConstructions.add(mFinealTower);

		if( Math.abs(zSize) >= mFinealTower.getSpaceToLimit() || Math.abs(xSize) > mFinealTower.getSpaceToLimit())
			wallParts(ySize, initX, initZ, finX, finZ, mWall, shapeable);
		
	}
	
	abstract protected void nsLeft(IShapeable shapeable);
	abstract protected void oeLeft(IShapeable shapeable);
	abstract protected void nsRight(IShapeable shapeable);
	abstract protected void oeRight(IShapeable shapeable);
	abstract protected void turents();
		
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
	public int getBlockToConstruct() 
	{
		return mFinealTower.getBlockToConstruct();
	}

	protected void wallParts(int y, int x0, int z0, int x1, int z1, List <IFactorySimpleShapeGeneratorXX> wall,IShapeable shapeable) 
	{
		int dx = Math.abs(x1 - x0), sx = x0 < x1? 1 : -1;
		int dy = -Math.abs(z1 - z0), sy = z0 < z1? 1 : -1;
		int err = dx + dy, e2;
		int selectOne = 0;
		IShapeGenenratorMove drawMe = wall.get(selectOne).generateAWall();
		
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
			selectOne = (selectOne + 1) % wall.size();
			drawMe = wall.get(selectOne).generateAWall();
			
		}
	}

	@Override
	public int getSpaceToTop() 
	{
		return mFinealTower.getSpaceToTop();
	}

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z,IShapeable shapeable) 
	{
		
	}

}
