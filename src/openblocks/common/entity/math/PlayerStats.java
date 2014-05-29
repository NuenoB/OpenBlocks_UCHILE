
package openblocks.common.entity.math;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class PlayerStats extends EntityStats {
	
	private EntityPlayer player;
	private ItemStack[] itemStack;
	
	public PlayerStats(EntityPlayer player) {
		this.player = player;
		hitPoints = this.getMaxHP();
		magicPoints = this.getMaxMP();
	}

	@Override
	public float getMaxHP() {
		int increment = 2*player.experienceLevel/2;
		return 20.0F + (float)increment;
	}
	
	@Override
	public int getMaxMP() {
		return 5 + 1*player.experienceLevel/5;
	}
	
	@Override
	public float getATK() {
		return 2.0F + 1.0F*player.experienceLevel;
	}
	
	@Override
	public float getDEF() {
		return 1.0F + 0.5F*player.experienceLevel;
	}
	
	@Override
	public float getMAG() {
		int increment = 1*player.experienceLevel/3;
		return 1.0F + (float)increment;
	}
	
	@Override
	public float getRES() {
		int increment = 1*player.experienceLevel/3;
		return 0.5F + 0.5F*increment;
	}
	
	@Override
	public int getSPD() {
		return 3 + 1*player.experienceLevel;
	}
	
	@Override
	public void attackTo(EntityStats enemy) {
		
	}
	
	public EntityLivingBase getEntity() {
		return player;
	}
	
	@Override
	public void beingDamaged(DamageType type, float baseDMG) {
		
	}
}
