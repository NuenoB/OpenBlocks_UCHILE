package openblocks.shapes.newshapes;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import openblocks.shapes.AShape;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.IShapeGen;
import openblocks.shapes.cond.ICondStrategy;
import openblocks.shapes.cond.TwoBlockSt;
import openblocks.shapes.simpleshapes.FloorShape;
import openblocks.shapes.simpleshapes.FourWallGen;
import openmods.shapes.IShapeable;
import openmods.words.IGenerator;

public class CastleGen extends AShape {
	
	private int x0 = -6;
	private int z0 = -6;
	private int x1 = 7;
	private int z1 = 7;
	private int floor = 2;
	
	private IShapeGen stairs = new StairsGen(3, 0);
	private IShapeGen tower1 = new CastleTowerGen(-x1, 0, z0);
	private IShapeGen tower2 = new CastleTowerGen(x1+1, 0, z0);
	private IShapeGen tower3 = new CastleTowerGen(x1+1, 0, z1);
	private IShapeGen tower4 = new CastleTowerGen(-x1, 0, z1);
	private IShapeGen roofRoom = new LittleHouseGen(0, 8, 0);
	
	private final int[] xArr = {x0,x0,
								x0,x0,
								x1,x1,
								x1,x1};
	
	private final int[] zArr = {z0,z0+1,
								z1,z1-1,
								z1,z1-1,
								z0,z0+1};

	public CastleGen() {
		super(new TwoBlockSt());		
	}

	@Override
	public ArrayList<BlockRepresentation> fill(ChunkCoordinates entityPos,
			World worldObj) {
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		array.addAll(stairs.fill(entityPos, worldObj));
		array.addAll(tower1.fill(entityPos, worldObj));
		array.addAll(tower2.fill(entityPos, worldObj));
		array.addAll(tower3.fill(entityPos, worldObj));
		array.addAll(tower4.fill(entityPos, worldObj));
		array.addAll(roofRoom.fill(entityPos, worldObj));	
		
		
		//entradas para los torreones
		for(int i = 0; i<4; i++){
			worldObj.setBlockToAir(xArr[i*2]+entityPos.posX, entityPos.posY, zArr[i*2]+entityPos.posZ);
			worldObj.setBlockToAir(xArr[i*2+1]+entityPos.posX, entityPos.posY, zArr[i*2+1]+entityPos.posZ);
			worldObj.setBlockToAir(xArr[i*2]+entityPos.posX, 1+entityPos.posY, zArr[i*2]+entityPos.posZ);
			worldObj.setBlockToAir(xArr[i*2+1]+entityPos.posX, 1+entityPos.posY, zArr[i*2+1]+entityPos.posZ);
		}
		
		//ventanas
		for(int i = 0; i<2; i++){
			int var;
			int j;
			for(j=0; j<2; j++){
				if(j==0) var=x0;
				else var=x1;
				
				array.add(new BlockRepresentation(entityPos.posX+var, entityPos.posY+(i*4)+1, entityPos.posZ+z0+3, Block.glass.blockID));
				array.add(new BlockRepresentation(entityPos.posX+var, entityPos.posY+(i*4)+1, entityPos.posZ+z0+4, Block.glass.blockID));
				array.add(new BlockRepresentation(entityPos.posX+var, entityPos.posY+(i*4)+1, entityPos.posZ+z0+6, Block.glass.blockID));
				array.add(new BlockRepresentation(entityPos.posX+var, entityPos.posY+(i*4)+1, entityPos.posZ+z0+7, Block.glass.blockID));
				array.add(new BlockRepresentation(entityPos.posX+var, entityPos.posY+(i*4)+1, entityPos.posZ+z0+9, Block.glass.blockID));
				array.add(new BlockRepresentation(entityPos.posX+var, entityPos.posY+(i*4)+1, entityPos.posZ+z0+10, Block.glass.blockID));
			}
			
			array.add(new BlockRepresentation(entityPos.posX+x0+6, entityPos.posY+(i*4)+1, entityPos.posZ+z1, Block.glass.blockID));
			array.add(new BlockRepresentation(entityPos.posX+x0+7, entityPos.posY+(i*4)+1, entityPos.posZ+z1, Block.glass.blockID));
			
		}
		
		return array;
	}

	@Override
	public void generateShape(int xSize, int ySize, int zSize,
			IShapeable shapeable) {
		
		//escalera
		stairs.generateShape(xSize, ySize, zSize, shapeable);
		
		//pared
		new FourWallGen(x0, z0, x1, z1, 8).generateShape(xSize, 0, zSize, shapeable);
		
		//torreones
		tower1.generateShape(xSize, ySize, zSize, shapeable);
		tower2.generateShape(xSize, ySize, zSize, shapeable);
		tower3.generateShape(xSize, ySize, zSize, shapeable);
		tower4.generateShape(xSize, ySize, zSize, shapeable);
		
		//habitacion techo
		roofRoom.generateShape(xSize, ySize, zSize, shapeable);
		
		//pisos
		for(int i=0; i<2; i++){
			new FloorShape(x0+4, z0, x1-5, z0+3).generateShape(xSize, (i*4)+3, zSize, shapeable);
			new FloorShape(x0+4, z1-4, x1-5, z1).generateShape(xSize, (i*4)+3, zSize, shapeable);
			new FloorShape(x1-4, z0, x1, z1).generateShape(xSize, (i*4)+3, zSize, shapeable);
			new FloorShape(x0, z0, x0+3, z1).generateShape(xSize, (i*4)+3, zSize, shapeable);
		}

	}

}
