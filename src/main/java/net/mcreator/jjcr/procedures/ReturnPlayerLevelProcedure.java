package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnPlayerLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Player Level: \u00A7l" + Math.round((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerLevel);
	}
}
