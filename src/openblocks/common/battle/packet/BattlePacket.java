package openblocks.common.battle.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import openblocks.common.battle.packet.*;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.PacketDispatcher;

public abstract class BattlePacket {
	public static final String CHANNEL = "BKTBBS-Command";
	private static final BiMap<Integer, Class<? extends BattlePacket>> idMap;
	
	/**
	 * Must add new Packet class here when created.
	 */
	static {
		ImmutableBiMap.Builder<Integer, Class<? extends BattlePacket>> builder = ImmutableBiMap.builder();
		
		builder.put(Integer.valueOf(0), BattleCommandPacket.class);
		builder.put(Integer.valueOf(1), BattleCombatantPacket.class);
		builder.put(Integer.valueOf(2), InitiateBattlePacket.class);
		
		idMap = builder.build();
	}
	
	public static BattlePacket constructPacket(int packetId) throws ProtocolException, ReflectiveOperationException {
		Class<? extends BattlePacket> theClass = idMap.get(Integer.valueOf(packetId));
		if (theClass == null) {
			throw new ProtocolException("Unknown Packet Id!");
		}
		else {
			return theClass.newInstance();
		}
	}
	
	public static class ProtocolException extends Exception {
		
		public ProtocolException() {
			
		}
		
		public ProtocolException(String message, Throwable cause) {
			super(message, cause);
		}
		
		public ProtocolException(String message) {
			super(message);
		}
		
		public ProtocolException(Throwable cause) {
			super(cause);
		}
	}
	
	public final int getPacketId() {
		if (idMap.inverse().containsKey(getClass())) {
			return idMap.inverse().get(getClass()).intValue();
		}
		else {
			throw new RuntimeException("Packet " + getClass().getSimpleName() + " is missing a mapping!");
		}
	}
	
	public final Packet makePacket() {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeByte(getPacketId());
		write(out);
		return PacketDispatcher.getPacket(CHANNEL, out.toByteArray());
	}
	
	public abstract void write(ByteArrayDataOutput out);
	
	public abstract void read(ByteArrayDataInput in) throws ProtocolException;
	
	public abstract void execute(EntityPlayer player) throws ProtocolException;
}
