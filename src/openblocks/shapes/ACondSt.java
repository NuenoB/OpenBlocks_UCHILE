package openblocks.shapes;

import java.util.ArrayList;

import openblocks.shapes.cond.ICondStrategy;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;

public abstract class ACondSt implements ICondStrategy {

	protected int blockId = Block.blockGold.blockID;

}
