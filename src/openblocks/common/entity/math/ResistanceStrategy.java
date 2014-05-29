package openblocks.common.entity.math;

import net.minecraft.item.ItemArmor;

public class ResistanceStrategy implements Strategy {

	@Override
	public int getPlayerStats(PlayerItemStats playerStats, int i) {
        return 0; //return (playerStats.getItem(i)).resistanceAmount;
	}

	@Override
	public int getLivingStats(LivingItemStats livingStats, int i) {
        return 0; //return (livingStats.getItem(j)).resistanceAmount;
	}



}
