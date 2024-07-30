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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModMobEffects;
import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ActivateAdvancedTechniqueMegumiProcedure {
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
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:hakari_domain_jp")), SoundSource.NEUTRAL, 0, 0);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:hakari_domain_jp")), SoundSource.NEUTRAL, 0, 0, false);
				}
			}
		});
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_ADVANCED_TECHNIQUE_MEGUMI)) {
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 8 && entity instanceof LivingEntity _livEnt3
					&& _livEnt3.hasEffect(JjcrModMobEffects.EFFECT_ADVANCED_TECHNIQUE.get())) {
				if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_ADVANCED_TECHNIQUE_MEGUMI_SUMMON_AGITO)) {
					SacrificeShikigamiesForAgitoProcedure.execute(world, x, y, z, entity);
				}
			} else if (((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5
					|| (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6) && entity instanceof LivingEntity _livEnt5
					&& _livEnt5.hasEffect(JjcrModMobEffects.EFFECT_ADVANCED_TECHNIQUE.get())) {
				if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_ADVANCED_TECHNIQUE_MEGUMI_SUMMONS_TOTALITY)) {
					SacrificeShikigamiesForTotalityProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
