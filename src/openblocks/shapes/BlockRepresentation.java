package openblocks.shapes;

import net.minecraft.util.ChunkCoordinates;

public class BlockRepresentation {
	private ChunkCoordinates coord;
	private int blockId;
	private int metaData;
	private int flags;
	
	public BlockRepresentation(int x, int y, int z, int id, int metaData, int flags){
		this.blockId=id;
		this.coord = new ChunkCoordinates(x,y,z);
		this.metaData=metaData;
		this.flags=flags;
	}
	
	public BlockRepresentation(int x, int y, int z, int id){
		this.blockId=id;
		this.coord = new ChunkCoordinates(x,y,z);
		this.metaData=0;
		this.flags=3;
	}

	public ChunkCoordinates getCoord() {
		return coord;
	}

	public int getBlockId() {
		return blockId;
	}

	public int getMetaData() {
		return metaData;
	}

	public int getFlags() {
		return flags;
	}

}
