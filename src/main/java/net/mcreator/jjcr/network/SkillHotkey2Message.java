
package net.mcreator.jjcr.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.jjcr.procedures.SkillHotkey2ReleasedProcedure;
import net.mcreator.jjcr.procedures.SkillHotkey2PressedProcedure;
import net.mcreator.jjcr.JjcrMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillHotkey2Message {
	int type, pressedms;

	public SkillHotkey2Message(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SkillHotkey2Message(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SkillHotkey2Message message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SkillHotkey2Message message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			SkillHotkey2PressedProcedure.execute(entity);
		}
		if (type == 1) {

			SkillHotkey2ReleasedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		JjcrMod.addNetworkMessage(SkillHotkey2Message.class, SkillHotkey2Message::buffer, SkillHotkey2Message::new, SkillHotkey2Message::handler);
	}
}
