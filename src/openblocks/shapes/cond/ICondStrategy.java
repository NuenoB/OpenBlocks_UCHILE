package openblocks.shapes.cond;

import java.util.ArrayList;

import openblocks.shapes.BlockRepresentation;

import net.minecraft.util.ChunkCoordinates;

public interface ICondStrategy {
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos); 
}
