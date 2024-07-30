package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SkillHotkey1PriNazhatiiKlavishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("PRESSED_1", true);
		if (entity.getPersistentData().getBoolean("jjcrEnableFastSkills")) {
			if (entity.getPersistentData().getBoolean("PRESSED_SafeFastSkill") == false && entity.getPersistentData().getDouble("FastSkill_1") != 0) {
				entity.getPersistentData().putDouble("skill", (entity.getPersistentData().getDouble("FastSkill_1")));
				entity.getPersistentData().putBoolean("PRESS_Z", true);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
					}
				}
			}
		}
	}
}
