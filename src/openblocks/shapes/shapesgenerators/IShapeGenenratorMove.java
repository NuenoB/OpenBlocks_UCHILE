package openblocks.shapes.shapesgenerators;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import openblocks.shapes.IShapeGen;
import openmods.shapes.IShapeable;

public interface IShapeGenenratorMove extends IShapeGen 
{
	
	public int getSpaceToLimit();
	public int getSpaceToTop();
	
	public Block getBlockToConstruct();
	public void setBlockAux(int xSize, int ySize, int zSize, int y, int z, IShapeable shapeable);
	

}
