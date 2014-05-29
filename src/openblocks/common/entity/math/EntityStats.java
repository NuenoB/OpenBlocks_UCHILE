package openblocks.common.entity.math;

import net.minecraft.entity.EntityLivingBase;

public abstract class EntityStats{
	
	public enum Action{
		ATTACK, USE_SKILL, FLEE
	}
	
	protected float hitPoints;
	protected int magicPoints;
	protected int speed;
	public EntityLivingBase entity;
	
	public abstract float getMaxHP();
	public abstract int getMaxMP();
	public abstract float getATK();
	public abstract float getDEF();
	public abstract float getMAG();
	public abstract float getRES();
	public abstract int getSPD();
	public abstract EntityLivingBase getEntity();
	
	public float getHP() {
		return hitPoints;
	}
	
	public int getMP() {
		return magicPoints;
	}
	
	public abstract void attackTo(EntityStats enemy);
	
	public abstract void beingDamaged(DamageType type, float baseDMG);
	
	public void healHP (float amount) {
		hitPoints = Math.max(hitPoints+amount, this.getMaxHP());
	}
	
	public void healMP (int amount) {
		magicPoints = Math.max(magicPoints+amount, this.getMaxMP());
	}
	public String name() {
		return getEntity().getEntityName();
	}
	
}
