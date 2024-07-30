package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModParticleTypes;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AlwaysShowCEColorParticlesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM_ALWAYS_SHOW_CE_PARTICLES)) {
				if (entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:ce_level_1"))).isDone()) {
					if (((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyColor).equals("\u00A74Red")) {
						if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 12000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, y, z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 7.5), 1,
										1.75, 1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 8000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 5),
										0.75, 1.5, 0.75, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 6000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 3.5),
										0.5, 1.3, 0.5, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 4000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 2.5),
										0.4, 1.2, 0.4, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2800) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1.5),
										0.3, 1, 0.3, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1),
										0.15, 0.9, 0.15, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 1000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.5),
										0.1, 0.75, 0.1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 0) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_RED.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.1),
										0.1, 0.5, 0.1, 0.05);
						}
					} else if (((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyColor).equals("\u00A76Orange")) {
						if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 12000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, y, z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 7.5), 1,
										1.75, 1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 8000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 5),
										0.75, 1.5, 0.75, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 6000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z,
										(int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 3.5), 0.5, 1.3, 0.5, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 4000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z,
										(int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 2.5), 0.4, 1.2, 0.4, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2800) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z,
										(int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1.5), 0.3, 1, 0.3, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1),
										0.15, 0.9, 0.15, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 1000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z,
										(int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.5), 0.1, 0.75, 0.1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 0) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get()), x, (y + 1), z,
										(int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.1), 0.1, 0.5, 0.1, 0.05);
						}
					} else if (((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyColor).equals("\u00A79Blue")) {
						if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 12000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, y, z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 7.5), 1,
										1.75, 1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 8000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 5),
										0.75, 1.5, 0.75, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 6000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 3.5),
										0.5, 1.3, 0.5, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 4000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 2.5),
										0.4, 1.2, 0.4, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2800) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1.5),
										0.3, 1, 0.3, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1),
										0.15, 0.9, 0.15, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 1000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.5),
										0.1, 0.75, 0.1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 0) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_BLUE.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.1),
										0.1, 0.5, 0.1, 0.05);
						}
					} else if (((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyColor).equals("\u00A72Green")) {
						if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 12000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, y, z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 7.5), 1,
										1.75, 1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 8000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 5),
										0.75, 1.5, 0.75, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 6000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 3.5),
										0.5, 1.3, 0.5, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 4000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 2.5),
										0.4, 1.2, 0.4, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2800) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1.5),
										0.3, 1, 0.3, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 2000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 1),
										0.15, 0.9, 0.15, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 1000) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.5),
										0.1, 0.75, 0.1, 0.05);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 0) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.CURSED_ENERGY_GREEN.get()), x, (y + 1), z, (int) ((world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_PARTICLES_VALUE)) * 0.1),
										0.1, 0.5, 0.1, 0.05);
						}
					}
				}
			}
		}
	}
}
