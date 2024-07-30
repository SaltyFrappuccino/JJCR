package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LimbSystemOnPlayerRespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_LIMB_SYSTEM)) {
			JjcrMod.queueServerWork(1, () -> {
				entity.getPersistentData().putDouble("HeadStatus", 1);
				entity.getPersistentData().putDouble("ChestStatus", 1);
				entity.getPersistentData().putDouble("BellyStatus", 1);
				entity.getPersistentData().putDouble("RightArmStatus", 1);
				entity.getPersistentData().putDouble("LeftArmStatus", 1);
				entity.getPersistentData().putDouble("LeftLegStatus", 1);
				entity.getPersistentData().putDouble("RightLegStatus", 1);
				entity.getPersistentData().putDouble("SecondLeftArmStatus", 1);
				entity.getPersistentData().putDouble("SecondRightArmStatus", 1);
			});
		}
	}
}
