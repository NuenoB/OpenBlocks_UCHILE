package openblocks.common.entity.math;

import openblocks.common.item.AbstractCuttingWeapon;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MobStats extends EntityStats {

	private EntityMob mob;
	private int level;
	private int factor;
	
	public MobStats (EntityMob enemy, PlayerStats player) {
		mob = enemy;
		level = player.getLV();
		factor = (level/5) + 1;
		hitPoints = this.getMaxHP();
		magicPoints = this.getMaxMP();
	}
	
	@Override
	public float getMaxHP() {
		return factor*7.0F + 3.0F*level;
	}
	
	@Override
	public int getMaxMP() {
		return level-1;
	}
	
	@Override
	public float getATK() {
		return factor*2.0F + level;
	}
	
	@Override
	public float getDEF() {
		return factor*1.5F + level;
	}
	
	@Override
	public float getMAG() {
		return factor + level;
	}
	
	@Override
	public float getRES() {
		return factor*0.5F + level;
	}
	
	@Override
	public int getSPD() {
		return (factor*2 + level);
	}
	
	@Override
	public EntityLivingBase getEntity() {
		return mob;
	}
	
}