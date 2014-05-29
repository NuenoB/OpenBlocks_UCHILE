package openblocks.command;

import openblocks.common.entity.math.PlayerItemStats;
import openblocks.common.entity.math.PlayerStats;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class StatsCommand extends CommandBase{

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
			PlayerStats stats=new PlayerStats(player);
			player.addChatMessage("Player stats:");
			player.addChatMessage("Bonus Damage: "+stats.getATK());
			player.addChatMessage("Defense: "+stats.getDEF());
			player.addChatMessage("Magic: "+stats.getMAG());
			player.addChatMessage("Resistance: "+stats.getRES());
			player.addChatMessage("Speed: "+stats.getSPD());
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}