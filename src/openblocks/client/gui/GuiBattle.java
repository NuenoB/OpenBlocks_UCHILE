package openblocks.client.gui;

import java.util.Map;
import java.util.TreeMap;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import openblocks.Config;
import openblocks.OpenBlocks;
import openblocks.common.container.ContainerAutoEnchantmentTable;
import openblocks.common.entity.math.*;
import openblocks.common.entity.math.EntityStats.Action;
import openblocks.common.skills.ISkill;
import openmods.gui.BaseGuiContainer;

public class GuiBattle extends GuiScreen {

	private int battleID;
	private EntityStats player;

	private Map<Integer,EntityStats> combatants;
	private int serverBattleSize;
	private boolean updatingCombatants;

	private int bgColor = 0x000000;
	private String info[] = new String[2];

	private boolean combatantButton = false;
	private boolean combatantButtonPopulated = false;

	private boolean turnChoiceSent;

	private int currentMenu;

	private int updateTick;
	private final int updateWaitTime = 400;

	private final int nameHeightInterval = 14;
	private boolean useSkill= false;

	public void BattleGui(int battleID, EntityStats player)
	{
		this.battleID = battleID;
		this.player = player;
		player.ready = true;

		combatants = new TreeMap<Integer,EntityStats>();
		updateTick = updateWaitTime;
	}

	/**
	 * Called automatically when the client brings up this GUIScreen.
	 */
	@Override
	public void initGui() {
		OpenBlocks.proxy.setGui(this);
		info[0] = "";
		info[1] = "";
		getMenu(-2);
		updatingCombatants = false;
		turnChoiceSent = false;
	}

	public void checkBattleInfo(boolean forceUpdate, int battleSize, boolean playerPhase, boolean turnChoiceReceived)
	{
		serverBattleSize = battleSize;
		if((!updatingCombatants && combatants.size() != battleSize) || forceUpdate)
		{
			combatants.clear();
			updatingCombatants = true;
		}
		update(playerPhase, turnChoiceReceived);
	}

	public void receiveCombatantHealthInfo(int entityID, float health)
	{
		if(!updatingCombatants)
		{
			EntityStats combatant = combatants.get(entityID);
			if(combatant != null)
				combatant.updateHealth(health);
		}
	}

	//	public void updateTurnEnd(boolean serverTurnEnded)
	//	{
	//		if(serverTurnEnded)
	//			turnChoiceSent = false;
	//	}

	public void update(boolean playerPhase, boolean turnChoiceReceived)
	{
		System.out.println("Update called, turnSentBool is" + turnChoiceSent);
		updateTick = updateWaitTime;
		if(playerPhase && !updatingCombatants)
		{
			if(turnChoiceReceived && !turnChoiceSent)
			{
				turnChoiceSent = true;
				getMenu(-2);
			}
			else if(!turnChoiceReceived && (turnChoiceSent || currentMenu == -2))
			{
				turnChoiceSent = false;
				getMenu(0);
			}
			else if(currentMenu == -2 && !turnChoiceSent)
				getMenu(0);
		}
		else
			getMenu(-2);
	}

	/**
	 * Method that draws the elements of the GUI.
	 */
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawRect(0, 0, width, height*5/6, 0xa0000000 | bgColor);
		//drawRect(0, height*6/10, width, height*5/6, 0x70000000 | bgColor);

		drawCombatants();

		super.drawScreen(par1, par2, par3);

		if(info[0] != "")
			Minecraft.getMinecraft().fontRenderer.drawString(info[0], width/2 - Minecraft.getMinecraft().fontRenderer.getStringWidth(info[0])/2, height - 90, 0xffffffff);
		if(info[1] != "")
			Minecraft.getMinecraft().fontRenderer.drawString(info[1], width/2 - Minecraft.getMinecraft().fontRenderer.getStringWidth(info[1])/2, height - 80, 0xffffffff);

		updateTick--;
		if(updateTick==0)
		{
			PacketDispatcher.sendPacketToServer(new BattleQueryPacket(battleID,(short) 0).makePacket());
			updateTick = updateWaitTime;
		}
	}

	/**
	 * Draws the combatant information on the GUIScreen.
	 */
	public void drawCombatants()
	{
		int x, y1 = height/5, y2 = height/5;
		for(EntityStats combatant : combatants.values())
		{
			if(combatant.isPlayer)
			{
				y1 += nameHeightInterval;
				x = width/8;
				drawCombatant(combatant,x,y1,0xFFFFFFFF);
			}
			else
			{
				y2 += nameHeightInterval;
				x = width * 7 / 8;
				drawCombatant(combatant,x,y2,0xFFFFFFFF);
			}
		}

		if(!combatantButtonPopulated)
			combatantButtonPopulated = true;
	}

	/**
	 * Draws a combatant on the GUIScreen based on the given parameters.
	 * @param id entityID of the combatant.
	 * @param sideOne True if the combatant is on side One.
	 * @param x X coordinate of the drawn information.
	 * @param y Y coordinate of the drawn information.
	 * @param color The color of the drawn information (when applicable).
	 */
	private void drawCombatant(EntityStats combatant, int x, int y, int color)
	{
		int nameLength = Minecraft.getMinecraft().fontRenderer.getStringWidth(combatant.name());
		if(combatantButton)
		{
			if(!combatantButtonPopulated)
			{
				if (useSkill){
					buttonList.add(new EntitySelectionButton(6, combatant.getId(), x - nameLength/2, y, nameLength + 2, 8, combatant.name()));
				}
				else{
					buttonList.add(new EntitySelectionButton(5, combatant.getId(), x - nameLength/2, y, nameLength + 2, 8, combatant.name()));
				}
			}
		}
		else
		{
			Minecraft.getMinecraft().fontRenderer.drawString(combatant.name(), x - nameLength/2, y, color);
		}

		//Draw Health
		DrawHealth(combatant,x,y);
	}

	private void DrawHealth(EntityStats entity, int x, int y) {
		DrawBattle draw= new DrawBattle();
		draw.DrawHealth(entity, x, y);
	}

	/**
	 * Displays a menu on the screen.
	 * @param menu The type of menu to display.
	 */
	public void getMenu(int menu) {
		buttonList.clear();
		info[0] = "";
		info[1] = "";
		currentMenu = menu;
		switch(menu)
		{
		case -2: //Waiting on server
			info[0] = "Waiting for server...";
			break;
		case -1: //Empty menu
			break;
		case 0: //Main menu
			info[0] = "What will you do?";
			buttonList.add(new GuiButton(1, width*2/6 - 40, height - 72, 80, 20, "Fight"));
			buttonList.add(new GuiButton(2, width*4/6 - 40, height - 72, 80, 20, "Flee"));
			break;
		case 1: //Fight menu
			info[0] = "What will you do?";
			buttonList.add(new GuiButton(3, width/6 - 40, height - 72, 80, 20, "Attack"));
			//controlList.add(new GuiButton(5, width*2/5 - 40, height - 72, 80, 20, "Use Item"));
			buttonList.add(new GuiButton(4, width*3/5 - 40, height - 72, 80, 20, "Skills"));
			buttonList.add(new GuiButton(0, width*5/6 - 40, height - 72, 80, 20, "Cancel"));
			break;
		case 2: //Flee status
			info[0] = "You attempt to flee!";
			info[1] = "Waiting for server...";
			break;
		case 3: //Attack Selection (Handled by actionPerformed method)
			info[0] = "Pick a target!";
			break;
		case 4: //Skill menu
			info[0] = "Pick a skill!";
			int i=0;
			while(player.Skills.hasNext()) //Changed weapons to skills.
			{
				buttonList.add(new GuiButton(6, width/2 - 88 + i * 20, height - 19, ""));
				i++;
			}
			buttonList.add(new GuiButton(0, width/2 - 40, height - 40, 80, 20, "Cancel"));
			break;
		case 5: //Attack Phase (Handled by actionPerformed method)
			info[0] = "You attack!";
			info[1] = "Waiting for server...";
			break;
		case 6: //Weapon Changed
			info[0] = "You used a skill!";
			info[1] = "Waiting for server...";
			break;
		default:
			break;
		}
	}

	/**
	 * This method is called automatically when a button is pressed.
	 * Calls getMenu() with the button ID.
	 */
	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == 2) //Flee
		{
			player.action = Action.FLEE;
			player.target = player;
			PacketDispatcher.sendPacketToServer(new BattleCommandPacket(battleID, player).makePacket());
			turnChoiceSent = true;
		}

		if(button.id == 3) //Show attack menu
		{
			combatantButton = true;
			useSkill= false;
			combatantButtonPopulated = false;
		}
		else if(button.id == 4) //Show skills menu
		{
			combatantButton= true;
			useSkill= true;
			combatantButtonPopulated = false;
		}
		else
			combatantButton = false;

		if(button.id == 5) //Attack phase
		{
			player.target = ((EntitySelectionButton)button).entityID;
			player.action = Action.ATTACK;
			PacketDispatcher.sendPacketToServer(new BattleCommandPacket(battleID, player).makePacket());
			turnChoiceSent = true;
		}

		if(button.id == 6)
		{
			int itemStackID = ((SkillSelectionButton)button).getSkillID();

			player.action = Action.USE_SKILL;
			player.target = player.getId();
			PacketDispatcher.sendPacketToServer(new BattleCommandPacket(battleID, player).makePacket());
			turnChoiceSent = true;
		}

		getMenu(button.id);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	protected void keyTyped(char par1, int par2) {

	}
}

