package openblocks.common.entity.math;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;

public class MobStats extends EntityStats {

	private EntityMob mob;
	private float maxHP;
	private int maxMP;
	private int ATK;
	private int MAG;
	private int DEF;
	private int RES;
	private int SPD;
	
	
	public MobStats (EntityMob enemy) {
		mob = enemy;
		
		hitPoints = this.getMaxHP();
		magicPoints = this.getMaxMP();
	}
	
	@Override
	public float getMaxHP() {
		return maxHP;
	}

	@Override
	public int getMaxMP() {
		return maxMP;
	}

	@Override
	public float getATK() {
		return ATK;
	}

	@Override
	public float getDEF() {
		return DEF;
	}

	@Override
	public float getMAG() {
		return MAG;
	}

	@Override
	public float getRES() {
		return RES;
	}

	@Override
	public int getSPD() {
		return SPD;
	}

	@Override
	public void attackTo(EntityStats enemy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beingDamaged(DamageType type, float baseDMG) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityLivingBase getEntity() {
		return mob;
	}

}
