package net.mcreator.jjcr.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jjcr.world.inventory.RPGInterfaceMenu;
import net.mcreator.jjcr.procedures.ReturnSorceryLevelProcedure;
import net.mcreator.jjcr.procedures.ReturnRCTLevelProcedure;
import net.mcreator.jjcr.procedures.ReturnPlayerLevelProcedure;
import net.mcreator.jjcr.procedures.ReturnPlayerFameProcedure;
import net.mcreator.jjcr.procedures.ReturnPlayerExperienceProcedure;
import net.mcreator.jjcr.procedures.ReturnPhysicalLevelProcedure;
import net.mcreator.jjcr.procedures.ReturnDELevelProcedure;
import net.mcreator.jjcr.procedures.ReturnCursedToolsLevelProcedure;
import net.mcreator.jjcr.procedures.ReturnCursedTechniquesLevelProcedure;
import net.mcreator.jjcr.procedures.ReturnCETraitProcedure;
import net.mcreator.jjcr.procedures.ReturnCEColorProcedure;
import net.mcreator.jjcr.procedures.ReturnBlackFlashChanceProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RPGInterfaceScreen extends AbstractContainerScreen<RPGInterfaceMenu> {
	private final static HashMap<String, Object> guistate = RPGInterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public RPGInterfaceScreen(RPGInterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 325;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("jjcr:textures/screens/rpg_interface.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnPhysicalLevelProcedure.execute(entity), 9, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSorceryLevelProcedure.execute(entity), 9, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCursedTechniquesLevelProcedure.execute(entity), 9, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCursedToolsLevelProcedure.execute(entity), 9, 61, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnRCTLevelProcedure.execute(entity), 9, 79, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnDELevelProcedure.execute(entity), 9, 97, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCEColorProcedure.execute(entity), 171, 61, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCETraitProcedure.execute(entity), 171, 79, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnBlackFlashChanceProcedure.execute(entity), 171, 97, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerLevelProcedure.execute(entity), 171, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerFameProcedure.execute(entity), 171, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerExperienceProcedure.execute(entity), 171, 43, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
