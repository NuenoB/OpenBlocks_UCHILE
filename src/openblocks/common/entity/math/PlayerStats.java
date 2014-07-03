package openblocks.common.entity.math;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PlayerStats extends Stats{

	protected EntityPlayer player;
	protected ItemStack[] itemStack;
	protected float attack;
 	protected float defense;
 	protected float magic;
 	protected float resistance;
 	protected int speed;

 	public PlayerStats(Entity entity){
 		player=(EntityPlayer) entity;
		itemStack=player.inventory.armorInventory;
 	}
 	
	@Override
	void statsAllocte() {
		attack=player.getHeldItem().getBonusDamage(); //método agregado por el grupo de items.
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

        for (int j = 0; j < itemStack.length; ++j)
        {
            if (itemStack[j] != null && itemStack[j].getItem() instanceof ItemArmor)
            {
                int k = ((ItemArmor)itemStack[j].getItem()).damageReduceAmount;
                i += k;
            }
        }

        return i;
    }
    
    public int getTotalMagicValue()
    {
        int i = 0;

        for (int j = 0; j < itemStack.length; ++j)
        {
            if (itemStack[j] != null && itemStack[j].getItem() instanceof ItemArmor)
            {
                int k = ((ItemArmor)itemStack[j].getItem()).magicAmount; //ajustar accesor definido por desarrollo de items
                i += k;
            }
        }

        return i;
    }
    
    public int getTotalResistanceValue()
    {
        int i = 0;

        for (int j = 0; j < itemStack.length; ++j)
        {
            if (itemStack[j] != null && itemStack[j].getItem() instanceof ItemArmor)
            {
                int k = ((ItemArmor)itemStack[j].getItem()).resistanceAmount; //ajustar accesor definido por desarrollo de items
                i += k;
            }
        }

        return i;
    }
    
    public int getTotalSpeedValue()
    {
        int i = 0;

        for (int j = 0; j < itemStack.length; ++j)
        {
            if (itemStack[j] != null && itemStack[j].getItem() instanceof ItemArmor)
            {
                int k = ((ItemArmor)itemStack[j].getItem()).speedAmount; //ajustar accesor definido por desarrollo de items
                i += k;
            }
        }

        return i;
    }

}
