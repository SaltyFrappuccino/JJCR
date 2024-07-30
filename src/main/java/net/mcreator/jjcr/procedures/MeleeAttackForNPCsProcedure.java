package net.mcreator.jjcr.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jjcr.entity.TechEntity;
import net.mcreator.jjcr.JjcrMod;

public class MeleeAttackForNPCsProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof TechEntity) {
			sourceentity.getPersistentData().putDouble("skill", new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert("270" + Mth.nextInt(RandomSource.create(), 0, 2)));
			sourceentity.getPersistentData().putBoolean("PRESS_Z", true);
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 999999, 0, false, false));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 999999, 0, false, false));
			JjcrMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 40), () -> {
				sourceentity.getPersistentData().putBoolean("PRESS_Z", false);
			});
		}
	}
}
