package openblocks.client.renderer.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityWarriorRenderer extends EntityMob{

	public EntityWarriorRenderer(World par1World) {
		super(par1World);
	}
	
	public EnumCreatureAttribute getCreatureAttribute(){
        return EnumCreatureAttribute.UNDEAD;
    }
}
