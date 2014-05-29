
package openblocks.common.entity.math;

import openblocks.common.item.ItemDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PlayerStats extends EntityStats{

	protected EntityPlayer player;
	protected ItemStack[] itemStack;
	protected float attack; // Cambios de float a double
 	protected float defense;
 	protected float magic;
 	protected float resistance;
 	protected int speed;

 	public PlayerStats(Entity entity){
 		player=(EntityPlayer) entity;
		itemStack=player.inventory.armorInventory;
 	}
 	
 	/**
 	 * Se obtiene el item que tiene el personaje en la mano, y a partir de eso
 	 * se calcula el ataque
 	 */
	@Override
	void statsAllocte() {
		ItemStack player_itemStack=player.getHeldItem();
		Item heldItem = player_itemStack.getItem(); 
		
		attack=new ItemDamage(heldItem).getBonusDamage(); //m�todo agregado por el grupo de items.
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
	public int getSpeed(){
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
>>>>>>> refs/heads/alvarez
