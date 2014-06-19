
package openblocks.common.entity.math;

import openblocks.common.item.AbstractCuttingWeapon;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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

	public int getLV() {
		return player.experienceLevel;
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
		float baseDEF = 1.0F + 0.5F*player.experienceLevel;
		ItemStack[] inventory = player.inventory.armorInventory;
		for (ItemStack armor : inventory) {
			Item item = armor.getItem();
			if (item instanceof ItemArmor)
				baseDEF += ((ItemArmor) item).damageReduceAmount;
		}
		return baseDEF;
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
		int baseSPD = 3 + 1*player.experienceLevel;
		Item held = player.getHeldItem().getItem();
		if (held instanceof AbstractCuttingWeapon) {
			AbstractCuttingWeapon weapon = (AbstractCuttingWeapon) held;
			EnumBonusEffects effect = weapon.getBonusEffect();
			switch (effect) {
			case FAST:
				baseSPD += 5;
			case SLOW:
				baseSPD -= 5;
			default:
				break;
			}
		}
		return baseSPD;
	}
	
	@Override
	public EntityLivingBase getEntity() {
		return player;
	}
	
	@Override
	public double beingDamaged(DamageType type, float baseDMG, int enemySPD) {
		player.inventory.damageArmor(4.0F);
		return super.beingDamaged(type, baseDMG, enemySPD);
	}
}
