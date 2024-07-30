package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModMobEffects;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CustomBlackFlashProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		boolean BFCheck = false;
		double rand = 0;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:jogo_domain_jp")), SoundSource.NEUTRAL, 0, 0);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:jogo_domain_jp")), SoundSource.NEUTRAL, 0, 0, false);
					}
				}
			}
			world = _worldorig;
		}
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_BLACK_FLASH) == true) {
			BFCheck = true;
		} else {
			BFCheck = false;
		}
		if (BFCheck == true) {
			if (sourceentity instanceof Player || sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:black_flash_able")))) {
				if (amount >= 10) {
					rand = Mth.nextInt(RandomSource.create(), 1, 1000);
					if ((sourceentity.getPersistentData().getDouble("cnt5") > 0 || sourceentity.getPersistentData().getDouble("cnt6") > 0) && sourceentity.getPersistentData().getDouble("skill") != 0
							&& sourceentity.getPersistentData().getDouble("skill") % 100 <= 2) {
						if (sourceentity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()) == false) {
							if (sourceentity.getPersistentData().getDouble("jjcrBlackFlashChance") >= rand) {
								/*code*/
								if (sourceentity instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:black_flash"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
								/*code*/
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.ZONE.get(), 6000, 0, false, false));
								/* code */ if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = net.mcreator.jujutsucraft.init.JujutsucraftModEntities.ENTITY_BLACK_FLASH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_COSMETIC_SKILLS_VOICE_OVER) == true) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:kokusen_jp")), SoundSource.VOICE, 50, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:kokusen_jp")), SoundSource.VOICE, 50, 1, false);
										}
									}
								}
								((LivingHurtEvent) event).setAmount(((float) (amount * 2.5)));
								if ((sourceentity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(JjcrModMobEffects.BLACK_FLASH.get())) == false) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JjcrModMobEffects.BLACK_FLASH.get(), 1200, 1, false, false));
									sourceentity.getPersistentData().putDouble("jjcrBlackFlashCount", 1);
								} else {
									sourceentity.getPersistentData().putDouble("jjcrBlackFlashCount", (sourceentity.getPersistentData().getDouble("jjcrBlackFlashCount") + 1));
								}
								{
									double _setval = (sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
											+ (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_BLACK_FLASH_RESTORE_RCT_OUTPUT));
									sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.RCTOutput = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("jjc_cursepower " + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_BLACK_FLASH_RESTORE_CE)) + " @s"));
									}
								}
								if (sourceentity.getPersistentData().getDouble("jjcrBlackFlashCount") == 4) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2, false, false));
									sourceentity.getPersistentData().putBoolean("brokenBrain", false);
									sourceentity.getPersistentData().putBoolean("cnt_brokenBrain", false);
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"effect clear @s jujutsucraft:unstable");
										}
									}
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"effect clear @s jujutsucraft:cooldown_time");
										}
									}
								} else if (sourceentity.getPersistentData().getDouble("jjcrBlackFlashCount") == 3) {
									{
										double _setval = (sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
												+ (sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutputMAX * 0.25;
										sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.RCTOutput = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
								} else if (sourceentity.getPersistentData().getDouble("jjcrBlackFlashCount") == 2) {
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands()
													.performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																	_ent.getDisplayName(), _ent.level().getServer(), _ent),
															("jjc_cursepower " + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_BLACK_FLASH_RESTORE_CE)) * 1.5 + " @s"));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (false == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "clear");
		}
	}
}
