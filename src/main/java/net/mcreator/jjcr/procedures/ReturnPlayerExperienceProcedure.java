package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnPlayerExperienceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Player Experience: \u00A7l" + Math.round((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerExperience);
	}
}