package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UpdateSorceryLevelProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		assert Boolean.TRUE; //#dbg:UpdateSorceryLevel:UpdateSorceryLevel
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (sourceentity.getPersistentData().getDouble("skill") != 0 && (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PhysicalAttack == false) {
				if ((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel > 50
						* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_LEVEL_MODIFIER))) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:ce_level_5");
						}
					}
				} else if ((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel > 40
						* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_LEVEL_MODIFIER))) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:ce_level_4");
						}
					}
				} else if ((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel > 30
						* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_LEVEL_MODIFIER))) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:ce_level_3");
						}
					}
				} else if ((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel > 20
						* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_LEVEL_MODIFIER))) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:ce_level_2");
						}
					}
				} else if ((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel > 10
						* (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_CE_SYSTEM_CE_LEVEL_MODIFIER))) {
					{
						Entity _ent = sourceentity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s until jjcr:ce_level_1");
						}
					}
				}
				{
					double _setval = (sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SorceryLevel
							+ (sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
					sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SorceryLevel = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
	}
}
