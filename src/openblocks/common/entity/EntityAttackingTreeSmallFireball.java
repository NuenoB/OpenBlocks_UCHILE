package openblocks.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityAttackingTreeSmallFireball extends AbstractAttackingTree {

	public EntityAttackingTreeSmallFireball(World par1World) {
		super(par1World);
		fireball = new EntitySmallFireball(this.worldObj, this, 1,1,1);
	}

}