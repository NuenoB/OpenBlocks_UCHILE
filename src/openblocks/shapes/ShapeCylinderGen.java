package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeable;
import openmods.utils.MathUtils;

public class ShapeCylinderGen implements IShapeGen {

	@Override
	public void generateShape(int radiusX, int height, int radiusZ, IShapeable shapeable) {
		
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

				for (int y = 0; y < height; ++y) {
					if((y==0 || y==1) && x==radiusX && z==0){
						shapeable.setBlock(-x, y, z);
						continue;
					}
					shapeable.setBlock(x, y, z);
					shapeable.setBlock(-x, y, z);
					shapeable.setBlock(x, y, -z);
					shapeable.setBlock(-x, y, -z);
				}
			}
		}

	}
	

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates coord, World worldObj) {
			//Poner una puerta en la base
			ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
			
			array.add(new BlockRepresentation(coord.posX+3, coord.posY,
					coord.posZ, Block.doorWood.blockID, 1, 2));
			array.add(new BlockRepresentation(coord.posX+3, coord.posY+1,
					coord.posZ, Block.doorWood.blockID, 8, 2));
			
			return array;
		
	}


	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		//sin restricciones de construccion
		return new ArrayList<BlockRepresentation>();
	}


}
