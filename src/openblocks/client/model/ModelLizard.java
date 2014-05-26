package openblocks.client.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;


public class ModelLizard extends ModelBase
{
	//fields
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer mouth;
    ModelRenderer tail;
    ModelRenderer rightHand;
    ModelRenderer leftHand;
    ModelRenderer rightFeet;
    ModelRenderer leftFeet;
  
  public ModelLizard()
  {
    textureWidth = 80;
    textureHeight = 35;
    
      body = new ModelRenderer(this, 0, 18);
      body.addBox(0F, 0F, 0F, 30, 7, 10);
      body.setRotationPoint(-10F, 12.66667F, -5F);
      body.setTextureSize(80, 35);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      head = new ModelRenderer(this, 10, 0);
      head.addBox(0F, 0F, 0F, 6, 5, 6);
      head.setRotationPoint(-16F, 9F, -3F);
      head.setTextureSize(80, 35);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      mouth = new ModelRenderer(this, 34, 7);
      mouth.addBox(0F, 0F, 0F, 10, 3, 8);
      mouth.setRotationPoint(-20F, 14F, -4F);
      mouth.setTextureSize(80, 35);
      mouth.mirror = true;
      setRotation(mouth, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 10, 0);
      tail.addBox(0F, 0F, 0F, 12, 3, 4);
      tail.setRotationPoint(20F, 13F, -2F);
      tail.setTextureSize(80, 35);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      rightHand = new ModelRenderer(this, 0, 0);
      rightHand.addBox(0F, 0F, 0F, 3, 5, 2);
      rightHand.setRotationPoint(-5F, 19F, 3F);
      rightHand.setTextureSize(80, 35);
      rightHand.mirror = true;
      setRotation(rightHand, 0F, 0F, 0F);
      leftHand = new ModelRenderer(this, 0, 0);
      leftHand.addBox(0F, 0F, 0F, 3, 5, 2);
      leftHand.setRotationPoint(-5F, 19F, -5F);
      leftHand.setTextureSize(80, 35);
      leftHand.mirror = true;
      setRotation(leftHand, 0F, 0F, 0F);
      rightFeet = new ModelRenderer(this, 0, 0);
      rightFeet.addBox(0F, 0F, 0F, 3, 5, 2);
      rightFeet.setRotationPoint(9F, 19F, 3F);
      rightFeet.setTextureSize(80, 35);
      rightFeet.mirror = true;
      setRotation(rightFeet, 0F, 0F, 0F);
      leftFeet = new ModelRenderer(this, 0, 0);
      leftFeet.addBox(0F, 0F, 0F, 3, 5, 2);
      leftFeet.setRotationPoint(9F, 19F, -5F);
      leftFeet.setTextureSize(80, 35);
      leftFeet.mirror = true;
      setRotation(leftFeet, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    head.render(f5);
    mouth.render(f5);
    tail.render(f5);
    rightHand.render(f5);
    leftHand.render(f5);
    rightFeet.render(f5);
    leftFeet.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
