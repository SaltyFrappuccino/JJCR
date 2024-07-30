package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

public class ToggleAutoRCTKeyPriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_5"))).isDone()) {
			if (entity.getPersistentData().getBoolean("jjcrAutoRCT") == false
					&& ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 100) == ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new JjcrModVariables.PlayerVariables())).RCTOutput >= (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_DECREASE_VALUE)) * 4)) {
				entity.getPersistentData().putBoolean("jjcrAutoRCT", true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7lAuto RCT On"), false);
			} else if (entity.getPersistentData().getBoolean("jjcrAutoRCT") == true) {
				entity.getPersistentData().putBoolean("jjcrAutoRCT", false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7lAuto RCT Off"), false);
			}
		}
	}
}
