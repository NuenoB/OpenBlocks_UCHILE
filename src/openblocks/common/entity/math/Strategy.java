package openblocks.common.entity.math;

public interface Strategy {
	public int getPlayerStats(PlayerStats playerStats, int i);
	public int getLivingStats(LivingStats livingStats, int i);
}
