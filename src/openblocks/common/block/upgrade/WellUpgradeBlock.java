package openblocks.common.block.upgrade;

import java.util.ArrayList;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.common.ForgeDirection;
import openblocks.Config;
import openblocks.common.block.BlockScreenPrinter.Icons;
import openblocks.shapes.BlockRepresentation;

public class WellUpgradeBlock extends AbstractUpgradeBlock {

	public WellUpgradeBlock() {
		super(Config.blockWellUpgrade, 1, 0, 0, 0);
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
		
		return array;
	}

}
