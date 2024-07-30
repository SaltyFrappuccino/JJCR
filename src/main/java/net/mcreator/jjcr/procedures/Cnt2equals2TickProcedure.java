package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class Cnt2equals2TickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Range", 66);
	}
}
