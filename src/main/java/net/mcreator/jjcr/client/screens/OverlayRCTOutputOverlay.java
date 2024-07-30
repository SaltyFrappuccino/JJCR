
package net.mcreator.jjcr.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.jjcr.procedures.ReturnRCTOutputProcedure;
import net.mcreator.jjcr.procedures.ReturnIfRCTSystemProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class OverlayRCTOutputOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (ReturnIfRCTSystemProcedure.execute())
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnRCTOutputProcedure.execute(world, entity), w / 2 + -198, h / 2 + 50, -1, false);
		}
	}
}
