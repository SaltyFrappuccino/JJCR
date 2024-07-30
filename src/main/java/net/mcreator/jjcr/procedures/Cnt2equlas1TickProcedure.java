package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class Cnt2equlas1TickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Range", 30);
	}
}
