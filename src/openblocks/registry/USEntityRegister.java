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
	
	private static IEntityRegister registry;
	
	private USEntityRegister(){
	}
	
	public static IEntityRegister getInstance(){
		if(registry==null){
			return new USEntityRegister();
		}
		return registry;
	}

	@Override
	public void register(int weightedProb, int min, int max, EnumCreatureType type, int eggColor, int spotColor){
		super.register(weightedProb, min, max, type, eggColor, spotColor);
		LanguageRegistry.instance().addStringLocalization("entity."+entityName+".name", "en_US", shownName);
	}
	
	@Override
	public void register(int weightedProb, int min, int max, EnumCreatureType type){
		super.register(weightedProb, min, max, type);
		LanguageRegistry.instance().addStringLocalization("entity."+entityName+".name", "en_US", shownName);
	}

}
