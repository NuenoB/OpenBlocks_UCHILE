package openblocks.common.entity.math;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public abstract class EntityStats extends EntityLivingBase {

	private float attack;
	private float defense;
	private float magic;
	private float resistance;
	private float speed;
	
	public EntityStats(World par1World, float ATK, float DEF, float MAG, float RES, float SPD) {
		super(par1World);
		attack = ATK;
		defense = DEF;
		magic = MAG;
		resistance = RES;
		speed = SPD;
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
	
	public float getSPD() {
		return speed;
	}
	
	@Override
	protected void damageEntity(DamageSource par1DamageSource, float par2) {
		if ( !this.isEntityInvulnerable() ) {
            par2 = ForgeHooks.onLivingHurt(this, par1DamageSource, par2);
            if (par2 <= 0) return;
            
            // calcular daño
            float damage = 0.0F;
            EntityStats enemy = (EntityStats) par1DamageSource.getEntity();
            // daño magico
            if ( par1DamageSource.isMagicDamage() ) {
            	damage = enemy.getMAG() / this.getRES();
            	damage = this.applyPotionDamageCalculations(par1DamageSource, par2);
            }
            // daño fisico
            else {
            	damage = enemy.getATK() / this.getDEF();
            	par2 = this.applyArmorCalculations(par1DamageSource, par2);
            }
            
            float f1 = damage;
            par2 = Math.max(damage - this.getAbsorptionAmount(), 0.0F);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f1 - par2));
            if (par2 != 0.0F) {
                float f2 = this.getHealth();
                this.setHealth(f2 - par2);
                this.func_110142_aN().func_94547_a(par1DamageSource, f2, par2);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - par2);
            }
        }
	}
	
}
