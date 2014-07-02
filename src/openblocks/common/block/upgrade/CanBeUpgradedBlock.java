package openblocks.common.block.upgrade;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import openblocks.Config;
import openblocks.OpenBlocks;
import openblocks.common.block.OpenBlock;
import openblocks.common.block.upgrade.AbstractUpgradeBlock.Icons;

public class CanBeUpgradedBlock extends OpenBlock {
	
	private static class Icons {
		public static Icon ends;
		public static Icon side;
	}

	public CanBeUpgradedBlock() {
		super(Config.blockCanBeUpgraded, Material.ground);
		// TODO Auto-generated constructor stub
		this.setBlockUnbreakable();
	}

	@Override
	public boolean shouldRenderBlock() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public boolean useTESRForInventory() {
		return false;
	}
	
	@Override
	public void registerIcons(IconRegister registry) {
		Icons.ends = registry.registerIcon("openblocks:blockPlacer");
		Icons.side = registry.registerIcon("openblocks:blockBreaker_active");

		setTexture(ForgeDirection.UP, Icons.ends);
		setTexture(ForgeDirection.DOWN, Icons.ends);
		setTexture(ForgeDirection.EAST, Icons.side);
		setTexture(ForgeDirection.WEST, Icons.side);
		setTexture(ForgeDirection.NORTH, Icons.side);
		setTexture(ForgeDirection.SOUTH, Icons.side);
		setDefaultTexture(Icons.ends);

	}

	

}
