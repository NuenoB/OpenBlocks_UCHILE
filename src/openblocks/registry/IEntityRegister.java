package openblocks.registry;

import net.minecraft.entity.EnumCreatureType;

/**
 * Interface for EntityRegister
 * @author Mi Pc
 *
 */
public interface IEntityRegister {

	public void register(int weightedProb, int min, int max, EnumCreatureType type, int eggColor, int spotColor);
	public void register(int weightedProb, int min, int max, EnumCreatureType type);
}
