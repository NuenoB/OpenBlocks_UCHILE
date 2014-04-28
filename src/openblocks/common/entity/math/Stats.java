package openblocks.common.entity.math;

import net.minecraft.entity.Entity;

public abstract class Stats {
	abstract void statsAllocte();
	public abstract float getAttack();
	public abstract float getDefense();
	public abstract float getMagic();
	public abstract float getResistance();
	public abstract float getSpeed();
}
