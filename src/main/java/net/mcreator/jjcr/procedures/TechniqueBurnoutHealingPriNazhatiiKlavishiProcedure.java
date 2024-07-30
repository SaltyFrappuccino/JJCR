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

public class TechniqueBurnoutHealingPriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM_ENABLE_TECHNIQUE_BURNOUT_HEALING)) {
			if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_6"))).isDone()) {
				if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput >= (world.getLevelData().getGameRules()
						.getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_RCT_COST))
						&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= (world.getLevelData().getGameRules()
								.getInt(JjcrModGameRules.JJRC_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_CE_COST))) {
					entity.getPersistentData().putBoolean("jjcrTechniqueBurnoutHealing", true);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Message"), false);
				}
			}
		}
	}
}
