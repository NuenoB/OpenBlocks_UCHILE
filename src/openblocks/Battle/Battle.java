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
			entity.getAction();
			entity.getEntity();
		}
	}
	public void getAction(){
		switch (this.action){
		case 0:
			this.attackTo(this.target);
			return;
		case 1:
			this.attackTo(this.target);
			return;
		case 2:
			this.attackTo(this.target);
			return;
		case 3:
			battleEnd= true;
		}
		if (this.target.hitPoints <= 0){
			battlers.remove(this.target);
		}
	}
}


