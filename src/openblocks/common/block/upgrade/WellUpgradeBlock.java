package openblocks.common.block.upgrade;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.oredict.ShapedOreRecipe;
import openblocks.Config;
import openblocks.OpenBlocks;
import openblocks.OpenBlocks.Blocks;
import openblocks.common.block.BlockScreenPrinter.Icons;
import openblocks.shapes.BlockRepresentation;

public class WellUpgradeBlock extends AbstractUpgradeBlock {
	
	private int x0, z0, x1, z1, y;

	public WellUpgradeBlock() {
		super(Config.blockWellUpgrade, 1);
		this.x0=-6;
		this.z0=-6;
		this.x1=6;
		this.z1=6;
		this.y=2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void abstResgisterIcons(IconRegister registry) {
		Icons.ends = registry.registerIcon("openblocks:grave");
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
		// TODO Auto-generated method stub
		ArrayList<BlockRepresentation> array = new ArrayList<BlockRepresentation>();
		for(int h = y; h>0;h--){
			int a;
			
			//Paredes
			for(a=x0+2; a<=x1-2;a++){
				array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-h, z0+entityPos.posZ+2, Block.stoneBrick.blockID));
				array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-h, z1+entityPos.posZ-2, Block.stoneBrick.blockID));
				
			}
			for(a=z0+2; a<=z1-2;a++){
				array.add(new BlockRepresentation(x0+entityPos.posX+2, entityPos.posY-h, a+entityPos.posZ, Block.stoneBrick.blockID));
				array.add(new BlockRepresentation(x1+entityPos.posX-2, entityPos.posY-h, a+entityPos.posZ, Block.stoneBrick.blockID));
			}
			
			for(a=x0-2; a<=x1+2;a++){
				array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-h, z0+entityPos.posZ-2, Block.stoneBrick.blockID));
				array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-h, z1+entityPos.posZ+2, Block.stoneBrick.blockID));
				
			}
			for(a=z0-2; a<=z1+2;a++){
				array.add(new BlockRepresentation(x0+entityPos.posX-2, entityPos.posY-h, a+entityPos.posZ, Block.stoneBrick.blockID));
				array.add(new BlockRepresentation(x1+entityPos.posX+2, entityPos.posY-h, a+entityPos.posZ, Block.stoneBrick.blockID));
			}
			
			
			//Agua
			for(int b = z0-1;b<=z1+1;b++){
				for(a=x0-1;a<=x0+1;a++){
					array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-(y+1), b+entityPos.posZ, Block.stoneBrick.blockID));
					array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-h, b+entityPos.posZ, Block.waterStill.blockID));
				}
				for(a=x1-1;a<=x1+1;a++){
					array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-(y+1), b+entityPos.posZ, Block.stoneBrick.blockID));
					array.add(new BlockRepresentation(a+entityPos.posX, entityPos.posY-h, b+entityPos.posZ, Block.waterStill.blockID));
				}				
			}
			
			for(int b = x0+1;b<=x1-1;b++){
				for(a=z0-1;a<=z0+1;a++){
					array.add(new BlockRepresentation(b+entityPos.posX, entityPos.posY-(y+1), a+entityPos.posZ, Block.stoneBrick.blockID));
					array.add(new BlockRepresentation(b+entityPos.posX, entityPos.posY-h, a+entityPos.posZ, Block.waterStill.blockID));
				}
				for(a=z1-1;a<=z1+1;a++){
					array.add(new BlockRepresentation(b+entityPos.posX, entityPos.posY-(y+1), a+entityPos.posZ, Block.stoneBrick.blockID));
					array.add(new BlockRepresentation(b+entityPos.posX, entityPos.posY-h, a+entityPos.posZ, Block.waterStill.blockID));					
				}				
			}
			
		}
		
		return array;
	}

	@Override
	public void setRecipe(List<IRecipe> recipeList) {
//		recipeList.add(new ShapedOreRecipe(OpenBlocks.Blocks.canbeupgradedblock, "  ", " g ", "mam", 'g', Blocks.myguide, 'm', Block.wood, 'a', Item.bucketWater));
		
	}

	@Override
	public ChunkCoordinates setDeltas() {
		return new ChunkCoordinates(0,-1,0);
	}

}
