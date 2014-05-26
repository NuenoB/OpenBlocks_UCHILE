package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeable;

public abstract class AShape implements IShapeGen {

	private ICondStrategy strategy;
	
	public AShape(ICondStrategy strategy){
		setStrategy(strategy);
	}

	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		return getStrategy().fillConditions(entityPos);
	}

	private ICondStrategy getStrategy() {
		return strategy;
	}

	private void setStrategy(ICondStrategy strategy) {
		this.strategy = strategy;
	}

}
