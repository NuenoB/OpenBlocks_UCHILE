package openblocks.command;

import openblocks.common.entity.math.PlayerItemStats;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class StatsComand extends CommandBase{

	@Override
	public String getCommandName() {
		return "stats";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "stats actuales del personaje";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender instanceof EntityPlayer){
			EntityPlayer player=(EntityPlayer) icommandsender;
			PlayerItemStats stats=new PlayerItemStats(player);
			stats.statsAllocte();
			player.addChatMessage("Player stats:");
			player.addChatMessage("Bonus Damage: "+stats.getAttack());
			player.addChatMessage("Defense: "+stats.getDefense());
			player.addChatMessage("Magic: "+stats.getMagic());
			player.addChatMessage("Resistance: "+stats.getResistance());
			player.addChatMessage("Speed: "+stats.getSpeed());
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}