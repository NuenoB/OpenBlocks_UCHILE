package openblocks.common.entity.math;
 
 
 import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
  	
  	//todos los valores son cero por el momento.
 	@Override
 	void statsAllocte() {
 		attack=0;	//attack=heldItem.getBonusDamage(); 
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
 		return entityLiving.getCurrentItemOrArmor(i).getItem();
 	}
 	
 	public int getTotalValue(Strategy strat){
        int i = 0;
        
        for (int j = 0; j < 5; ++j)
        {
            if (getItem(j) != null && getItem(j) instanceof ItemArmor)
            {
            	int k = strat.getLivingStats(this,j);
                i += k;
            }
        }

        return i;
	}
 }