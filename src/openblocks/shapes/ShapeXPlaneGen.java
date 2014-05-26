package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.utils.BlockNotifyFlags;
import openmods.utils.MathUtils;

public class ShapeXPlaneGen implements IShapeGen {

	@Override
	public void generateShape(int x, int height, int z, IShapeable shapeable) {


		for(int i=0; i<=x; i++){
			for(int j=0; j<=z; j++){
				shapeable.setBlock(i, height, j);
				shapeable.setBlock(-i, height, j);
				shapeable.setBlock(i, height, -j);
				shapeable.setBlock(-i, height, -j);
			}
		}
	}


	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates coord, World worldObj) {
		//Nada necesario
		return null;
	}


	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		//sin restricciones de construccion
		return new ArrayList<BlockRepresentation>();
	}

}
