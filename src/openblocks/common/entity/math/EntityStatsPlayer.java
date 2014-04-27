package openblocks.common.entity.math;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class EntityStatsPlayer extends EntityPlayer {

	public EntityStats stats = new PlayerStats(this);
	
	public EntityStatsPlayer(World par1World, String par2Str) {
		super(par1World, par2Str);
	}

	public EntityStats getStats() {
		return stats;
	}

}
