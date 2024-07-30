package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class SetVariableBlackFlashChanceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity.getPersistentData().getDouble("jjcrBlackFlashChance");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlackFlashChance = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
