package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnSorceryLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Cursed Energy Level: \u00A7l" + Math.round((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel);
	}
}