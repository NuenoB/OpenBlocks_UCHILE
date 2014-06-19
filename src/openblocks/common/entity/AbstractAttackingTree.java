package openblocks.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class AbstractAttackingTree extends EntityMob implements IAttackingTree{
	protected EntityFireball fireball;
	
	public AbstractAttackingTree(World par1World) {
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

}
