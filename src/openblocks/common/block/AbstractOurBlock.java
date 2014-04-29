package openblocks.common.block;

import openblocks.OpenBlocks;
import net.minecraft.block.material.Material;

public abstract class AbstractOurBlock extends openmods.block.OpenBlock {

	protected AbstractOurBlock(int id, Material material) {
		super(id, material);
		setCreativeTab(OpenBlocks.ourBlockTab);
	}

	@Override
	public int getRenderType() {
		return OpenBlocks.renderId;
	}

	@Override
	protected Object getModInstance() {
		return OpenBlocks.instance;
	}

}
