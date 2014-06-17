package openblocks.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.world.World;

public class EntityAttackingTree extends EntityMob implements IRangedAttackMob{
	
	public EntityAttackingTree(World par1World) {
		super(par1World);
		par1World.setBlock(super.chunkCoordX+2, super.chunkCoordY+2,super.chunkCoordZ+2, 2546);

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
        return true;
    }
	
	public void setInvisible(boolean par1)
    {
        this.setFlag(5, true);
    }
	@Override
	public boolean isInvisibleToPlayer(EntityPlayer par1EntityPlayer)
    {
        return true;
    }
	
	
	@Override
	public void onLivingUpdate(){}
	

	@Override 
	public boolean attackEntityAsMob(Entity enemy){
		Entity en = this.findPlayerToAttack();
		double enemyX=en.posX;
		double enemyY=en.posY;
		double enemyZ=en.posZ;
		
		return true;}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase enemy,
			float f) {
		double directionX = enemy.posX + enemy.motionX - this.posX;
        double directionY = enemy.posY + enemy.motionY - this.posY;
        double directionZ = enemy.posZ + enemy.motionZ - this.posZ;
		EntityLargeFireball fireball = new EntityLargeFireball(this.worldObj, this, directionX, directionY, directionZ);
		
		
		this.worldObj.spawnEntityInWorld(fireball);
	}
}
