package openblocks.shapes.shapesgenerators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public abstract class AbstractShapeGeneratorMove implements IShapeGenenratorMove {



	protected int moriginX = 0;
	protected int moriginY = 0;
	protected int moriginZ = 0;
	
	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		
		return new ArrayList<BlockRepresentation>();
	}
}
