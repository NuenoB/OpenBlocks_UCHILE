package openblocks.common.entity.math;

import net.minecraft.item.ItemArmor;

public class DefenseStrategy implements Strategy{
	
	@Override
	public int getPlayerStats(PlayerStats playerStats, int i) {
        return 0; //return (playerStats.getItem(i)).damageReduceAmount;
	}

	@Override
	public int getLivingStats(LivingStats livingStats, int i) {
        return 0; //return (livingStats.getItem(j)).damageReduceAmount;
	}
}
