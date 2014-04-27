package openblocks.event.battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class Battle {
	private boolean battleEnd;
	private ArrayList<EntityLivingBase> battlers;
	public Battle(Iterator<EntityLivingBase> ent, World world){
		while (ent.hasNext()){
			battlers.add(ent.next());
		}
	}
	public void calculate(){
		for (EntityLivingBase battler : battlers){
			battler.onUpdate();
		}
	}
	public void sortTurn(){
		Collections.sort(battlers, determinePriority());
	}
	
	public Comparator<EntityLivingBase> determinePriority(){
		return (EntityLivingBase.getSPD() > EntityLivingBase.getSPD()); 
	}
	
	public void blockMovement(){
		for (EntityLivingBase entity : battlers){
			entity.setJumping(false);
	        entity.moveStrafing = 0.0F;
	        entity.moveForward = 0.0F;
		}
	}
	
	public synchronized void update(){
		while (!battleEnd){
			this.blockMovement();
			for (EntityLivingBase entity : battlers){
				entity.getAction();
			}
		}
	}

}
