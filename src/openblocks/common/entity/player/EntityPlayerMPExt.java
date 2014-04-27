package openblocks.common.entity.player;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.util.*;

public class EntityPlayerMPExt extends EntityPlayerMP{
	
	private int MagicPoints = 500;
	private ArrayList<String> Skills;
	private boolean inBattle;

	public EntityPlayerMPExt(MinecraftServer par1MinecraftServer,
			World par2World, String par3Str,
			ItemInWorldManager par4ItemInWorldManager) {
		super(par1MinecraftServer, par2World, par3Str, par4ItemInWorldManager);
		// TODO Auto-generated constructor stub
	}
	public void displayGUIBattle(){
		this.incrementWindowID();
		this.playerNetServerHandler.sendPacketToPlayer(new Packet100OpenWindow(this.currentWindowId, 1,"Battle", 6,true));
	}
	
	public int getMagic(){
		return this.MagicPoints;
	}
	
	public ArrayList<String> getSkills(){
		return this.Skills;
	}
	
	@Override
	public void onUpdate(){
		if (!inBattle){
			super.onUpdate();
		}
		else{
			
		}
	}
}
