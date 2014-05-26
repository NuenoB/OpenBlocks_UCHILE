package openmods.gui.component;

import net.minecraft.client.Minecraft;
import openmods.sync.SyncableProgress;

import org.lwjgl.opengl.GL11;

public class GuiComponentProgress extends BaseComponent {

	private SyncableProgress progress;

	public GuiComponentProgress(int x, int y, SyncableProgress progress) {
		super(x, y);
		this.progress = progress;
	}

	@Override
	public void render(Minecraft minecraft, int offsetX, int offsetY, int mouseX, int mouseY) {
		super.render(minecraft, offsetX, offsetY, mouseX, mouseY);
		bindComponentsSheet();
		GL11.glColor3f(1, 1, 1);
		drawTexturedModalRect(offsetX + x, offsetY + y, 0, 38, getWidth(), getHeight());
		int pxProgress = (int)Math.round(getWidth() * progress.getPercent());
		drawTexturedModalRect(offsetX + x, offsetY + y, 0, 50, pxProgress, getHeight());
	}

	@Override
	public int getWidth() {
		return 29;
	}

	@Override
	public int getHeight() {
		return 12;
	}

}
