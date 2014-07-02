package openblocks.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class ModelFireIronHelmet extends ModelBiped{
	public static final float DELTA_Y = 0;

	public ModelFireIronHelmet() {
		super();

		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4, -8, -4, 8, 8, 8);

		// bar
		bipedHead.setTextureOffset(0, 16);
		bipedHead.addBox(-5, -4 + DELTA_Y, -5, 10, 1, 1);

		// ears
		bipedHead.setTextureOffset(0, 22);
		bipedHead.addBox(-6, -5 + DELTA_Y, -1, 2, 3, 3);
		bipedHead.addBox(4, -5 + DELTA_Y, -1, 2, 3, 3);

		// eyes
		//bipedHead.setTextureOffset(0, 28);
		//bipedHead.addBox(-3, -5 + DELTA_Y, -5, 2, 3, 1);
		//bipedHead.addBox(1, -5 + DELTA_Y, -5, 2, 3, 1);

		// wood handles
		bipedHead.setTextureOffset(0, 18);
		bipedHead.addBox(-5, -4 + DELTA_Y, -4, 1, 1, 3);
		bipedHead.addBox(4, -4 + DELTA_Y, -4, 1, 1, 3);

		// up tubes
		bipedHead.setTextureOffset(10, 18);
		bipedHead.addBox(-5, -10 + DELTA_Y, 0, 1, 5, 1);
		bipedHead.addBox(4, -10 + DELTA_Y, 0, 1, 5, 1);
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		GL11.glPushMatrix();
		GL11.glScaled(1.2, 1.2, 1.2);
		bipedHead.render(par7);
		GL11.glPopMatrix();
	}

}

