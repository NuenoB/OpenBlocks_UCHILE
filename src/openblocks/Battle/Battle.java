package openblocks.Battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityStats;
import net.minecraft.world.World;

public class Battle {
	private boolean battleEnd;
	private ArrayList<EntityStats> battlers;
	public Battle(Iterator<EntityStats> ent, World world){
		while (ent.hasNext()){
			battlers.add(ent.next());
		}
	}
	public void calculate(){
		for (EntityStats battler : battlers){
			battler.onUpdate();
		}
	}
	public void sortTurn(){
		Collections.sort(battlers, determinePriority());
	}
	
	public Comparator<EntityStats> determinePriority(){
		return (EntityStats.getSPD() > EntityStats.getSPD()); 
	}
	
	public void blockMovement(){
		for (EntityStats entity : battlers){
			entity.setJumping(false);
	        entity.moveStrafing = 0.0F;
	        entity.moveForward = 0.0F;
		}
	}
	
	public synchronized void update(){
			this.blockMovement();
			for (EntityStats entity : battlers){
				entity.getAction();
			}
		}
	}

}
