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

/**
 * Generador para una, usa diferentes ShapesGenerators para definir la Torre
 * @author Agustin Antoine
 *
 */
public class TowerGen implements IShapeGen {

	private final int height = 8;
	private final int width = 3;
	private final int depth = 3;
	
	
	@Override
	public void generateShape(int x, int y, int z, IShapeable shapeable) {

		new ShapeCylinderGen().generateShape(depth, height, width, shapeable);
		new ShapeXPlaneGen().generateShape(depth, height, width, shapeable);
		new ShapeEquilateralSquareGen().generateShape(depth, height+1, width, shapeable);
		
		shapeable.setBlock(0, height+2, width);
		shapeable.setBlock(0, height+2, -width);
		shapeable.setBlock(depth, height+2, 0);
		shapeable.setBlock(-depth, height+2, 0);
		
		shapeable.setBlock(-depth, height+2, width);
		shapeable.setBlock(depth, height+2, width);
		shapeable.setBlock(depth, height+2, -width);
		shapeable.setBlock(-depth, height+2, -width);
	}
	

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates coord, World worldObj) {	
		
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		array.addAll(new ShapeCylinderGen().fill(coord, worldObj));
		//array.add(new BlockRepresentation(coord.posX-1, coord.posY+height, coord.posZ, 0, 0, 3));
		worldObj.setBlockToAir(coord.posX-1, coord.posY+height, coord.posZ);
		
		int y=coord.posY+height+1;
		while(y-->0){
			if(!worldObj.isAirBlock(coord.posX-1, y, coord.posZ)){
				break;
			}
			array.add(new BlockRepresentation(coord.posX-1, y, coord.posZ,
					openblocks.OpenBlocks.Blocks.ropeLadder.blockID,5,3));
			
		}
		for (int h = coord.posY+3; h < coord.posY+height; h=h+2) { //ventanas
			array.add(new BlockRepresentation(coord.posX+depth, h, coord.posZ, Block.glass.blockID));
			array.add(new BlockRepresentation(coord.posX-depth, h, coord.posZ, Block.glass.blockID));
			array.add(new BlockRepresentation(coord.posX, h, coord.posZ+width, Block.glass.blockID));
			array.add(new BlockRepresentation(coord.posX, h, coord.posZ-width, Block.glass.blockID));
		}
		
		return array;
		
	}


	@Override
	public ArrayList<BlockRepresentation> fillConditions(
			ChunkCoordinates entityPos) {
		
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY+1, entityPos.posZ,
				Block.blockEmerald.blockID));
		return array;
	}

}
