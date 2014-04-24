package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import openmods.shapes.*;

/**
 * Enumeracion de los distintos tipos de bloque fantasma
 * @author OpenBlocks
 *
 */
public enum MyGuideShape {
	Tower(false, new TowerGen(), "tower 1"),
	RoofCylinder(false, new ShapeCylinderGen(), "roof cylinder");


	public final String unlocalizedName;
	public final boolean fixedRatio;
	public final IShapeGen generator;

	private MyGuideShape(boolean fixedRatio, IShapeGen generator, String name) {
		this.unlocalizedName = "openblocks.misc.shape." + name;
		this.fixedRatio = fixedRatio;
		this.generator = generator;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal(unlocalizedName);
	}
	
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates chunkCoordinates, World worldObj){
		return generator.fill(chunkCoordinates, worldObj);
	}
}