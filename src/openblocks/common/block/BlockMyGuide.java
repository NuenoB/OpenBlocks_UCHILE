package openblocks.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import openblocks.Config;

public class BlockMyGuide extends AbstractOurBlock {

	public static class Icons {
		public static Icon ends;
	}

	public BlockMyGuide() {
		super(Config.blockMyGuideId, Material.ground);
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
	public void registerIcons(IconRegister registry) {
		Icons.ends = registry.registerIcon("openblocks:guide");

		setTexture(ForgeDirection.UP, Icons.ends);
		setTexture(ForgeDirection.DOWN, Icons.ends);
		setTexture(ForgeDirection.EAST, Icons.ends);
		setTexture(ForgeDirection.WEST, Icons.ends);
		setTexture(ForgeDirection.NORTH, Icons.ends);
		setTexture(ForgeDirection.SOUTH, Icons.ends);
		setDefaultTexture(Icons.ends);
	}

	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
		return false;
	}

}
