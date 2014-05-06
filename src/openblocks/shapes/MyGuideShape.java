package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import openblocks.shapes.newshapes.*;
import openblocks.shapes.simpleshapes.FloorShape;
import openblocks.shapes.simpleshapes.ShapeXPlaneGen;

/**
 * Enumeracion de los distintos tipos de bloque fantasma
 * @author Agustín Antoine
 *
 */
public enum MyGuideShape {
	Tower(false, new BigTowerGen(0,0,0), "Tower"),
	CastleTower(false, new CastleTowerGen(0,0,0), "Castle Tower"),
	Stairs(false, new StairsGen(3,0), "Stairs"),
	Floor(false, new FloorShape(-1,-1,3,5), "Floor");


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
	
	public ArrayList<BlockRepresentation> fillConditions(ChunkCoordinates chunkCoordinates){
		return generator.fillConditions(chunkCoordinates);
	}
}