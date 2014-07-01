package openblocks.common.entity.math;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;

public abstract class EntityStats {
	
	protected float hitPoints;
	protected int magicPoints;
	
	/**
	 * 
	 * @return Entity's max HP
	 */
	public abstract float getMaxHP();
	/**
	 * 
	 * @return Entity's max MP
	 */
	public abstract int getMaxMP();
	/**
	 * 
	 * @return Entity's attack including any bonuses from weapons
	 */
	public abstract float getATK();
	/**
	 * 
	 * @return Entity's defense including any bonuses from armor
	 */
	public abstract float getDEF();
	/**
	 * 
	 * @return Entity's magic power
	 */
	public abstract float getMAG();
	/**
	 * 
	 * @return Entity's magic resistence
	 */
	public abstract float getRES();
	/**
	 * 
	 * @return Entity's battle speed
	 */
	public abstract int getSPD();
	
	/**
	 * 
	 * @return Entity's current HP
	 */
	public float getHP() {
		return hitPoints;
	}
	
	/**
	 * 
	 * @return Entity's current MP
	 */
	public int getMP() {
		return magicPoints;
	}
	
	/**
	 * Attack to an enemy
	 * @param enemy Entity who is attacked
	 * @param type Elemental type of the attack
	 * @return Total of damage (-1 if the attack miss)
	 */
	public final double attackTo(EntityStats enemy, DamageType type) {
		switch (type) {
		case FIRE:
			if (magicPoints <= 0)
				return -1;
			this.magicPoints--;
			return enemy.beingDamaged(type, this.getMAG(), this.getSPD());
		default:
			return enemy.beingDamaged(type, this.getATK(), this.getSPD());
		}
	}
	
	/**
	 * Causes damage to this entity from an enemy's attack
	 * @param type Elemental type of the damage source
	 * @param baseDMG Amount of base damage
	 * @param enemySPD Attacker's speed
	 * @return Final damage dealed (-1 if the attack miss)
	 */
	public double beingDamaged(DamageType type, float baseDMG, int enemySPD) {
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
	
	/**
	 * 
	 * @return Entity who belongs this stats
	 */
	public abstract EntityLivingBase getEntity();
	
	/**
	 * Recovers Entity's HP
	 * @param amount Amount of HP healed
	 */
	public void healHP (float amount) {
		hitPoints = Math.max(hitPoints+amount, this.getMaxHP());
	}
	
	/**
	 * Recovers Entity's MP
	 * @param amount Amount of MP healed
	 */
	public void healMP (int amount) {
		magicPoints = Math.max(magicPoints+amount, this.getMaxMP());
	}
	
}
