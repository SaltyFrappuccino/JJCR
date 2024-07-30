package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

public class SetCEColorToGreenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "\u00A72Green";
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CursedEnergyColor = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
