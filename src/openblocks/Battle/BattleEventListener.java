package openblocks.Battle;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class BattleEventListener {
	/**
	 * Cuando algun mob golpea al player aparecera un texto
	 * en la consola
	 *
	 * 
	 */
	BattleThread thread;
	@ForgeSubscribe
	public void entityAttacked(LivingAttackEvent event)
	{
		if(event.entity.worldObj.isRemote)
			return;
		
		if(!(event.source.getEntity() instanceof EntityLivingBase) || !(event.entity instanceof EntityLivingBase))
			return;
		
		if(event.entity == event.source.getEntity())
			return;
		
		if(event.entity instanceof EntityMob && event.source.getEntity() instanceof EntityPlayer){
			thread.initBattle(event.entity);
			return;
		}
		
		if(event.entity instanceof EntityPlayer && event.source.getEntity() instanceof EntityMob){
			thread.initBattle(event.source.getEntity());
			return;
		}
		System.out.println(event.source.getEntity().getEntityName() + "(" + event.source.getEntity().entityId
				+ ") hit " + event.entity.getEntityName() + "(" + event.entity.entityId + ").");
	}

}
