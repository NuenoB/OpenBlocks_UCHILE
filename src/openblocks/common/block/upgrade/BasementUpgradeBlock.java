package openblocks.common.block.upgrade;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import openblocks.Config;
import openblocks.common.block.upgrade.AbstractUpgradeBlock.Icons;
import openblocks.shapes.BlockRepresentation;

public class BasementUpgradeBlock extends AbstractUpgradeBlock {

	private int x0, z0, x1, z1, y;

	private int floors = 1;
	private int orientation = 0;

	private final int[] xArr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	private final int[] zArr = { 1, 1, 0, -1, -1, -1, 0, 1 };
	private final int[] stairs = { 1, 3, 0, 2 };

	public static class Icons {
		public static Icon ends;
		public static Icon side;
	}

	public BasementUpgradeBlock() {
		super(Config.blockBasementUpgrade, 1);
		this.x0 = -4;
		this.z0 = -4;
		this.x1 = 4;
		this.z1 = 4;
		this.y = 4;
	}

	@Override
	public void abstResgisterIcons(IconRegister registry) {
		Icons.ends = registry.registerIcon("openblocks:xpdrain");
		Icons.side = registry.registerIcon("openblocks:drawingtable_front");

		setTexture(ForgeDirection.UP, Icons.ends);
		setTexture(ForgeDirection.DOWN, Icons.ends);
		setTexture(ForgeDirection.EAST, Icons.side);
		setTexture(ForgeDirection.WEST, Icons.side);
		setTexture(ForgeDirection.NORTH, Icons.side);
		setTexture(ForgeDirection.SOUTH, Icons.side);
		setDefaultTexture(Icons.ends);

	}

	@Override
	public ArrayList<BlockRepresentation> getList(ChunkCoordinates entityPos) {

		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		
		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY -1, 1 + entityPos.posZ, 0));
		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY -1, entityPos.posZ, 0));
		array.add(new BlockRepresentation(entityPos.posX, entityPos.posY -1, - 1 + entityPos.posZ, 0));
		array.add(new BlockRepresentation(1 + entityPos.posX, entityPos.posY -1, 1 + entityPos.posZ, 0));
		array.add(new BlockRepresentation(1 + entityPos.posX, entityPos.posY -1, entityPos.posZ, 0));
		array.add(new BlockRepresentation(1 + entityPos.posX, entityPos.posY -1, -1 + entityPos.posZ, 0));
		array.add(new BlockRepresentation(-1 + entityPos.posX, entityPos.posY -1, 1 + entityPos.posZ, 0));
		array.add(new BlockRepresentation(-1 + entityPos.posX, entityPos.posY -1, entityPos.posZ, 0));
		array.add(new BlockRepresentation(-1 + entityPos.posX, entityPos.posY -1, -1 + entityPos.posZ, 0));
			
			
		for (int h = y; h > 1; h--) {
			for (int a = x0; a <= x1; a++) {
				for (int b = z0; b <= z1; b++) {
					array.add(new BlockRepresentation(a + entityPos.posX,
							entityPos.posY - h, b + entityPos.posZ, 0));
				}
			}
		}
		
		for (int a = x0; a <= x1; a++) {
			for (int b = z0; b <= z1; b++) {
				array.add(new BlockRepresentation(a + entityPos.posX,
						entityPos.posY - y - 1, b + entityPos.posZ, Block.stoneBrick.blockID));
			}
		}
		

		for (int j = -floors; j < 0; j++) {
			for (int i = 0; i < 4; i++) {
				array.add(new BlockRepresentation(entityPos.posX
						+ xArr[(i % 4) * 2], entityPos.posY + i
						+ (j * 4), entityPos.posZ
						+ zArr[(i % 4) * 2],
						Block.stairsStoneBrick.blockID, stairs[i], 3));
				array.add(new BlockRepresentation(entityPos.posX
						+ xArr[((i % 4) * 2) + 1],
						entityPos.posY + i + (j * 4), entityPos.posZ
						+ zArr[((i % 4) * 2) + 1],
						Block.stone.blockID));
			}
		}

		return array;

	}

	@Override
	public void setRecipe(List<IRecipe> recipeList) {

	}

	@Override
	public ChunkCoordinates setDeltas() {
		return new ChunkCoordinates(0, -9, 0);
	}

}
