package net.mcreator.jjcr.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetBFChanceProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.getPersistentData().putDouble("jjcrBlackFlashChance", (DoubleArgumentType.getDouble(arguments, "Black_Flash_Chance")));
				SetVariableBlackFlashChanceProcedure.execute(entity);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
