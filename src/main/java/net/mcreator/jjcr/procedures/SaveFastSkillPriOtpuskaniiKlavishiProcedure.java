package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class SaveFastSkillPriOtpuskaniiKlavishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("PRESSED_SafeFastSkill", false);
	}
}