package openblocks.shapes.cond;

import java.util.ArrayList;

import openblocks.shapes.ACondSt;
import openblocks.shapes.BlockRepresentation;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;

public class OneBlockSt extends ACondSt{

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();

		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY+1, entityPos.posZ,
				blockId));
		return array;
	}

}
