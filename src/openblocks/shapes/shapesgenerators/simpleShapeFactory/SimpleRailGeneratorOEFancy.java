package openblocks.shapes.shapesgenerators.simpleShapeFactory;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.BlockRepresentation;

public class SimpleRailGeneratorOEFancy extends SimpleRailGeneratorOE {
	
	protected int getRailId(){
		return Block.railPowered.blockID;
	}
	
	protected int getWallId(){
		return Block.glass.blockID;
	}
	
	protected int getUnderRailId(){
		return Block.blockRedstone.blockID;
	}

}
