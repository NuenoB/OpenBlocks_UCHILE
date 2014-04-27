package openblocks.common.entity.math;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerStats extends EntityStats {
	
	private EntityPlayer player;
	
	public PlayerStats(EntityPlayer player) {
		this.player = player;
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
	public float attackTo(EntityStats enemy) {
		return 0;
	}
	
	@Override
	public void beingDamaged(DamageType type, float baseDMG) {
		float totalDMG = baseDMG;
		if (type == type.PHYSICAL) {
			totalDMG /= this.getDEF();
		}
		else {
			totalDMG /= this.getRES();
		}
		totalDMG *= (player.getRNG().nextGaussian()/10.0F) + 0.9F;
		totalDMG -= player.getTotalArmorValue();
		player.inventory.damageArmor(4.0F);
	}
	
}
