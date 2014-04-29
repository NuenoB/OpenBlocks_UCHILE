package openblocks.common.block;

import openblocks.Config;
import openblocks.common.block.BlockGuide.Icons;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockMine extends OpenBlock{

	public BlockMine() {
		super(Config.blockMineId, Material.iron);
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public boolean shouldRenderBlock() {
		return true;
	}

	@Override
	public boolean useTESRForInventory() {
		return false;
	}
	
	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
		return true;
	}

	@Override
	public void registerIcons(IconRegister registry) {
		Icons.ends = registry.registerIcon("openblocks:guide");
		Icons.side = registry.registerIcon("openblocks:guide_side");

		setTexture(ForgeDirection.UP, Icons.ends);
		setTexture(ForgeDirection.DOWN, Icons.ends);
		setTexture(ForgeDirection.EAST, Icons.side);
		setTexture(ForgeDirection.WEST, Icons.side);
		setTexture(ForgeDirection.NORTH, Icons.side);
		setTexture(ForgeDirection.SOUTH, Icons.side);
		setDefaultTexture(Icons.ends);
	}
}


