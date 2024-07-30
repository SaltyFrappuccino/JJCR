package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

public class PlayerGetCETraitProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double randTrait = 0;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM_CE_TRAITS)) {
				if (entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:ce_level_4"))).isDone()) {
					if (((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyTrait).equals("") == true) {
						randTrait = Mth.nextInt(RandomSource.create(), 1, 6);
						if (randTrait == 1) {
							{
								String _setval = "\u00A75" + "Lightning";
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.CursedEnergyTrait = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randTrait == 2) {
							{
								String _setval = "\u00A74" + "Fire";
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.CursedEnergyTrait = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randTrait == 3) {
							{
								String _setval = "\u00A73" + "Ice";
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.CursedEnergyTrait = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randTrait == 4) {
							{
								String _setval = "\u00A72" + "Rough";
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.CursedEnergyTrait = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randTrait == 5) {
							{
								String _setval = "\u00A77" + "Explosive";
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.CursedEnergyTrait = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randTrait == 6) {
							{
								String _setval = "\u00A7d" + "Poison";
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.CursedEnergyTrait = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}
}
