package openblocks.command;

import openblocks.common.entity.math.PlayerItemStats;
import openblocks.common.entity.math.PlayerStats;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class StatsCommand extends CommandBase{

	@Override
	//En este metodo se asigna el nombre del comando. El comando se llama con /(nombre del comando)
	public String getCommandName() {
		return "stats";
	}

	@Override
	//Este metodo entrega la descripcion del comando cuando se escribe /help (nombre del comando)
	public String getCommandUsage(ICommandSender icommandsender) {
		return "stats actuales del personaje";
	}

	@Override
	//Este metodo realiza las acciones del metodo.
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(icommandsender instanceof EntityPlayer){
			EntityPlayer player=(EntityPlayer) icommandsender;
			PlayerStats stats=new PlayerStats(player);
			player.addChatMessage("Player stats:");
			player.addChatMessage("Attack: "+stats.getATK());
			player.addChatMessage("Defense: "+stats.getDEF());
			player.addChatMessage("Magic: "+stats.getMAG());
			player.addChatMessage("Resistance: "+stats.getRES());
			player.addChatMessage("Speed: "+stats.getSPD());
		}
	}

	
	@Override
	//metodo necesario para extender CommandBase que compara el nombre del comando con el nombre
	//del comando recibido
	public int compareTo(Object o) {
		return 0;
	}

}