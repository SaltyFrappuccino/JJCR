package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class Cnt2equalsminus1KazhdyiTikVoVriemiaEffiektaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("cnt2", (-1));
	}
}
