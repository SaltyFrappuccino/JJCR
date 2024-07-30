package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

public class RCTOverlayGameruleFixProcedure {
	public static void execute(LevelAccessor world) {
		JjcrModVariables.MapVariables.get(world).RCTOverlay = world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM);
		JjcrModVariables.MapVariables.get(world).syncData(world);
	}
}
