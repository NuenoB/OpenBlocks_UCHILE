package openblocks.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import openblocks.client.model.ModelAttackingTree;
import openblocks.common.entity.EntityAttackingTreeBigFireball;
import openblocks.common.entity.EntityAttackingTreeSmallFireball;
import openblocks.common.entity.IAttackingTree;

public class RenderAttackingTreeSmallFireBall extends RenderLiving {

private static final ResourceLocation attackingTreeTextures = new ResourceLocation("openblocks:textures/models/attackingtree.png");
	
	public RenderAttackingTreeSmallFireBall(ModelAttackingTree modelAttackingTree, float par2) {
		super(modelAttackingTree, par2);
	}

	public void doRenderLiving(EntityLiving entity, double d, double d1, double d2, 
			float f, float f1)
	{
		super.doRenderLiving((EntityAttackingTreeSmallFireball)entity, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, 
			float f, float f1)
	{
		doRenderLiving((EntityAttackingTreeSmallFireball)entity, d, d1, d2, f, f1);
	}

	protected ResourceLocation getAttackingTreeTextures(IAttackingTree attackinTree)
    {
        return attackingTreeTextures;
    }
	
	protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getAttackingTreeTextures((IAttackingTree)par1Entity);
    }
	
}
