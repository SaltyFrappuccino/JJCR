package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WhenDEIsOpenProcedure {
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
		double localPlayerLevel = 0;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:dagon_domain_jp")), SoundSource.NEUTRAL, 0, 0);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:dagon_domain_jp")), SoundSource.NEUTRAL, 0, 0, false);
					}
				}
			}
			world = _worldorig;
		}
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_DE_SYSTEM)) {
			if (entity.getPersistentData().getDouble("skill") % 100 == 20 && entity.getPersistentData().getDouble("cnt1") >= 1) {
				entity.getPersistentData().putBoolean("jjcrFlagUsingDE", true);
				if (entity.isShiftKeyDown() == true && entity instanceof ServerPlayer _plr7 && _plr7.level() instanceof ServerLevel
						&& _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_6"))).isDone()) {
					entity.getPersistentData().putDouble("cnt2", 0);
				} else if (entity.isShiftKeyDown() == false && entity instanceof ServerPlayer _plr10 && _plr10.level() instanceof ServerLevel
						&& _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_6"))).isDone()) {
					entity.getPersistentData().putDouble("cnt2", 1);
				} else if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
						&& _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_2"))).isDone()) {
					entity.getPersistentData().putDouble("cnt2", 0);
				} else if (entity instanceof ServerPlayer _plr14 && _plr14.level() instanceof ServerLevel
						&& _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_1"))).isDone()) {
					entity.getPersistentData().putDouble("cnt2", (-1));
				}
			}
		}
	}
}
