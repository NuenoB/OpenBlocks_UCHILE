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
import openmods.utils.render.GeometryUtils;

/**
 * Generador para una escalera.
 * @author Agustin Antoine
 *
 */
public class StairsGen implements IShapeGen {

	private int floors = 3;
	private int orientation=0;
	
	private final int[] xArr = {0,-1,
								-1,-1,
								0,1,
								1,1};
	private final int[] zArr = {1,1,
								0,-1,
								-1,-1,
								0,1};
	private final int[] stairs = {1,3,0,2};
	
	/**
	 * 
	 * @param floors Cantidad de pisos que debe tener la escalera
	 * @param orientation Hacia adonde apuntan las puertas 
	 */
	public StairsGen(int floors, int orientation){
		this.floors = floors;
		//this.orientation=orientation;
	}
	

	
	
	@Override
	public void generateShape(int x, int y, int z, IShapeable shapeable) {
		
		for(int j=0; j<floors-1; j++){
			for(int i=0; i<4; i++){
				if(i==0 || i ==1){
					shapeable.setBlock(-1, i+(j*4), 2);
					shapeable.setBlock(0, i+(j*4), 2);
				}
				else{
					GeometryUtils.line2D(i+(j*4), -2, 2, 2, 2, shapeable);
				}
				GeometryUtils.line2D(i+(j*4), 2, 2, 2, -2, shapeable);
				GeometryUtils.line2D(i+(j*4), 2, -2, -2, -2, shapeable);
				GeometryUtils.line2D(i+(j*4), -2, -2, -2, 2, shapeable);
				shapeable.setBlock(0, i+(j*4), 0);
				
			}
		}
		
		
	}
	

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates coord, World worldObj) {	
		
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		for(int j=0; j<floors-1; j++){
			for(int i=0; i<4; i++){
				array.add(new BlockRepresentation(coord.posX+xArr[((i+orientation)%4)*2],coord.posY+ i+(j*4), coord.posZ + zArr[((i+orientation)%4)*2], Block.stairsStoneBrick.blockID,
						stairs[i],3));
				array.add(new BlockRepresentation(coord.posX+xArr[(((i+orientation)%4)*2)+1], coord.posY+ i+(j*4), coord.posZ + zArr[(((i+orientation)%4)*2)+1], Block.stone.blockID));
			}
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
