package openblocks.shapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.common.tileentity.TileEntityRopeLadder;
import openmods.shapes.IShapeGenerator;
import openmods.shapes.IShapeable;
import openmods.shapes.ShapeEquilateral2dGenerator;
import openmods.utils.BlockNotifyFlags;
import openmods.utils.MathUtils;


public class BigTowerGen extends ATowerShape{

	private IShapeGen body = new ShapeCylinderGen(); 
	
	/**
	 * 
	 * @param x delta x
	 * @param y delta y
	 * @param z delta z
	 */
	public BigTowerGen(int x, int y, int z) {
		super(x, y, z, 8, 3, 3);
	}

	
	
	@Override
	protected void generateBodyShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		body.generateShape(xSize, ySize, zSize, shapeable);
		
	}

	@Override
	protected ArrayList<BlockRepresentation> specificFill(
			ChunkCoordinates entityPos, World worldObj) {
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		array.addAll(body.fill(entityPos, worldObj));
		
		for (int h = entityPos.posY+3; h < entityPos.posY+height; h=h+2) { //ventanas
			array.add(new BlockRepresentation(entityPos.posX+depth, h, entityPos.posZ, Block.glass.blockID));
			array.add(new BlockRepresentation(entityPos.posX-depth, h, entityPos.posZ, Block.glass.blockID));
			array.add(new BlockRepresentation(entityPos.posX, h, entityPos.posZ+width, Block.glass.blockID));
			array.add(new BlockRepresentation(entityPos.posX, h, entityPos.posZ-width, Block.glass.blockID));
		}
		
		return array;
	}

}
