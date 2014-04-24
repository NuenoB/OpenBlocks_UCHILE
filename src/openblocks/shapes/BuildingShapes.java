package openblocks.shapes;

import net.minecraft.util.StatCollector;
import openblocks.shapes.shapesgenerators.WallShapeGenerator;
import openmods.shapes.IShapeGenerator;

	
public enum BuildingShapes{
	Wall(false, new WallShapeGenerator(), "wall");
	
	
	public final String unlocalizedName;
	public final boolean fixedRatio;
	public final IShapeGenerator generator;
	
	private BuildingShapes(boolean fixedRatio, IShapeGenerator generator, String name) {
		this.unlocalizedName = "openblocks.misc.shape." + name;
		this.fixedRatio = fixedRatio;
		this.generator = generator;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal(unlocalizedName);
	}
	

}
