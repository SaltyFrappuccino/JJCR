package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jjcr.init.JjcrModMobEffects;
import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetBleedingProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double rand = 0;
		double limbRand = 0;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_LIMB_SYSTEM_BLEEDING)) {
			limbRand = Mth.nextInt(RandomSource.create(), 1, 1000);
			if (limbRand <= sourceentity.getPersistentData().getDouble("jjcrBleedingChance")) {
				JjcrMod.queueServerWork(1, () -> {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JjcrModMobEffects.BLEEDING.get(), 1200, 1));
				});
			}
		}
	}
}
