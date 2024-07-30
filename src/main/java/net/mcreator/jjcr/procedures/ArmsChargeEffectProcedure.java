package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ArmsChargeEffectProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("cnt6") >= 2 && entity.getPersistentData().getDouble("skill") != 0 && entity.getPersistentData().getDouble("cnt5") >= 19
				&& entity.getPersistentData().getDouble("jjcrCustomCDCount") < entity.getPersistentData().getDouble("jjcrTechniqueChargeCustomCD")) {
			entity.getPersistentData().putDouble("cnt5", 0);
			entity.getPersistentData().putDouble("jjcrCustomCDCount", (entity.getPersistentData().getDouble("jjcrCustomCDCount") + 1));
		} else if (entity.getPersistentData().getDouble("skill") == 0) {
			entity.getPersistentData().putDouble("jjcrCustomCDCount", 0);
		}
	}
}
