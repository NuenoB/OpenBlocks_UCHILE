package openblocks.common.entity.math;

import net.minecraft.item.ItemArmor;

public class DefenseStrategy implements Strategy{
	
	@Override
	public int getPlayerStats(PlayerItemStats playerStats, int i) {
        return 0; //return (playerStats.getItem(i)).damageReduceAmount;
	}

	@Override
	public int getLivingStats(LivingItemStats livingStats, int i) {
        return 0; //return (livingStats.getItem(j)).damageReduceAmount;
	}
}
