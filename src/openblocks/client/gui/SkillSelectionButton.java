package openblocks.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

/*
 * Clase para la creación de botones para las habilidades.
 */

public class SkillSelectionButton extends GuiButton{

	private int skillID;

	public SkillSelectionButton(int buttonID, int x, int y, String text, int skillID) {
		super(buttonID, x, y, text);
		this.skillID = skillID;
	}

	public SkillSelectionButton(int buttonID, int x, int y, int width, int height, String text, int skillID)
	{
		super(buttonID, x, y, width, height, text);
		this.skillID = skillID;
	}

	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		if(this.drawButton)
		{
			this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			if(this.field_82253_i) //If mouse is hovering over button
			{
				drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 0x80ffffff);
			}
		}
	}

	public int getSkillID()
	{
		return skillID;
	}
}

