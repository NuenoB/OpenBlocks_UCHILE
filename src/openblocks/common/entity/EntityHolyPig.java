package openblocks.common.entity;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHolyPig extends EntityPig {

	public EntityHolyPig(World par1World) {
		super(par1World);
		
	}

	@Override
	 public boolean attackEntityFrom(DamageSource par1DamageSource, float par2){
		if(this.isBurning()){
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 6.0F, true);
			return true;
			
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}
}
