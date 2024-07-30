package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class BlackFlashEndedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("jjcrBlackFlashCount", 0);
	}
}
