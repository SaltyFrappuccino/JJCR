package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

public class IncreaseOutputPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM_INCREASE_OUTPUT)) {
				if (entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:ce_level_5"))).isDone()) {
					if (entity.getPersistentData().getDouble("skill") != 0 && entity.getPersistentData().getDouble("cnt6") >= 5) {
						if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
								new JjcrModVariables.PlayerVariables())).PlayerCursePower >= (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost
										* ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_INCREASE_OUTPUT_COST)) / 100)) {
							if (entity.getPersistentData().getDouble("jjcrCEOutputOverride") == 0) {
								entity.getPersistentData().putDouble("jjcrCEOutputOverride", (entity.getPersistentData().getDouble("cnt6")));
							}
							if (entity.getPersistentData().getDouble("jjcrCEOutputOverride") <= (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_INCREASE_OUTPUT_MAX))) {
								entity.getPersistentData().putDouble("jjcrCEOutputOverride", (entity.getPersistentData().getDouble("jjcrCEOutputOverride") + 1));
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute as @s run jjc_cursepower -" + (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost
														* ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_INCREASE_OUTPUT_COST)) / 100) + " @s"));
									}
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("You increased your Output! Now its \u00A7l" + entity.getPersistentData().getDouble("jjcrCEOutputOverride"))), false);
							}
						}
					}
				}
			}
		}
	}
}
