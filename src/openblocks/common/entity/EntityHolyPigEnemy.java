package openblocks.common.entity;

import net.minecraft.world.World;

public class EntityHolyPigEnemy extends EntityHolyPig implements IEntityEnemy {

	private double HP;
	private double attack;
	private double defense;
	
	public EntityHolyPigEnemy(World par1World) {
		super(par1World);
	}
	
	public void setHP(double hp){
		this.HP=hp;
	}
	
	public void setAttack(double atck){
		this.attack=atck;
	}
	
	public void setDefense(double def){
		this.defense=def;
	}
	
	@Override
	public double getHP(){
		return HP;
	}
	
	@Override
	public double getAttack(){
		return attack;
	}
	
	@Override
	public double getDefense(){
		return defense;
	}


}
