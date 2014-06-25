package openblocks.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityAttackingTreeBigFireball extends AbstractAttackingTree{
	
	public EntityAttackingTreeBigFireball(World par1World) {
		super(par1World);
		

	}
	
	@Override
	public boolean attackEntityAsMob(Entity enemy){
		fireball = new EntityLargeFireball(this.worldObj, this, 1,1,1);
		return super.attackEntityAsMob(enemy);
	}
	
	
}
