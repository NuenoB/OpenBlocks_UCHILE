package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;

public class TwoBlockSt extends ACondSt {

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();

		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY+1, entityPos.posZ,
				blockId));
		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY+2, entityPos.posZ,
				blockId));
		return array;
	}

}
