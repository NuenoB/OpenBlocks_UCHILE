package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import openblocks.shapes.newshapes.*;
import openblocks.shapes.simpleshapes.CopyShape;
import openblocks.shapes.simpleshapes.FloorShape;
import openblocks.shapes.simpleshapes.FourWallGen;
import openblocks.shapes.simpleshapes.ShapeXPlaneGen;
import openblocks.shapes.simpleshapes.SimpleWallShape;

/**
 * Enumeracion de los distintos tipos de bloque fantasma
 * @author Agustín Antoine
 *
 */
public enum MyGuideShape {
	Copy(false, new CopyShape(), "CopyShape"),
	CastleTower(false, new CastleTowerGen(3,0,5), "Castle Tower"),
	Castle(false, new CastleGen(), "Castle"),
	House(false, new LittleHouseGen(0,8,0), "House");


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