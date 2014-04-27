package openblocks.common.entity.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import openblocks.common.skills.ISkill;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class EntityPlayerExt extends EntityPlayer{
	
	public enum CombatantInfo{
		Player;
		public Iterator<ISkill> Skills;
		public boolean ready;
		public float HP;
		public Action action;
		public CombatantInfo target;
		private int MagicPoints = 500;
		private int MaxMagicPoints = 500;
		private boolean inBattle;
		private int id= 6;
		public boolean isPlayer = true;

		public void updateHealth(float health) {
			// TODO Auto-generated method stub
		}	
		public enum Action{
			USE_SKILL, ATTACK, MAGIC, FLEE;
		}
	}

	public EntityPlayerExt(World par1World, String par2Str) {
		super(par1World, par2Str);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean isMovementBlocked(){
		return (super.isMovementBlocked()|| inBattle);
		
	}

	@Override
	public void sendChatToPlayer(ChatMessageComponent chatmessagecomponent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canCommandSenderUseCommand(int i, String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return null;
	}
	
	public boolean isInBattle(){
		return this.inBattle;
	}
	
	public void restoreMP(int magic){
		if (this.MagicPoints+magic<=MaxMagicPoints){
			this.MagicPoints+=magic;
		}
	}
	@Override
	public void onUpdate(){
		this.onUpdate();
		
	}

}
