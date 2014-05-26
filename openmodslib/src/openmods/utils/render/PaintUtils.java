package openmods.utils.render;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import openmods.Mods;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class PaintUtils {

	private Set<Integer> allowed;

	public static final PaintUtils instance = new PaintUtils();

	protected PaintUtils() {
		allowed = new HashSet<Integer>();
		allowed.add(Block.stone.blockID);
		allowed.add(Block.cobblestone.blockID);
		allowed.add(Block.cobblestoneMossy.blockID);
		allowed.add(Block.sandStone.blockID);
		allowed.add(Block.blockIron.blockID);
		allowed.add(Block.stoneBrick.blockID);
		allowed.add(Block.glass.blockID);
		allowed.add(Block.planks.blockID);
		allowed.add(Block.dirt.blockID);
		allowed.add(Block.wood.blockID);
		allowed.add(Block.blockGold.blockID);
		allowed.add(Block.blockEmerald.blockID);
		allowed.add(Block.blockLapis.blockID);
		allowed.add(Block.blockNetherQuartz.blockID);
		allowed.add(Block.whiteStone.blockID);
		if (Loader.isModLoaded(Mods.TINKERSCONSTRUCT)) {
			addBlocksForMod(Mods.TINKERSCONSTRUCT, new String[] {
					"GlassBlock",
					"decoration.multibrick",
					"decoration.multibrickfancy"
			});
		}
		if (Loader.isModLoaded(Mods.EXTRAUTILITIES)) {
			addBlocksForMod(Mods.EXTRAUTILITIES, new String[] {
					"greenScreen",
					"extrautils:decor"
			});
		}
		if (Loader.isModLoaded(Mods.BIOMESOPLENTY)) {
			addBlocksForMod(Mods.BIOMESOPLENTY, new String[] {
					"bop.planks"
			});
		}
	}

	protected void addBlocksForMod(String modId, String[] blocks) {
		for (String blockName : blocks) {
			Block block = GameRegistry.findBlock(modId, blockName);
			if (block != null) {
				allowed.add(block.blockID);
			}
		}
	}

	public boolean isAllowedToReplace(Block block) {
		if (block == null || block.canProvidePower()) return false;
		return allowed.contains(block.blockID);
	}

	public boolean isAllowedToReplace(World world, int x, int y, int z) {
		int id = world.getBlockId(x, y, z);
		if (world.isAirBlock(x, y, z)) { return false; }
		Block block = Block.blocksList[id];
		return isAllowedToReplace(block);
	}
}
