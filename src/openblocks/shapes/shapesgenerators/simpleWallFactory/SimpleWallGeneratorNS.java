package openblocks.shapes.shapesgenerators.simpleWallFactory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;
import openmods.shapes.IShapeable;

public class SimpleWallGeneratorNS extends AbstractSimpleWallGenerator {

	@Override
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z, IShapeable shapeable) {
		shapeable.setBlock(xSize, ySize + y, zSize + z - 1);
		
	}



}
