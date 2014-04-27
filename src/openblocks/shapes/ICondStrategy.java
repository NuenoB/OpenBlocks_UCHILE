package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;

public interface ICondStrategy {
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates entityPos); 
}
