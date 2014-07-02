package openblocks.Battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import openblocks.common.entity.math.*;
import net.minecraft.world.World;

/**
 * 
 * @author Jaime
 * Creates an instance of battle based on the current entities involved and game session.
 * @param ent Array list containing all EntityStats of the combatants.
 * @param minecraft Current session of Minecraft.
 */
public class Battle {
	private boolean battleEnd;
	private boolean nextTurn;
	private ArrayList<EntityStats> battlers;
	public Battle(ArrayList<EntityStats> ent, Minecraft minecraft){
		for (EntityStats entity : ent){
			battlers.add(entity);
		}
	}
	public void sortTurn(){
		Collections.sort(battlers, new determinePriority());
	}
	/**
	 * 
	 * @author Jaime
	 * New comparator to define the turn order based on each entity's speed.
	 * @param o1 First entity
	 * @param o2 Second entity
	 *
	 */
	public class determinePriority implements Comparator<EntityStats>{

		@Override
		public int compare(EntityStats o1, EntityStats o2) {
			if (o1.getSPD() >= o2.getSPD()) return 1;
			else return 0;
		}
	}
	/** Stops movement of entities to simulate turn-based action.
	 * 
	 */
	public void blockMovement(){
		for (EntityStats entity : battlers){
			entity.getEntity().setJumping(false);
			entity.getEntity().moveStrafing = 0.0F;
			entity.getEntity().moveForward = 0.0F;
		}
	}
	/**
	 * Updates the state of the battle and each entity. Must add packets.
	 */
	public synchronized void update(){
		this.blockMovement();
		for (EntityStats entity : battlers){
			while (!nextTurn);
		}
	}
	public void setNextTurn (Boolean b){
		this.nextTurn= b;
	}
	public void battleEnded(){
		this.battleEnd= true;
	}
}


