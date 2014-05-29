package openblocks.common.entity.math;

import net.minecraft.entity.Entity;

public abstract class Stats {
	abstract void statsAllocte();
	public abstract double getAttack();
	public abstract double getDefense();
	public abstract double getMagic();
	public abstract double getResistance();
	public abstract double getSpeed();
}
