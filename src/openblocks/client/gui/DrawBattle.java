package openblocks.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import openblocks.common.entity.math.EntityStats;
import net.minecraft.client.gui.GuiScreen;;

public class DrawBattle{
	static GuiScreen g= new GuiScreen();
	public static void drawRect(int x1, int y1, int x2, int y2, int color){
		g.drawRect(x1, y1, x2, y2, color);
	}
	public static void DrawHealth(EntityStats entity, int x, int y){
		int nameLength = Minecraft.getMinecraft().fontRenderer.getStringWidth(entity.getEntity().getEntityName());
		float remainingHealth= entity.getHP()/entity.getMaxHP();
		if(remainingHealth >= 100)
		{
			drawRect(x - nameLength/2 + 12, y + 10, x - nameLength/2 + 15, y + 11, 0xFF00FFFF);
			drawRect(x - nameLength/2 + 8, y + 10, x - nameLength/2 + 11, y + 11, 0xFF00FF00);
			drawRect(x - nameLength/2 + 4, y + 10, x - nameLength/2 + 7, y + 11, 0xFFFFFF00);
			drawRect(x - nameLength/2, y + 10, x - nameLength/2 + 3, y + 11, 0xFFFF0000);
			drawRect(x - nameLength/2, y + 9, x - nameLength/2 + (int)((entity.getHP() - 100.0f) / 200.0f * (float)nameLength), y + 10, 0xFFFFFFFF);
		}
		else if (remainingHealth > 50)
		{
			drawRect(x - nameLength/2 + 8, y + 10, x - nameLength/2 + 11, y + 11, 0xFF00FF00);
			drawRect(x - nameLength/2 + 4, y + 10, x - nameLength/2 + 7, y + 11, 0xFFFFFF00);
			drawRect(x - nameLength/2, y + 10, x - nameLength/2 + 3, y + 11, 0xFFFF0000);
			drawRect(x - nameLength/2, y + 9, x - nameLength/2 + (int)((entity.getHP() - 50.0f) / 50.0f * (float)nameLength), y + 10, 0xFF00FFFF);
		}
		else if (remainingHealth > 20)
		{
			drawRect(x - nameLength/2 + 4, y + 10, x - nameLength/2 + 7, y + 11, 0xFFFFFF00);
			drawRect(x - nameLength/2, y + 10, x - nameLength/2 + 3, y + 11, 0xFFFF0000);
			drawRect(x - nameLength/2, y + 9, x - nameLength/2 + (int)((entity.getHP() - 20.0f) / 30.0f * (float)nameLength), y + 10, 0xFF00FF00);
		}
		else if (remainingHealth > 10)
		{
			drawRect(x - nameLength/2, y + 10, x - nameLength/2 + 3, y + 11, 0xFFFF0000);
			drawRect(x - nameLength/2, y + 9, x - nameLength/2 + (int)((entity.getHP() - 10.0f) / 10.0f * (float)nameLength), y + 10, 0xFFFFFF00);
		}
		else
		{
			drawRect(x - nameLength/2, y + 9, x - nameLength/2 + (int)(entity.getHP() / 10.0f * (float)nameLength), y + 10, 0xFFFF0000);
		}
	}
}
	
