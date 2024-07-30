package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SetRCTOutputMaxProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		assert Boolean.TRUE; //#dbg:SetRCTOutputMax:SetRCTOutputMAX
		if ((entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_6"))).isDone()) == true) {
			{
				double _setval = 30 * (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER));
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTOutputMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
				&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_5"))).isDone()) == true) {
			{
				double _setval = 20 * (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER));
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTOutputMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_4"))).isDone()) {
			{
				double _setval = 10 * (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER));
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTOutputMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_3"))).isDone()) {
			{
				double _setval = 7.5 * (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER));
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTOutputMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (entity instanceof ServerPlayer _plr7 && _plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_2"))).isDone()) {
			{
				double _setval = 5 * (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER));
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTOutputMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (entity instanceof ServerPlayer _plr9 && _plr9.level() instanceof ServerLevel && _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:rct_level_1"))).isDone()) {
			{
				double _setval = 2.5 * (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER));
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTOutputMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
