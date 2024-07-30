package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class EnableFastSkillsHotkeysPriNazhatiiKlavishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("jjcrEnableFastSkills") == true) {
			entity.getPersistentData().putBoolean("jjcrEnableFastSkills", false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7lFast Skills disabled"), false);
		} else if (entity.getPersistentData().getBoolean("jjcrEnableFastSkills") == false) {
			entity.getPersistentData().putBoolean("jjcrEnableFastSkills", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7lFast Skills enabled"), false);
		}
	}
}
