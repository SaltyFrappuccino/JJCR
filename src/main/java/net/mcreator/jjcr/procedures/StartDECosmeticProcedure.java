package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StartDECosmeticProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_COSMETIC)) {
			if (entity.getPersistentData().getDouble("cnt1") == 1) {
				if (entity.getPersistentData().getDouble("skill") == 120) {
					SukunaDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 220) {
					SatoruDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 520) {
					OkkotsuDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 620) {
					MegumiDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 1520) {
					MahitoDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 420) {
					JogoDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 820) {
					DagonDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 1420) {
					HanamiDECosmeticProcedure.execute(world, x, y, z);
				} else if (entity.getPersistentData().getDouble("skill") == 2920) {
					HakariDECosmeticProcedure.execute(world, x, y, z);
				}
			}
		}
	}
}
