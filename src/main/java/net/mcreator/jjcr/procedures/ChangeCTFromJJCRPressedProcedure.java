package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ChangeCTFromJJCRPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("jjcrCustomCT") != 0) {
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 28) {
				if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15) {
					if (entity.getPersistentData().getDouble("jjcrCustomSkill") == 0) {
						entity.getPersistentData().putDouble("jjcrCustomSkill", 1);
					} else if (entity.getPersistentData().getDouble("jjcrCustomSkill") == 1) {
						entity.getPersistentData().putDouble("jjcrCustomSkill", 2);
					} else if (entity.getPersistentData().getDouble("jjcrCustomSkill") == 2) {
						entity.getPersistentData().putDouble("jjcrCustomSkill", 0);
					}
				}
			}
		}
	}
}
