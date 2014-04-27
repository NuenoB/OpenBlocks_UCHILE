package openblocks.shapes.shapesgenerators;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import openblocks.shapes.IShapeGen;

public interface IShapeGenenratorMove extends IShapeGen {
	
	public int getSpaceToLimit();
	
	public Block getBlockToConstruct();

}
