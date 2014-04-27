package openblocks.common.entity.math;

import net.minecraft.entity.EntityLivingBase;

public abstract class EntityStats {
	
	protected EntityLivingBase myself;
	protected float maxHitPoints;
	protected int maxMagicPoints;
	protected float hitPoints;
	protected int magicPoints;
	protected float attack;
	protected float defense;
	protected float magic;
	protected float resistance;
	protected int speed;
	
	public float getMaxHP() {
		return maxHitPoints;
	}
	
	public float getMaxMP() {
		return maxMagicPoints;
	}
	
	public float getHP() {
		return hitPoints;
	}
	
	public int getMP() {
		return magicPoints;
	}
	
	public float getATK() {
		return attack;
	}
	
	public float getDEF() {
		return defense;
	}
	
	public float getMAG() {
		return magic;
	}
	
	public float getRES() {
		return resistance;
	}
	
	public int getSPD() {
		return speed;
	}
	
	public abstract float attackTo(EntityStats enemy);
	
	public void beingDamaged(DamageType type, float damageBase) {
		
	}
	
}
