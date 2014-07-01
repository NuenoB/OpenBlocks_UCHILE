package openblocks.common.item;

import openblocks.common.entity.math.EnumBonusEffects;

public class ItemNormalSword extends AbstractCuttingWeapon{

	public ItemNormalSword(int id) {
		super(id, 7, 80000, "normal_sword");
		effect=EnumBonusEffects.NONE;
	}
	
	

}
