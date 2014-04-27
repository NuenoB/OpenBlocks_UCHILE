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
	
	//this value defines in which side of the tower the wall begins;
	protected double mAngleBetweenTower;
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
				
		mFinealTower = new TurretGenerator();
		mFinealTower.generateShape(xSize, ySize, zSize, shapeable);
		new TurretGenerator().generateShape(0, 0, 0, shapeable);
		mAngleBetweenTower = angleBetweenm180p180(Math.atan2(zSize,xSize));
		
		if(Math.abs(mAngleBetweenTower) <= Math.PI/4 )
			shapeable.setBlock(3, 0, 0);
		else if(Math.abs(mAngleBetweenTower) >= 3*Math.PI/4)
			shapeable.setBlock(-4, 0, 0);
		else if(Math.abs(mAngleBetweenTower - Math.PI/2) <= Math.PI/4)
			shapeable.setBlock(0, 0, 5);
		else if(Math.abs(mAngleBetweenTower + Math.PI/2) <= Math.PI/4)
			shapeable.setBlock(0, 0, -6);
		
		
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


}
