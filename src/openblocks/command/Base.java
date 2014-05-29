package openblocks.command;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


public class Base {

	
public static Base instance;

        @EventHandler
        public void serverStart(FMLServerStartingEvent event){
        	MinecraftServer server = MinecraftServer.getServer();
        	ICommandManager command = server.getCommandManager();
        	ServerCommandManager manager = (ServerCommandManager) command;
        	manager.registerCommand(new StatsCommand());
        }
}