package openblocks.common.entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityAttackingTree extends EntityMob {
	
	public EntityAttackingTree(World par1World) {
		super(par1World);
		par1World.setBlock(super.chunkCoordX+1, super.chunkCoordY+1,super.chunkCoordZ+1, 2546);
		
	}
	
	 /**
     * Disables a mob's ability to move on its own while true.
     */
	@Override
    protected boolean isMovementCeased()
    {
        return true;
    }
	
	

}
