package openblocks.common.entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityAttackingTree extends EntityMob {
	
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

}
