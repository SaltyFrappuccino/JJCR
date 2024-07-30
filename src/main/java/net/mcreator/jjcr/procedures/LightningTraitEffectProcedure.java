package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModParticleTypes;
import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LightningTraitEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM_CE_TRAITS)) {
				if (sourceentity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jjcr:ce_level_4"))).isDone()) {
					if (((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyTrait).equals("\u00A75Lightning")) {
						if (sourceentity.getPersistentData().getDouble("cnt6") >= 2.5 && (sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PhysicalAttack == true) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JjcrModParticleTypes.LIGHTNING.get()), x, y, z, 25, 1, 1, 1, 1);
							entity.getPersistentData().putDouble("Thunder", (entity.getPersistentData().getDouble("Thunder") + 1));
							JjcrMod.queueServerWork(10, () -> {
								if (entity.getPersistentData().getDouble("Thunder") >= 5) {
									entity.getPersistentData().putDouble("Thunder", 10);
									sourceentity.getPersistentData().putDouble("skill", 705);
									sourceentity.getPersistentData().putBoolean("PRESS_Z", true);
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 0, false, false));
									JjcrMod.queueServerWork(5, () -> {
										entity.getPersistentData().putDouble("Thunder", 0);
									});
								}
							});
						}
					}
				}
			}
		}
	}
}
