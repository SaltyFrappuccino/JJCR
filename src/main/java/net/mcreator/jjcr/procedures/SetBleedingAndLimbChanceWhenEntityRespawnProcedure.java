package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SetBleedingAndLimbChanceWhenEntityRespawnProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("jjcrBleedingChance", (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_LIMB_SYSTEM_BLEEDING_CHANCE)));
		entity.getPersistentData().putDouble("jjcrLimbDamageChance", (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_LIMB_SYSTEM_DAMAGE_CHANCE)));
	}
}
