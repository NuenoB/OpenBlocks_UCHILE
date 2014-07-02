package openblocks.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class AbstractAttackingTree extends EntityMob implements IAttackingTree{
	protected EntityFireball fireball;
	protected int jumpTicks;
	
	public AbstractAttackingTree(World par1World) {
		super(par1World);

	}
	

	
	 /**
     * Disables a mob's ability to move on its own while true.
     */
	@Override
    protected boolean isMovementCeased()
    {
        return true;
    }
	
	
	@Override
	public boolean isInvisible()
    {
        return false;
    }
	
	public void setInvisible(boolean par1)
    {
        this.setFlag(5, false);
    }
	
	@Override
	public boolean isInvisibleToPlayer(EntityPlayer par1EntityPlayer)
    {
        return false;
    }
	


	@Override 
	public boolean attackEntityAsMob(Entity enemy){
		
		Vec3 look = this.getLookVec();
		fireball.setPosition(this.posX + look.xCoord , 
				this.posY + look.yCoord,
				this.posZ + look.zCoord);
		fireball.accelerationX = look.xCoord*0.1;
		fireball.accelerationY = look.yCoord*0.1;
		fireball.accelerationZ = look.zCoord*0.1;
		
		this.worldObj.spawnEntityInWorld(fireball);
		return true;
		
	}

	 public void onLivingUpdate()
	    {
	        if (this.jumpTicks > 0)
	        {
	            --this.jumpTicks;
	        }

	        if (this.newPosRotationIncrements > 0)
	        {
	            double d0 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
	            double d1 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
	            double d2 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
	            double d3 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
	            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.newPosRotationIncrements);
	            this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
	            --this.newPosRotationIncrements;
	            this.setRotation(this.rotationYaw, this.rotationPitch);
	        }
	        
	        else if (!this.isClientWorld())
	        {
	            this.motionX *= 0.98D;
	            this.motionY *= 0.98D;
	            this.motionZ *= 0.98D;
	        }

	        if (Math.abs(this.motionX) < 0.005D)
	        {
	            this.motionX = 0.0D;
	        }

	        if (Math.abs(this.motionY) < 0.005D)
	        {
	            this.motionY = 0.0D;
	        }

	        if (Math.abs(this.motionZ) < 0.005D)
	        {
	            this.motionZ = 0.0D;
	        }

	        this.worldObj.theProfiler.startSection("ai");

	        if (this.isMovementBlocked())
	        {
	            this.isJumping = false;
	            this.moveStrafing = 0.0F;
	            this.moveForward = 0.0F;
	            this.randomYawVelocity = 0.0F;
	        }
	        else if (this.isClientWorld())
	        {
	            if (this.isAIEnabled())
	            {
	                this.worldObj.theProfiler.startSection("newAi");
	                this.updateAITasks();
	                this.worldObj.theProfiler.endSection();
	            }
	            else
	            {
	                this.worldObj.theProfiler.startSection("oldAi");
	                this.updateEntityActionState();
	                this.worldObj.theProfiler.endSection();
	                this.rotationYawHead = this.rotationYaw;
	            }
	        }

	        this.worldObj.theProfiler.endSection();
	        this.worldObj.theProfiler.startSection("jump");

	        if (this.isJumping)
	        {
	            if (!this.isInWater() && !this.handleLavaMovement())
	            {
	                if (this.onGround && this.jumpTicks == 0)
	                {
	                    this.jump();
	                    this.jumpTicks = 10;
	                }
	            }
	            else
	            {
	                this.motionY += 0.03999999910593033D;
	            }
	        }
	        else
	        {
	            this.jumpTicks = 0;
	        }

	        this.worldObj.theProfiler.endSection();
	        this.worldObj.theProfiler.startSection("travel");
	        this.moveStrafing *= 0.98F;
	        this.moveForward *= 0.98F;
	        this.randomYawVelocity *= 0.9F;
	        this.worldObj.theProfiler.endSection();
	        this.worldObj.theProfiler.startSection("push");

	        if (!this.worldObj.isRemote)
	        {
	            this.collideWithNearbyEntities();
	        }

	        this.worldObj.theProfiler.endSection();
	    }
	 
	 

}
