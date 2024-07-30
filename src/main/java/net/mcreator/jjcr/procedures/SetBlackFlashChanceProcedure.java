package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

public class SetBlackFlashChanceProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double BFChance = 0;
		BFChance = (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_BLACK_FLASH_CHANCE));
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.NETHER);
			if (world != null) {
				if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 21) {
					entity.getPersistentData().putDouble("jjcrBlackFlashChance", BFChance);
					entity.getPersistentData().putDouble("jjcrBlackFlashChance",
							(entity.getPersistentData().getDouble("jjcrBlackFlashChance") + 50 + (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower));
				} else {
					entity.getPersistentData().putDouble("jjcrBlackFlashChance", BFChance);
					entity.getPersistentData().putDouble("jjcrBlackFlashChance",
							(entity.getPersistentData().getDouble("jjcrBlackFlashChance") + (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower));
				}
				SetVariableBlackFlashChanceProcedure.execute(entity);
			}
			world = _worldorig;
		}
	}
}
