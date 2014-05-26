package openblocks.common.entity;

import java.util.concurrent.CountDownLatch;

import sun.management.counter.Counter;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHolyPig extends EntityPig {
	
	private CountDownLatch count;

	public EntityHolyPig(World par1World) {
		super(par1World);
		count= new CountDownLatch(30); //Alrededor de 2 segundos
		
	}

	/**
	 * Checks if the pig is burning, if it is the counter decreases in one. When
	 * it reaches 0, the pig explodes.
	 */
	@Override
	public void onUpdate(){
		if(this.isBurning()){
			count.countDown();
		}
		if(count.getCount()<=0){
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 6.0F, true);
			this.setDead();
		}
		
		super.onUpdate();
		
	}
	
}
