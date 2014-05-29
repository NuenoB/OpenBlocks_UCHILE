package openblocks.common.entity.math;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;

public abstract class EntityStats {
	
	protected float hitPoints;
	protected int magicPoints;
	
	public abstract float getMaxHP();
	public abstract int getMaxMP();
	public abstract float getATK();
	public abstract float getDEF();
	public abstract float getMAG();
	public abstract float getRES();
	public abstract int getSPD();
	public abstract DamageType getDMGType();
	
	public float getHP() {
		return hitPoints;
	}
	
	public int getMP() {
		return magicPoints;
	}
	
	public final double attackTo(EntityStats enemy) {
		return enemy.beingDamaged(this.getDMGType(), this.getATK(), this.getSPD());
	}
	
	public final double beingDamaged(DamageType type, float baseDMG, int enemySPD) {
		// calculo de evasion
		double avo = (enemySPD-this.getSPD())/100.0;
		if (avo > (new Random()).nextGaussian()) {
			return -1;
		}
		// uso de DEF/RES segun tipo de ataque
		if (type == DamageType.PHYSICAL) {
			baseDMG -= this.getDEF();
		}
		else {
			baseDMG -= this.getRES();
		}
		// calculo daño final
		baseDMG = baseDMG * (85 + (new Random()).nextInt(16));
		baseDMG = Math.min(baseDMG, this.hitPoints);
		// causar daño
		this.hitPoints -= baseDMG;
		if (this.hitPoints <= 0) {
			this.getEntity().setDead();
		}
		return baseDMG;
	}
	
	public abstract EntityLivingBase getEntity();
	
	public void healHP (float amount) {
		hitPoints = Math.max(hitPoints+amount, this.getMaxHP());
	}
	
	public void healMP (int amount) {
		magicPoints = Math.max(magicPoints+amount, this.getMaxMP());
	}
	
}
