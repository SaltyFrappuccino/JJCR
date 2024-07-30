package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UpdateRCTLevelProcedure {
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
		assert Boolean.TRUE; //#dbg:UpdateRCTLevel:UpdateRCTLevel
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM) == true) {
			if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.JACKPOT.get())) == false) {
				JjcrMod.queueServerWork(1, () -> {
					if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) == true
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) && entity.getPersistentData().getBoolean("PRESS_M") == true) {
						{
							double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTLevel + 1;
							entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTLevel = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTLevel >= 24
								* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_LEVEL_MODIFIER))) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:rct_level_6");
								}
							}
							SetRCTOutputMaxProcedure.execute(world, entity);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTLevel >= 12
								* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_LEVEL_MODIFIER))) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:rct_level_5");
								}
							}
							SetRCTOutputMaxProcedure.execute(world, entity);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTLevel >= 6
								* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_LEVEL_MODIFIER))) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:rct_level_4");
								}
							}
							SetRCTOutputMaxProcedure.execute(world, entity);
						} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTLevel >= 3
								* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_LEVEL_MODIFIER))) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:rct_level_3");
								}
							}
							SetRCTOutputMaxProcedure.execute(world, entity);
						}
					}
				});
			}
		}
	}
}
