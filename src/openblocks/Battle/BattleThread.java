package openblocks.Battle;

import java.util.ArrayList;
import java.util.Iterator;

import openblocks.common.entity.math.EntityStats;
import openblocks.common.entity.math.MobStats;
import openblocks.common.entity.math.PlayerStats;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author NuenoB
 *
 */
public class BattleThread implements Runnable {

	PlayerStats player;
	MobStats mob;
	ArrayList<EntityStats> battlers;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Llama continuamente al controlador de la batalla
	 */
	public boolean initBattle(Entity entity){
		if (entity instanceof EntityMob){	
			this.mob= new MobStats(entity);
			battlers.add(player);
			battlers.add(this.mob);
			run();
		}
		return false;
	}

	@Override
	public synchronized void run() {
		Battle battle= new Battle(battlers, null);
		while (Minecraft.getMinecraft().running){
			battle.update();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}

}
