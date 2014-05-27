package openblocks.common.tileentity;

import java.util.ArrayList;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.common.ForgeDirection;
import openblocks.api.IShapeProvider;
import openblocks.shapes.BlockRepresentation;
import openblocks.shapes.BuildingShapes;
import openblocks.shapes.GuideShape;
import openmods.Log;
import openmods.api.IActivateAwareTile;
import openmods.shapes.IShapeable;
import openmods.sync.ISyncableObject;
import openmods.sync.SyncableInt;
import openmods.tileentity.SyncedTileEntity;
import openmods.utils.BlockNotifyFlags;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityMine extends SyncedTileEntity implements IShapeable, IShapeProvider, IActivateAwareTile {

	private boolean shape[][][];
	private boolean previousShape[][][];
	private float timeSinceChange = 0; 

	protected SyncableInt width;
	protected SyncableInt height;
	protected SyncableInt depth;
	protected SyncableInt mode;
	
	protected SyncableInt mnMoveW;
	protected SyncableInt mnMoveH;
	protected SyncableInt mnMoveD;

	public TileEntityMine() {}

	@Override
	protected void createSyncedFields() {
		width = new SyncableInt(8);
		height = new SyncableInt(13);
		depth = new SyncableInt(8);
		mode = new SyncableInt(1);
		mnMoveW = new SyncableInt(0);
		mnMoveH = new SyncableInt(0); 
		mnMoveD = new SyncableInt(0);
	}

	public int getWidth() {
		return width.getValue();
	}

	public int getHeight() {
		return height.getValue();
	}

	public int getDepth() {
		return depth.getValue();
	}

	public void setWidth(int w) {
		width.setValue(w);
	}

	public void setDepth(int d) {
		depth.setValue(d);
	}

	public void setHeight(int h) {
		height.setValue(h);
	}

	public BuildingShapes getCurrentMode() {
		return BuildingShapes.values()[mode.getValue()];
	}

	@Override
	public void updateEntity() {
		if (worldObj.isRemote) {
			if (timeSinceChange < 1.0) {
				timeSinceChange = (float)Math.min(1.0f, timeSinceChange + 0.1);
			}
		}
	}

	public float getTimeSinceChange() {
		return timeSinceChange;
	}

	private void recreateShape() {
		previousShape = shape;
		shape = new boolean[getHeight() * 2 + 1][getWidth() * 2 + 1][getDepth() * 2 + 1];
		getCurrentMode().generator.generateShape(mnMoveW.getValue(), mnMoveH.getValue(), mnMoveD.getValue(), this);
		timeSinceChange = 0;
	}

	@Override
	public void setBlock(int x, int y, int z) {
		try {
			/*Log.warn(new Throwable(){
				@Override
				public synchronized Throwable fillInStackTrace() {
					return null;
				}
			}, "Index  setting block at %d,%d,%d", getHeight() + y, getWidth() + x ,getDepth() + z);*/
			shape[getHeight() + y][getWidth() + x][getDepth() + z] = true;
		} catch (IndexOutOfBoundsException iobe) {
			Log.warn(iobe, "Cube dimensions %d,%d,%d", getWidth() , getHeight(), getDepth() );
			Log.warn(iobe, "Cube dimensions real %d,%d,%d", shape[0].length , shape.length, shape[0][0].length );
			Log.warn(iobe, "Index out of bounds setting block at %d,%d,%d", getWidth() + x, getHeight() + y, getDepth() + z);
		}
	}

	public boolean[][][] getShape() {
		return shape;
	}

	public boolean[][][] getPreviousShape() {
		return previousShape;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		AxisAlignedBB box = super.getRenderBoundingBox();
		return box.expand(getWidth(), getHeight(), getDepth());
	}

	private void switchMode(EntityPlayer player) {
		switchMode();
		player.sendChatToPlayer(ChatMessageComponent.createFromTranslationWithSubstitutions("openblocks.misc.change_mode", getCurrentMode().getLocalizedName()));
	}

	private void switchMode() {
		int nextMode = mode.getValue() + 1;
		if (nextMode >= GuideShape.values().length) {
			nextMode = 0;
		}
		mode.setValue(nextMode);
		if (getCurrentMode().fixedRatio) {
			setHeight(getWidth());
			setDepth(getWidth());
		}
		recreateShape();
		sync();
	}

	private void changeDimensions(EntityPlayer player, ForgeDirection orientation) {
		changeDimensions(orientation);
		player.sendChatToPlayer(ChatMessageComponent.createFromTranslationWithSubstitutions("openblocks.misc.change_pose", mnMoveW.getValue(), mnMoveH.getValue(), mnMoveD.getValue()));
	}

	private void changeDimensions(ForgeDirection orientation) {
		if (orientation == ForgeDirection.EAST) {
			mnMoveW.modify(1);
		} 
		else if (orientation == ForgeDirection.WEST) {
			mnMoveW.modify(-1);
		} 
		else if (orientation == ForgeDirection.NORTH) {
			mnMoveD.modify(-1);
		} 
		else if (orientation == ForgeDirection.SOUTH) {
			mnMoveD.modify(1);
		} 
		else if (orientation == ForgeDirection.UP) {
			mnMoveH.modify(1);
		} 
		else if (orientation == ForgeDirection.DOWN) {
			mnMoveH.modify(-1);
		}
		
		// se if the wall fits in the current cube, if not make it bigger
		if(Math.abs(mnMoveD.getValue()) + getCurrentMode().generator.getSpaceToLimit() >= depth.getValue())
			depth.setValue(Math.abs(mnMoveD.getValue())+ getCurrentMode().generator.getSpaceToLimit());
		if(Math.abs(mnMoveH.getValue()) >= height.getValue())
			height.setValue(Math.abs(mnMoveH.getValue())+1);
		if(Math.abs(mnMoveW.getValue()) + getCurrentMode().generator.getSpaceToLimit()>= width.getValue())
			width.setValue(Math.abs(mnMoveW.getValue())+ getCurrentMode().generator.getSpaceToLimit());
		
		if (getCurrentMode().fixedRatio) {
			int h = getHeight();
			int w = getWidth();
			int d = getDepth();
			if (w != h && w != d) {
				setHeight(w);
				setDepth(w);
			} else if (h != w && h != d) {
				depth.setValue(h);
				width.setValue(h);
			} else if (d != w && d != h) {
				width.setValue(d);
				height.setValue(d);
			}
		}
		recreateShape();
		if (!worldObj.isRemote) {
			sync();
		}
	}

	@Override
	public ChunkCoordinates[] getShapeCoordinates() {
		if (shape == null) {
			recreateShape();
		}
		ArrayList<ChunkCoordinates> coords = new ArrayList<ChunkCoordinates>();
		if (shape != null) {
			for (int y2 = 0; y2 < shape.length; y2++) {
				for (int x2 = 0; x2 < shape[y2].length; x2++) {
					for (int z2 = 0; z2 < shape[y2][x2].length; z2++) {
						if (shape[y2][x2][z2]) {
							coords.add(new ChunkCoordinates(xCoord + x2
									- getWidth(), yCoord + y2 - getHeight(), zCoord
									+ z2 - getDepth()));
						}
					}
				}
			}
		}
		return coords.toArray(new ChunkCoordinates[coords.size()]);
	}

	@Override
	public void onSynced(Set<ISyncableObject> changes) {
		recreateShape();
	}

	private void fill(EntityPlayer player, int side) {

		final Block itemBlock = getCurrentMode().generator.getBlockToConstruct();
		
		int cont = 1;
		ArrayList<BlockRepresentation> conditions = getCurrentMode().generator.fillConditions(new ChunkCoordinates(xCoord,yCoord,zCoord)); 
		
		for(BlockRepresentation block: conditions)
		{
			worldObj.destroyBlock(xCoord, yCoord + cont, zCoord, false);
			cont++;
		}

		for (ChunkCoordinates coord : getShapeCoordinates())
			worldObj.setBlock(coord.posX, coord.posY, coord.posZ, itemBlock.blockID, 0, BlockNotifyFlags.ALL);
		
		for(BlockRepresentation iteratorBlock:getCurrentMode().generator.fill( new ChunkCoordinates(xCoord,yCoord,zCoord) , worldObj))
			worldObj.setBlock(iteratorBlock.getCoord().posX, iteratorBlock.getCoord().posY, iteratorBlock.getCoord().posZ, 
					          iteratorBlock.getBlockId(), 
					          iteratorBlock.getMetaData(), 
					          iteratorBlock.getFlags());
	}

	@Override
	public boolean onBlockActivated(EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (worldObj.isRemote) return true;

		if (player.isSneaking()) switchMode(player);
		else if (player.capabilities.isCreativeMode && isInFillMode()) fill(player, side);
		else changeDimensions(player, ForgeDirection.getOrientation(side));

		return true;
	}

	private boolean isInFillMode() 
	{
		int cont = 1;
		ArrayList<BlockRepresentation> conditions = getCurrentMode().generator.fillConditions(new ChunkCoordinates(xCoord,yCoord,zCoord));
		
		for(;;)
		{
			int block = worldObj.getBlockId(xCoord, yCoord + cont, zCoord);
			if( worldObj.isAirBlock(xCoord, yCoord + cont, zCoord))
				break;
			for(BlockRepresentation oneBlock:conditions)
			{
				if(oneBlock.getBlockId() == block)
				{
					conditions.remove(oneBlock);
					break;
				}					
			}
			
			if(conditions.isEmpty())
				break;
			cont++;
		}
		return conditions.isEmpty();
	}
}
