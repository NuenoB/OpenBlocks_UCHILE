package openblocks.common.entity.math;

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
	
	public float getHP() {
		return hitPoints;
	}
	
	public int getMP() {
		return magicPoints;
	}
	
	public abstract float attackTo(EntityStats enemy);
	
	public abstract void beingDamaged(DamageType type, float baseDMG);
	
	public void healHP (float amount) {
		hitPoints = Math.max(hitPoints+amount, this.getMaxHP());
	}
	
	public void healMP (int amount) {
		magicPoints = Math.max(magicPoints+amount, this.getMaxMP());
	}
}
