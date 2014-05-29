package openblocks.common.entity.math;

import openblocks.common.item.AbstractCuttingWeapon;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class PlayerStats extends EntityStats {
	
	private EntityPlayer player;
	
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
		float attack = 2.0F + 1.0F*player.experienceLevel;
		Item held = player.getHeldItem().getItem();
		if (held instanceof AbstractCuttingWeapon) {
			AbstractCuttingWeapon weapon = (AbstractCuttingWeapon) held;
			attack += weapon.getBonusDamage();
		}
		return attack;
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
	public DamageType getDMGType() {
		//TODO agregar valor del arma
		return DamageType.PHYSICAL;
	}
	
	public EntityLivingBase getEntity() {
		return player;
	}
	
}
