package openblocks.shapes;

import net.minecraft.util.StatCollector;
import openmods.shapes.*;

/**
 * Enumeracion de los distintos tipos de bloque fantasma
 * @author OpenBlocks
 *
 */
public enum MyGuideShape {
	Cylinder(false, new ShapeCylinderGenerator(), "cylinder"),
	Cuboid(false, new ShapeCuboidGenerator(), "cuboid");

	public final String unlocalizedName;
	public final boolean fixedRatio;
	public final IShapeGenerator generator;

	private MyGuideShape(boolean fixedRatio, IShapeGenerator generator, String name) {
		this.unlocalizedName = "openblocks.misc.shape." + name;
		this.fixedRatio = fixedRatio;
		this.generator = generator;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal(unlocalizedName);
	}
}