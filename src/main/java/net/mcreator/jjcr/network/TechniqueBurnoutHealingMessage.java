
package net.mcreator.jjcr.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.jjcr.procedures.TechniqueBurnoutHealingPriOtpuskaniiKlavishiProcedure;
import net.mcreator.jjcr.procedures.TechniqueBurnoutHealingPriNazhatiiKlavishiProcedure;
import net.mcreator.jjcr.JjcrMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TechniqueBurnoutHealingMessage {
	int type, pressedms;

	public TechniqueBurnoutHealingMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public TechniqueBurnoutHealingMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(TechniqueBurnoutHealingMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(TechniqueBurnoutHealingMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			TechniqueBurnoutHealingPriNazhatiiKlavishiProcedure.execute(world, entity);
		}
		if (type == 1) {

			TechniqueBurnoutHealingPriOtpuskaniiKlavishiProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		JjcrMod.addNetworkMessage(TechniqueBurnoutHealingMessage.class, TechniqueBurnoutHealingMessage::buffer, TechniqueBurnoutHealingMessage::new, TechniqueBurnoutHealingMessage::handler);
	}
}