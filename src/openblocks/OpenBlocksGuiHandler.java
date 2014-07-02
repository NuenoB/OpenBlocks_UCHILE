package openblocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import openblocks.client.gui.GuiBattle;
import openblocks.client.gui.GuiInfoBook;
import openblocks.client.gui.GuiLuggage;
import openblocks.common.container.ContainerLuggage;
import openblocks.common.entity.EntityLuggage;
import openmods.Log;
import cpw.mods.fml.common.network.IGuiHandler;

public class OpenBlocksGuiHandler implements IGuiHandler {

	public static enum GuiId {
		luggage,
		infoBook,
		battle;

		public static final GuiId[] VALUES = GuiId.values();
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		final GuiId guiId = getGuiId(id);
		if (guiId == null) return null;

		switch (guiId) {
			case luggage:
				return new ContainerLuggage(player.inventory, (EntityLuggage)world.getEntityByID(x));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		final GuiId guiId = getGuiId(id);
		if (guiId == null) return null;

		switch (guiId) {
			case luggage:
				return new GuiLuggage(new ContainerLuggage(player.inventory, (EntityLuggage)world.getEntityByID(x)));
			case infoBook:
				return new GuiInfoBook();
			case battle:
				return new GuiBattle();
			default:
				return null;
		}
	}

	private static GuiId getGuiId(int id) {
		try {
			return GuiId.VALUES[id];
		} catch (ArrayIndexOutOfBoundsException e) {
			Log.warn("Invalid GUI id: %d", id);
			return null;
		}
	}
}
