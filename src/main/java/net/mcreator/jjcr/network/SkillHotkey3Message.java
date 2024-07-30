
package net.mcreator.jjcr.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.jjcr.procedures.SkillHotkey3ReleasedProcedure;
import net.mcreator.jjcr.procedures.SkillHotkey3PressedProcedure;
import net.mcreator.jjcr.JjcrMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillHotkey3Message {
	int type, pressedms;

	public SkillHotkey3Message(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SkillHotkey3Message(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SkillHotkey3Message message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SkillHotkey3Message message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			SkillHotkey3PressedProcedure.execute(entity);
		}
		if (type == 1) {

			SkillHotkey3ReleasedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		JjcrMod.addNetworkMessage(SkillHotkey3Message.class, SkillHotkey3Message::buffer, SkillHotkey3Message::new, SkillHotkey3Message::handler);
	}
}
