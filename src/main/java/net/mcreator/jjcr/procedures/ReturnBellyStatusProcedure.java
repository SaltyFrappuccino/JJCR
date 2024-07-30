package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnBellyStatusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).BellyStatus == 1) {
			return "\u00A7l" + "\u00A72" + "Belly";
		} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).BellyStatus == 0) {
			return "\u00A7l" + "\u00A76" + "Belly";
		} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).BellyStatus == -1) {
			return "\u00A7l" + "\u00A74" + "Belly";
		}
		return "";
	}
}
