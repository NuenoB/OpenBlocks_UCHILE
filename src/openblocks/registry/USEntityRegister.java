package openblocks.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import cpw.mods.fml.common.registry.LanguageRegistry;
/**
 * Registers entity in english
 * @author Mi Pc
 *
 */
public class USEntityRegister extends AbstractEntityRegister{
	
	public USEntityRegister(Class<? extends Entity> entityClass, String name,
			String shownName) {
		super(entityClass, name, shownName);
	}

	@Override
	public void register(int weightedProb, int min, int max, EnumCreatureType type, int eggColor, int spotColor){
		LanguageRegistry.instance().addStringLocalization("entity."+entityName+".name", "en_US", shownName);
	}
	
	@Override
	public void register(int weightedProb, int min, int max, EnumCreatureType type){
		LanguageRegistry.instance().addStringLocalization("entity."+entityName+".name", "en_US", shownName);
	}

}
