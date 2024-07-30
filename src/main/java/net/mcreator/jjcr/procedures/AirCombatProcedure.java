package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AirCombatProcedure {
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
		JjcrMod.queueServerWork(1, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:jogo_domain_jp")), SoundSource.NEUTRAL, 0, 0);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:jogo_domain_jp")), SoundSource.NEUTRAL, 0, 0, false);
				}
			}
		});
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_AIR_COMBAT)) {
			if ((entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
					&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) == true) {
				if (entity instanceof LivingEntity _livEnt0 && (_livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()) == false)) {
					if (entity.onGround()) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:double_jump_effect 1 1 true");
							}
						}
					}
				}
			} else if ((entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
					&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).isDone()) == true) {
				if (entity instanceof LivingEntity _livEnt0 && (_livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()) == false)) {
					if (entity.onGround()) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:double_jump_effect 1 0 true");
							}
						}
					}
				}
			}
		}
	}
}
