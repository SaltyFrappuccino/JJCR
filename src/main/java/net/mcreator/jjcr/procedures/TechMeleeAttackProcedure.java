package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jjcr.init.JjcrModMobEffects;
import net.mcreator.jjcr.entity.TechEntity;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TechMeleeAttackProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double randAttack = 0;
		if (sourceentity instanceof TechEntity) {
			if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.UNSTABLE.get())) == false) {
				if (!(sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JjcrModMobEffects.TECH_DE.get()))) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JjcrModMobEffects.TECH_DE.get(), 600, 1, false, false));
					entity.getPersistentData().putDouble("jjcrDebug", 2720);
					sourceentity.getPersistentData().putDouble("skill", 2720);
					sourceentity.getPersistentData().putDouble("cnt3", 20);
					sourceentity.getPersistentData().putBoolean("PRESS_Z", true);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 99999, 0, false, false));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 99999, 0, false, false));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 999999, 255, false, false));
					JjcrMod.queueServerWork(50, () -> {
						JjcrMod.queueServerWork(10, () -> {
							sourceentity.getPersistentData().putBoolean("PRESS_Z", false);
							sourceentity.getPersistentData().putDouble("skill", 2719);
							sourceentity.getPersistentData().putBoolean("PRESS_Z", true);
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 99999, 0, false, false));
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 99999, 0, false, false));
							JjcrMod.queueServerWork(10, () -> {
								sourceentity.getPersistentData().putBoolean("PRESS_Z", false);
							});
						});
					});
				}
			} else if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.UNSTABLE.get())) == true) {
				randAttack = Mth.nextInt(RandomSource.create(), 1, 30);
				if (randAttack <= 15) {
					MeleeAttackForNPCsProcedure.execute(world, sourceentity);
				} else if (randAttack > 15 == (randAttack <= 20)) {
					sourceentity.getPersistentData().putDouble("skill", 2015);
					sourceentity.getPersistentData().putBoolean("PRESS_Z", true);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 99999, 0, false, false));
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 99999, 0, false, false));
					JjcrMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 100), () -> {
						sourceentity.getPersistentData().putBoolean("PRESS_Z", false);
					});
				}
			}
		}
	}
}
