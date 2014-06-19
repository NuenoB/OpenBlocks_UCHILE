package openblocks.common.entity.math;

public interface Strategy {
	public int getPlayerStats(PlayerItemStats playerStats, int i);
	public int getLivingStats(LivingItemStats livingStats, int i);
}
