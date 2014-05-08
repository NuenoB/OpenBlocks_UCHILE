package openblocks.common.entity.math;


import openblocks.common.item.ItemDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LivingStats extends Stats{
	

	protected EntityLiving entityLiving;
	protected Item heldItem; // Se obtiene el item a partir del itemStack
	protected double attack; // Cambios de float a double
 	protected double defense;
 	protected double magic;
 	protected double resistance;
 	protected int speed;
 	
 	
 	public LivingStats(Entity entity){
 		this.entityLiving=(EntityLiving) entity;
 		ItemStack hi=entityLiving.getHeldItem();
 		this.heldItem= hi.getItem();
 	}
 	
 	
	@Override
	void statsAllocte() {
		attack=new ItemDamage(heldItem).getBonusDamage(); //método agregado por el grupo de items.
		defense=this.getTotalDefenseValue();
		magic=this.getTotalMagicValue();
		resistance=this.getTotalResistanceValue();
		speed=this.getTotalSpeedValue();
	}

	public double getAttack(){
		return attack;
	}
	public double getDefense(){
		return defense;
	}
	public double getMagic(){
		return magic;
	}
	public double getResistance(){
		return resistance;
	}
	public double getSpeed(){
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
