package openblocks.common.entity.math;
 
 
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 
 public class LivingStats extends Stats{
 	
 
 	protected EntityLiving entityLiving;
 	protected ItemStack heldItem;
 	protected float attack;
  	protected float defense;
  	protected float magic;
  	protected float resistance;
  	protected int speed;
  	
  	
  	public LivingStats(Entity entity){
  		this.entityLiving=(EntityLiving) entity;
  		this.heldItem=entityLiving.getHeldItem();
  	}
  	
  	
 	@Override
 	void statsAllocte() {
 		attack=heldItem.getBonusDamage(); //método agregado por el grupo de items.
 		defense=this.getTotalDefenseValue();
 		magic=this.getTotalMagicValue();
 		resistance=this.getTotalResistanceValue();
 		speed=this.getTotalSpeedValue();
 	}
 
 	public float getAttack(){
 		return attack;
 	}
 	public float getDefense(){
 		return defense;
 	}
 	public float getMagic(){
 		return magic;
 	}
 	public float getResistance(){
 		return resistance;
 	}
 	public float getSpeed(){
 		return speed;
 	}
 
 	
     public int getTotalDefenseValue()
     {
         int i = 0;
 
         for (int j = 0; j < 5; ++j)
         {
             if (entityLiving.getCurrentItemOrArmor(j) != null && entityLiving.getCurrentItemOrArmor(j).getItem() instanceof ItemArmor)
             {
                 int k = ((ItemArmor)entityLiving.getCurrentItemOrArmor(j).getItem()).damageReduceAmount;
                 i += k;
             }
         }
 
         return i;
     }
     
     public int getTotalMagicValue()
     {
         int i = 0;
 
         for (int j = 0; j < 5; ++j)
         {
             if (entityLiving.getCurrentItemOrArmor(j) != null && entityLiving.getCurrentItemOrArmor(j).getItem() instanceof ItemArmor)
             {
                 int k = ((ItemArmor)entityLiving.getCurrentItemOrArmor(j).getItem()).magicAmount; //ajustar accesor definido por desarrollo de items
                 i += k;
             }
         }
 
         return i;
     }
     
     public int getTotalResistanceValue()
     {
         int i = 0;
 
         for (int j = 0; j < 5; ++j)
         {
             if (entityLiving.getCurrentItemOrArmor(j) != null && entityLiving.getCurrentItemOrArmor(j).getItem() instanceof ItemArmor)
             {
                 int k = ((ItemArmor)entityLiving.getCurrentItemOrArmor(j).getItem()).resistanceAmount; //ajustar accesor definido por desarrollo de items
                 i += k;
             }
         }
 
         return i;
     }
     
     public int getTotalSpeedValue()
     {
         int i = 0;
 
         for (int j = 0; j < 5; ++j)
         {
             if (entityLiving.getCurrentItemOrArmor(j) != null && entityLiving.getCurrentItemOrArmor(j).getItem() instanceof ItemArmor)
             {
                 int k = ((ItemArmor)entityLiving.getCurrentItemOrArmor(j).getItem()).speedAmount; //ajustar accesor definido por desarrollo de items
                 i += k;
             }
         }
 
         return i;
     }
 
 }