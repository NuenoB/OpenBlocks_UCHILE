package openblocks.common.entity.math;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerStats extends EntityStats {
	
	public PlayerStats(EntityPlayer player) {
		myself = player;
	}

	@Override
	public float attackTo(EntityStats enemy) {
		return 0;
	}
	
	
}
