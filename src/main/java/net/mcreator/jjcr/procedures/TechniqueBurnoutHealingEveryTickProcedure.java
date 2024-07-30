package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TechniqueBurnoutHealingEveryTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM_ENABLE_TECHNIQUE_BURNOUT_HEALING)) {
			if (entity.getPersistentData().getBoolean("jjcrTechniqueBurnoutHealing") == true) {
				if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.COOLDOWN_TIME.get())) == true
						|| (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.UNSTABLE.get())) == true) {
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJRC_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_RCT_COST)) >= 0) {
						entity.getPersistentData().putDouble("jjcrCNT_TechniqueBurnoutHealing", (entity.getPersistentData().getDouble("jjcrCNT_TechniqueBurnoutHealing") + 1));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Technique Burnout Healing Progress: \u00A7l" + entity.getPersistentData().getDouble("jjcrCNT_TechniqueBurnoutHealing") + "%")), true);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FIREWORK, (entity.getX()), (entity.getY() + 1.8), (entity.getZ()), 1, 0.25, 0.25, 0.25, 0.1);
						if (entity.getPersistentData().getDouble("jjcrCNT_TechniqueBurnoutHealing") == 100) {
							entity.getPersistentData().putDouble("jjcrCNT_TechniqueBurnoutHealing", 0);
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:unstable");
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cooldown_time");
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJRC_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_CE_COST)) + " @s"));
								}
							}
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.UNSTABLE.get())) == false) {
					entity.getPersistentData().putDouble("jjcrCNT_TechniqueBurnoutHealing", 0);
				}
			}
		}
	}
}
