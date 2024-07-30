package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

public class ChangeDETypePriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
			if (entity.getPersistentData().getDouble("jjcrDomainType") == 0) {
				if (entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_5"))).isDone()) {
					entity.getPersistentData().putDouble("jjcrDomainType", (-1));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(JjcrModVariables.MapVariables.get(world).YourDomainTypeChangeToSmall), false);
				} else if (entity instanceof ServerPlayer _plr7 && _plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_4"))).isDone()) {
					entity.getPersistentData().putDouble("jjcrDomainType", 1);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(JjcrModVariables.MapVariables.get(world).YourDomainTypeChangeToHuge), false);
				}
			} else if (entity.getPersistentData().getDouble("jjcrDomainType") == -1) {
				if (entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel && _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_4"))).isDone()) {
					entity.getPersistentData().putDouble("jjcrDomainType", 1);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(JjcrModVariables.MapVariables.get(world).YourDomainTypeChangeToHuge), false);
				} else if (entity instanceof ServerPlayer _plr14 && _plr14.level() instanceof ServerLevel
						&& _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:de_level_2"))).isDone()) {
					entity.getPersistentData().putDouble("jjcrDomainType", 0);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(JjcrModVariables.MapVariables.get(world).YourDomainTypeChangeToNormal), false);
				}
			} else if (entity.getPersistentData().getDouble("jjcrDomainType") == 1) {
				entity.getPersistentData().putDouble("jjcrDomainType", 0);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(JjcrModVariables.MapVariables.get(world).YourDomainTypeChangeToNormal), false);
			}
		}
	}
}
