package openblocks.common.entity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityAttackingTree extends EntityMob {

	public EntityAttackingTree(World par1World) {
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
	
	

}
