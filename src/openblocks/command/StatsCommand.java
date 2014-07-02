package openblocks.command;

import openblocks.common.entity.math.PlayerStats;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class StatsCommand extends CommandBase{

	@Override
	/**
	 * Sets the name of the command
	 * @return Command's name
	 */
	public String getCommandName() {
		return "stats";
	}

	@Override
	/**
	 * Sets the description of the command when its called with /help
	 * @param icommandsender object that sent the command(in this case EntityPlayer)
	 * @return Message for the user
	 */
	public String getCommandUsage(ICommandSender icommandsender) {
		return "stats actuales del personaje";
	}

	@Override
	/**
	 * Method called when the command is typed in
	 * @param icommandsender object that sent the command(in this case EntityPlayer)
	 * @param astring additional parameter when the command is typed in
	 */
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender instanceof EntityPlayer){
			EntityPlayer player=(EntityPlayer) icommandsender;
			PlayerStats stats=new PlayerStats(player);
			player.addChatMessage("Player stats:");
			player.addChatMessage("Lvl: "+stats.getLV());
			player.addChatMessage("Attack: "+stats.getATK());
			player.addChatMessage("Defense: "+stats.getDEF());
			player.addChatMessage("Magic: "+stats.getMAG());
			player.addChatMessage("Resistance: "+stats.getRES());
			player.addChatMessage("Speed: "+stats.getSPD());
		}
	}

	
	@Override
	/**
	 * Compares the name of this command to the name of the given command(not needed on this command)
	 * @param o command to compare
	 * @return result of the comparison
	 */
	public int compareTo(Object o) {
		return 0;
	}
	
	@Override
	/**
	 * Returns true if the given command sender is allowed to use this command.
	 * @param icommandsender object that sent the command(in this case EntityPlayer)
	 * @return true(so the player can use this command on all modes)
	 */
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
	    return true;
	}

}