package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.JjcrMod;

public class PassiveTechniquePriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.COOLDOWN_TIME.get())) == false) {
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 205);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 604);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 5) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 510);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 20) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 2005);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 13) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 1305);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 9) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 910);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 18) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 1810);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 27) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 2705);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 7) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 705);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique == 7) {
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				entity.getPersistentData().putDouble("skill", 705);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putBoolean("PRESS_Z", false);
				});
			}
		}
	}
}
