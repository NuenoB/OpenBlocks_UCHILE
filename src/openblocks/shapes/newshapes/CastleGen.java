package openblocks.shapes.newshapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.AShape;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.cond.ICondStrategy;
import openblocks.shapes.cond.TwoBlockSt;
import openblocks.shapes.simpleshapes.FourWallGen;
import openmods.shapes.IShapeable;

public class CastleGen extends AShape {
	
	private int x0 = -6;
	private int z0 = -6;
	private int x1 = 7;
	private int z1 = 7;
	private int floor = 2;

	public CastleGen() {
		super(new TwoBlockSt());		
	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		return array;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		new FourWallGen(x0, z0, x1, z1, 8).generateShape(xSize, 0, zSize, shapeable);
		//new CastleTowerGen(-7, 0, -6).generateShape(xSize, ySize, zSize, shapeable);

	}

}
