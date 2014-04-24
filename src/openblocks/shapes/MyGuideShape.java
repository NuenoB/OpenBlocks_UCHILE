package openblocks.shapes;

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
	RoofCylinder(false, new ShapeRoofCylinderGen(), "roof cylinder");


	public final String unlocalizedName;
	public final boolean fixedRatio;
	public final IShapebleGen generator;

	private MyGuideShape(boolean fixedRatio, IShapebleGen generator, String name) {
		this.unlocalizedName = "openblocks.misc.shape." + name;
		this.fixedRatio = fixedRatio;
		this.generator = generator;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal(unlocalizedName);
	}
	
	public void fill(ChunkCoordinates chunkCoordinates, World worldObj){
		generator.fill(chunkCoordinates, worldObj);
	}
}