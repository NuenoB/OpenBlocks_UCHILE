package openblocks.common.entity.math;
 
 import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
 
 public class PlayerStats extends Stats{
 
 	protected EntityPlayer player;
 	protected ItemStack[] itemStack;
 	protected ItemStack weapon;
 	protected float attack;
  	protected float defense;
  	protected float magic;
  	protected float resistance;
  	protected int speed;
 
  	public PlayerStats(Entity entity){
  		player=(EntityPlayer) entity;
 		itemStack=player.inventory.armorInventory;
 		weapon=player.getHeldItem();
  	}
  	
  //todos los valores son cero por el momento.
 	@Override
 	void statsAllocte() {
 		attack=0; //attack=weapon.getBonusDamage();
 		defense=this.getTotalValue(new DefenseStrategy());
 		magic=this.getTotalValue(new MagicStrategy());
 		resistance=this.getTotalValue(new ResistanceStrategy());
 		speed=this.getTotalValue(new SpeedStrategy());
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
 	
 	public Item getItem(int i){
 		return itemStack[i].getItem();
 	}
 	
 	public int getTotalValue(Strategy strat){
        int i = 0;
        
        for (int j = 0; j < itemStack.length; ++j)
        {
            if (itemStack[j] != null && getItem(j) instanceof ItemArmor)
            {
                int k = strat.getPlayerStats(this,j);
                i += k;
            }
        }

        return i;
 	}
 	

 
 }