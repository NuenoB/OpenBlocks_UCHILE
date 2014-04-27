package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.MathUtils;

public class WallShapeGenerator implements IShapeGenenratorMove {

	protected IShapeGenenratorMove mFinealTower;
	
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
		
		
		//tower(mTowerRX, mTowerH, mTowerRZ,shapeable );
		
		mFinealTower = new TurretGenerator();
		mFinealTower.generateShape(xSize, ySize, zSize, shapeable);
		new TurretGenerator().generateShape(0, 0, 0, shapeable);
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


}
