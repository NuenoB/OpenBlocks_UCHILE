package openblocks.common.battle.packet;

import openblocks.OpenBlocks;
import openblocks.client.gui.GuiBattle;
import net.minecraft.entity.player.EntityPlayer;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public class InitiateBattlePacket extends BattlePacket {
	
	private GuiBattle guiBattle;
	
	public InitiateBattlePacket(GuiBattle gui){
		this.guiBattle=gui;
	}

	@Override
	public void write(ByteArrayDataOutput out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(ByteArrayDataInput in) throws ProtocolException {
		
	}

	@Override
	public void execute(EntityPlayer player) throws ProtocolException {
		OpenBlocks.proxy.setGui(guiBattle);		
	}

}
