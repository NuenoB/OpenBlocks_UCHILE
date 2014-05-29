package openblocks.Battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import net.minecraft.entity.EntityLiving;
import openblocks.common.entity.math.*;
import net.minecraft.world.World;

public class Battle {
	private boolean battleEnd;
	private boolean nextTurn;
	private ArrayList<EntityStats> battlers;
	public Battle(ArrayList<EntityStats> ent, World world){
		for (EntityStats entity : ent){
			battlers.add(entity);
		}
	}
	public void sortTurn(){
		Collections.sort(battlers, new determinePriority());
	}

	public class determinePriority implements Comparator<EntityStats>{

		@Override
		public int compare(EntityStats o1, EntityStats o2) {
			if (o1.getSPD() >= o2.getSPD()) return 1;
			else return 0;
		}
	}

	public void blockMovement(){
		for (EntityStats entity : battlers){
			entity.getEntity().setJumping(false);
			entity.getEntity().moveStrafing = 0.0F;
			entity.getEntity().moveForward = 0.0F;
		}
	}

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


