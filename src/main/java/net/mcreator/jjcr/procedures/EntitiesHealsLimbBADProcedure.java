package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.jjcr.init.JjcrModMobEffects;
import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitiesHealsLimbBADProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double rand = 0;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_LIMB_SYSTEM) && world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM)) {
			JjcrMod.queueServerWork(1, () -> {
				if (entity.getPersistentData().getDouble("cnt_reverse_test") > 0 || entity.getPersistentData().getBoolean("CursedSpirit")
						|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique")))) {
					JjcrMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 300), () -> {
						if (entity.getPersistentData().getDouble("HeadStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("HeadStatus", (entity.getPersistentData().getDouble("HeadStatus") + 1));
						}
						if (entity.getPersistentData().getDouble("ChestStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("ChestStatus", (entity.getPersistentData().getDouble("ChestStatus") + 1));
						}
						if (entity.getPersistentData().getDouble("BellyStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("BellyStatus", (entity.getPersistentData().getDouble("BellyStatus") + 1));
						}
						if (entity.getPersistentData().getDouble("RightArmStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("RightArmStatus", (entity.getPersistentData().getDouble("RightArmStatus") + 1));
							if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
							} else {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
							}
						}
						if (entity.getPersistentData().getDouble("LeftArmStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("LeftArmStatus", (entity.getPersistentData().getDouble("LeftArmStatus") + 1));
							if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
							} else {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
							}
						}
						if (entity.getPersistentData().getDouble("RightLegStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("RightLegStatus", (entity.getPersistentData().getDouble("RightLegStatus") + 1));
							if (entity.getPersistentData().getDouble("jjcrLegDamageScore") >= 0) {
								entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") - 1));
							} else {
								entity.getPersistentData().putDouble("jjcrLegDamageScore", 0);
							}
						}
						if (entity.getPersistentData().getDouble("LeftLegStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("LeftLegStatus", (entity.getPersistentData().getDouble("LeftLegStatus") + 1));
							if (entity.getPersistentData().getDouble("jjcrLegDamageScore") >= 0) {
								entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") - 1));
							} else {
								entity.getPersistentData().putDouble("jjcrLegDamageScore", 0);
							}
						}
						if (entity.getPersistentData().getDouble("SecondLeftArmStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("SecondLeftArmStatus", (entity.getPersistentData().getDouble("SecondLeftArmStatus") + 1));
							if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
							} else {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
							}
						}
						if (entity.getPersistentData().getDouble("SecondRightArmStatus") <= 0) {
							entity.getPersistentData().putBoolean("PRESS_M", true);
							entity.getPersistentData().putDouble("SecondRightArmStatus", (entity.getPersistentData().getDouble("SecondRightArmStatus") + 1));
							if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
							} else {
								entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
							}
						}
						if (entity instanceof LivingEntity _livEnt66 && _livEnt66.hasEffect(JjcrModMobEffects.BLEEDING.get())) {
							JjcrMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 100), () -> {
								entity.getPersistentData().putBoolean("PRESS_M", true);
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(JjcrModMobEffects.BLEEDING.get());
							});
						}
					});
				}
			});
		}
	}
}
