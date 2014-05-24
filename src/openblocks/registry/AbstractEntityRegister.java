package openblocks.registry;

import openblocks.common.entity.EntityHolyPig;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
/**
 * Class that allows to register an entity
 * @author Camila Alvarez
 *
 */
public abstract class AbstractEntityRegister implements IEntityRegister {
	
	protected Class entityClass;
	protected String entityName;
	protected String shownName;

	
	/** 
	 * Sets important entity info
	 * @param entityClass entity class
	 * @param name entity name
	 * @param shownName name that will be shown on screen
	 */
	public void setInfo(Class<? extends Entity> entityClass, String name, String shownName){
		this.entityClass=entityClass;
		this.entityName=name;
		this.shownName=shownName;
	}
	
	/**
	 *Method that registers the entity 
	 * @param weightedProb Probability of appereance
	 * @param min minimun number of entities that will appear
	 * @param max maximun number of entities that can be present at the same
	 * time
	 * @param type Entity type
	 * @param eggColor Background egg color
	 * @param spotColor Egg spot color
	 */
	public void register(int weightedProb, int min, int max, EnumCreatureType type, int eggColor, int spotColor){
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId()
				, eggColor, spotColor);
		EntityRegistry.addSpawn(entityClass, weightedProb, min, max, type);
	}
	
	/**
	 *Method that registers the entity, without creating a spawn egg 
	 * @param weightedProb Probability of appereance
	 * @param min minimun number of entities that will appear
	 * @param max maximun number of entities that can be present at the same
	 * time
	 * @param type Entity type
	 * @param eggColor Background egg color
	 * @param spotColor Egg spot color
	 */
	public void register(int weightedProb, int min, int max, EnumCreatureType type){
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.addSpawn(entityClass, weightedProb, min, max, type);
	}

}
