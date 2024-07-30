package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnRArmProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RightArmStatus == 1) {
			return "\u00A7l" + "\u00A72" + "R Arm";
		} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RightArmStatus == 0) {
			return "\u00A7l" + "\u00A76" + "R Arm";
		} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RightArmStatus == -1) {
			return "\u00A7l" + "\u00A74" + "R Arm";
		}
		return "";
	}
}
