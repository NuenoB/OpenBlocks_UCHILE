/**
 * 
 */
package openblocks.Battle;

import net.minecraft.client.Minecraft;

/**
 * @author NuenoB
 *
 */
public class BattleThread implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Llama continuamente al controlador de la batalla
	 */
	
	@Override
	public synchronized void run() {
		Battle battle= new Battle(null, null);
		while (Minecraft.getMinecraft().running){
			battle.update();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}

}
