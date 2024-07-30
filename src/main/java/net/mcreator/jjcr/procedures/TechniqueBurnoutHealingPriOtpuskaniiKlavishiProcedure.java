package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

public class TechniqueBurnoutHealingPriOtpuskaniiKlavishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("jjcrTechniqueBurnoutHealing", false);
	}
}
