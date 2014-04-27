package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.MathUtils;

public class WallShapeGenerator implements IShapeGenenratorMove {

	protected IShapeGenenratorMove mFinealTower;
	protected IShapeGenenratorMove mWall;
	protected IShapeGenenratorMove mFancyWall;
	
	//this value defines in which side of the tower the wall begins;
	protected double mAngleBetweenTower;
	
	protected int initX, initY, initZ;
	protected int finX, finY, finZ;
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
				
		mFinealTower = new TurretGenerator();
		mFinealTower.generateShape(xSize, ySize, zSize, shapeable);
		new TurretGenerator().generateShape(0, 0, 0, shapeable);
		mAngleBetweenTower = angleBetweenm180p180(Math.atan2(zSize,xSize));
		
		initX = 0;
		initZ = 0;
		initY = 0;
		finX = xSize;
		finY = ySize;
		finZ = zSize;
		
		
		if(Math.abs(mAngleBetweenTower) <= Math.PI/4 ){
			initX = 2;
			finX -= 3;
			mWall = new SimpleWallGeneratorNS();
			mFancyWall = new SimpleWallGeneratorNSFancy();
		}
		else if(Math.abs(mAngleBetweenTower) >= 3*Math.PI/4){
			initX = -3;
			finX += 2;
			mWall = new SimpleWallGeneratorNS();
			mFancyWall = new SimpleWallGeneratorNSFancy();
		}
		else if(Math.abs(mAngleBetweenTower - Math.PI/2) <= Math.PI/4){
			initZ = 3;
			finZ -= 2;
			mWall = new SimpleWallGeneratorOE();
			mFancyWall = new SimpleWallGeneratorOEFancy();
		}
		else if(Math.abs(mAngleBetweenTower + Math.PI/2) <= Math.PI/4){
			initZ = -2;
			finZ += 3;
			mWall = new SimpleWallGeneratorOE();
			mFancyWall = new SimpleWallGeneratorOEFancy();
		}

		wallParts(ySize, initX, initZ, finX, finZ, mWall, mFancyWall, shapeable);
		
	}
		
	static public double angleBetweenm180p180(double angle){
		if(Math.abs(angle) <= Math.PI)
			return angle;
		else if(angle > Math.PI)
			return angleBetweenm180p180(-2*Math.PI + angle);
		else
			return angleBetweenm180p180(2*Math.PI + angle);
	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpaceToLimit() {
		return mFinealTower.getSpaceToLimit();
	}


	@Override
	public Block getBlockToConstruct() {
		return mFinealTower.getBlockToConstruct();
	}

	public void wallParts(int y, int x0, int z0, int x1, int z1, IShapeGenenratorMove wall, IShapeGenenratorMove fancyWall,IShapeable shapeable) {
		int dx = Math.abs(x1 - x0), sx = x0 < x1? 1 : -1;
		int dy = -Math.abs(z1 - z0), sy = z0 < z1? 1 : -1;
		int err = dx + dy, e2;
		IShapeGenenratorMove drawMe = wall;
		
		int cambio = 1;

		for (;;) {
			drawMe.generateShape(x0, y, z0, shapeable);
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
				drawMe = wall;
			else
				drawMe = fancyWall;
		}
	}

}
