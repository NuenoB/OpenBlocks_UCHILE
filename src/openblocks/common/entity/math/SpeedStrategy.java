package openblocks.common.entity.math;

import net.minecraft.item.ItemArmor;

public class SpeedStrategy implements Strategy {

	@Override
	public int getPlayerStats(PlayerItemStats playerStats, int i) {
        return 0; //return (playerStats.getItem(i)).speedAmount;
	}

	@Override
	public int getLivingStats(LivingItemStats livingStats, int i) {
	      return 0; //return (livingStats.getItem(j)).speedAmount;
	}



}
