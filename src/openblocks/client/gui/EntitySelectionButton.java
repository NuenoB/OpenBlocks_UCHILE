package openblocks.client.gui;

import openblocks.common.entity.math.EntityStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;

public class EntitySelectionButton extends GuiButton {
	
	private EntityStats entityID;
	
	public EntitySelectionButton(int buttonID, int x, int y, String text, EntityStats entity) {
		super(buttonID, x, y, text);
		this.entityID= entity;
	}

	public EntitySelectionButton(int buttonID, int x, int y, int width, int height, String text, EntityStats entity) {
		super(buttonID, x, y, width, height, text);
		this.entityID= entity;
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
	
	public EntityStats getEntityID(){
		return this.entityID;
	}

}
