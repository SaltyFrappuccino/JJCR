package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

public class BleedingKazhdyiTikVoVriemiaEffiektaProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_LIMB_SYSTEM_BLEEDING)) {
			JjcrMod.queueServerWork(1, () -> {
				if (entity.getPersistentData().getDouble("jjcrCNT_Bleeding") >= 60) {
					entity.getPersistentData().putDouble("jjcrCNT_Bleeding", 0);
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s minecraft:instant_damage 1 0 true");
						}
					}
				} else if (entity.getPersistentData().getDouble("jjcrCNT_Bleeding") < 60) {
					entity.getPersistentData().putDouble("jjcrCNT_Bleeding", (entity.getPersistentData().getDouble("jjcrCNT_Bleeding") + 1));
				}
			});
		}
	}
}
