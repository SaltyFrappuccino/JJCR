package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class SkillHotkey3ReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("PRESSED_3", false);
	}
}
