package openblocks.shapes.shapesgenerators;

import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.MathUtils;

public class WallShapeGenerator implements IShapeGenerator {

	int mOriginX;
	int mOriginZ;
	
	int mTowerRX = 5;
	int mTowerRZ = 5;
	int mTowerH = 5;
	
	int mWallThigness;
	int SIZE = 4;
	@Override
	public void generateShape(int xSize, int ySize, int zSize, IShapeable shapeable) {
		
		mOriginX = xSize;
		mOriginZ = zSize;
		
		mWallThigness = ySize;
		
		//tower(mTowerRX, mTowerH, mTowerRZ,shapeable );
		bla(xSize,ySize,zSize,shapeable);
		

	}
	
	private void bla(int xSize, int ySize, int zSize,IShapeable shapeable){
		shapeable.setBlock(1,1,1);
		shapeable.setBlock(SIZE,SIZE,SIZE);
		shapeable.setBlock(-SIZE,-SIZE,-SIZE);
		shapeable.setBlock(-SIZE,SIZE,SIZE);
		shapeable.setBlock(SIZE,-SIZE,SIZE);
		shapeable.setBlock(SIZE,SIZE,-SIZE);
		shapeable.setBlock(-SIZE,-SIZE,SIZE);
		shapeable.setBlock(-SIZE,SIZE,-SIZE);
		shapeable.setBlock(SIZE,-SIZE,-SIZE);
		shapeable.setBlock(xSize,ySize,zSize);
		
	}
	private void tower(int radiusX, int height, int radiusZ, IShapeable shapeable) {
		if (height == 0) { return; }

		final double invRadiusX = 1.0 / (radiusX + 0.5);
		final double invRadiusZ = 1.0 / (radiusZ + 0.5);

		double nextXn = 0;
		forX: for (int x = 0; x <= radiusX; ++x) {
			final double xn = nextXn;
			nextXn = (x + 1) * invRadiusX;
			double nextZn = 0;
			forZ: for (int z = 0; z <= radiusZ; ++z) {
				final double zn = nextZn;
				nextZn = (z + 1) * invRadiusZ;

				double distanceSq = MathUtils.lengthSq(xn, zn);
				if (distanceSq > 1) {
					if (z == 0) {
						break forX;
					}
					break forZ;
				}

				if (MathUtils.lengthSq(nextXn, zn) <= 1
						&& MathUtils.lengthSq(xn, nextZn) <= 1) {
					continue;
				}

				for (int y = -height; y <= height; ++y) {
					shapeable.setBlock(x + mOriginX, y , z + mOriginZ);
					shapeable.setBlock(-x + mOriginX, y, z  + mOriginZ);
					shapeable.setBlock(x + mOriginX, y, -z  + mOriginZ);
					shapeable.setBlock(-x + mOriginX, y, -z  + mOriginZ);
				}
			}
		}

	}


}
