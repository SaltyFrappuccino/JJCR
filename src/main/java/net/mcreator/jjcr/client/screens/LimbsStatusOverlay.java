
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

import net.mcreator.jjcr.procedures.ReturnRLegProcedure;
import net.mcreator.jjcr.procedures.ReturnRArmProcedure;
import net.mcreator.jjcr.procedures.ReturnRArm2Procedure;
import net.mcreator.jjcr.procedures.ReturnLLegProcedure;
import net.mcreator.jjcr.procedures.ReturnLArmProcedure;
import net.mcreator.jjcr.procedures.ReturnLArm2Procedure;
import net.mcreator.jjcr.procedures.ReturnHeadStatusProcedure;
import net.mcreator.jjcr.procedures.ReturnChestStatusProcedure;
import net.mcreator.jjcr.procedures.ReturnBellyStatusProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class LimbsStatusOverlay {
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
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnHeadStatusProcedure.execute(entity), 6, h - 232, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnChestStatusProcedure.execute(entity), 6, h - 212, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnBellyStatusProcedure.execute(entity), 6, h - 192, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnRArmProcedure.execute(entity), 6, h - 172, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnLArmProcedure.execute(entity), 6, h - 152, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnRLegProcedure.execute(entity), 6, h - 132, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnLLegProcedure.execute(entity), 6, h - 112, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnRArm2Procedure.execute(entity), 6, h - 92, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnLArm2Procedure.execute(entity), 6, h - 72, -1, false);
		}
	}
}
