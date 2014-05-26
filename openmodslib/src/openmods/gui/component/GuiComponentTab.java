package openmods.gui.component;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiComponentTab extends GuiComponentBox {

	protected static RenderItem itemRenderer = new RenderItem();
	protected GuiComponentTabs container;
	protected int expandedWidth;
	protected int expandedHeight;
	private boolean active = false;
	private ItemStack iconStack;
	private double dWidth;
	private double dHeight;

	public GuiComponentTab(int color, ItemStack iconStack, int expandedWidth, int expandedHeight) {
		super(0, 0, 24, 24, 0, 5, color);
		this.expandedWidth = expandedWidth;
		this.expandedHeight = expandedHeight;
		this.iconStack = iconStack;
		this.dWidth = 24.0;
		this.dHeight = 24.0;
	}

	@Override
	public void renderTopLeftCorner(int offsetX, int offsetY) {}

	@Override
	public void renderBottomLeftCorner(int offsetX, int offsetY) {}

	@Override
	public void renderLeftEdge(int offsetX, int offsetY) {}

	@Override
	public void render(Minecraft minecraft, int offsetX, int offsetY, int mouseX, int mouseY) {
		double targetWidth = active? expandedWidth : 24;
		double targetHeight = active? expandedHeight : 24;
		if (width != targetWidth) {
			dWidth += (targetWidth - dWidth) / 4;
		}
		if (height != targetHeight) {
			dHeight += (targetHeight - dHeight) / 4;
		}
		width = (int)Math.round(dWidth);
		height = (int)Math.round(dHeight);
		renderChildren = active && width == targetWidth
				&& height == targetHeight;
		super.render(minecraft, offsetX, offsetY, mouseX, mouseY);

		GL11.glColor4f(1, 1, 1, 1);
		RenderHelper.enableGUIStandardItemLighting();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		itemRenderer.zLevel = zLevel + 50; // <- critical! Must be >= 50
		itemRenderer.renderItemIntoGUI(minecraft.fontRenderer, minecraft.getTextureManager(), iconStack,
				offsetX + x + 3, offsetY + y + 3);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glDisable(GL11.GL_LIGHTING);
	}

	@Override
	public void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
		// This method is only ever called if it's hovered.
		// New logic FTW! -NC

		// We do however wish to stop expansion and contraction outside the
		// 24x24 button area
		if (x > 24 || y > 24) return;
		container.onTabClicked(this);
	}

	public void setContainer(GuiComponentTabs container) {
		this.container = container;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
