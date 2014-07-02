package openblocks.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAttackingTree extends ModelBase{
	public ModelRenderer bipedHead;
	public ModelRenderer bipedHeadwear;
	public ModelRenderer bipedBody;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedLeftLeg;


	public ModelAttackingTree()
	{
		this(0.0F);
	}

	public ModelAttackingTree(float par1)
	{
		this(par1, 0.0F, 64, 32);
	}

	public ModelAttackingTree(float par1, float par2, int par3, int par4)
	{
		this.textureWidth = par3;
		this.textureHeight = par4;
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1);
		this.bipedHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F);
		this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
		this.bipedBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 40, 16);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
		this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + par2, 0.0F);
		this.bipedLeftArm = new ModelRenderer(this, 40, 16);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + par2, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + par2, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + par2, 0.0F);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		//this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

		this.bipedHead.render(par7);
		this.bipedBody.render(par7);
		this.bipedRightArm.render(par7);
		this.bipedLeftArm.render(par7);
		this.bipedRightLeg.render(par7);
		this.bipedLeftLeg.render(par7);
		this.bipedHeadwear.render(par7);

	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
	 * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
	 * "far" arms and legs can swing at most.
	 */
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{

	}

}
