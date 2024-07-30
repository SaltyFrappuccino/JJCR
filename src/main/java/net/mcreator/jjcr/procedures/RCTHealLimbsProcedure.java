package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import java.util.List;
import java.util.Comparator;

public class RCTHealLimbsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rand = 0;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_LIMB_SYSTEM) && world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM)) {
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower > (world.getLevelData().getGameRules()
					.getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST))
					&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput > (world.getLevelData().getGameRules()
							.getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST))) {
				SetLimbsVarsToNBTProcedure.execute(entity);
				if (entity.getPersistentData().getDouble("HeadStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 8) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
						}
						if (entity.getPersistentData().getDouble("HeadStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7lHead")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("HeadStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7lHead")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("HeadStatus", (entity.getPersistentData().getDouble("HeadStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("ChestStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 7) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if (entity.getPersistentData().getDouble("ChestStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Chest")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("ChestStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Chest")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("ChestStatus", (entity.getPersistentData().getDouble("ChestStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("BellyStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 7) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
						}
						if (entity.getPersistentData().getDouble("BellyStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Belly")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("BellyStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Belly")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("BellyStatus", (entity.getPersistentData().getDouble("BellyStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("RightArmStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 5) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
						}
						if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
						} else {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
						}
						if (entity.getPersistentData().getDouble("RightArmStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Right Arm")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("RightArmStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Right Arm")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("RightArmStatus", (entity.getPersistentData().getDouble("RightArmStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("LeftArmStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 5) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
						} else {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
						}
						if (entity.getPersistentData().getDouble("LeftArmStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Left Arm")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("LeftArmStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Left Arm")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("LeftArmStatus", (entity.getPersistentData().getDouble("LeftArmStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("RightLegStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 7) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if (entity.getPersistentData().getDouble("jjcrLegDamageScore") >= 0) {
							entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") - 1));
						} else {
							entity.getPersistentData().putDouble("jjcrLegDamageScore", 0);
						}
						if (entity.getPersistentData().getDouble("RightLegStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Right Leg")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("RightLegStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Right Leg")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("RightLegStatus", (entity.getPersistentData().getDouble("RightLegStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("LeftLegStatus") <= 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 5) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
						}
						if (entity.getPersistentData().getDouble("jjcrLegDamageScore") >= 0) {
							entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") - 1));
						} else {
							entity.getPersistentData().putDouble("jjcrLegDamageScore", 0);
						}
						if (entity.getPersistentData().getDouble("LeftLegStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Left Leg")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("LeftLegStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Left Leg")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("LeftLegStatus", (entity.getPersistentData().getDouble("LeftLegStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("SecondLeftArmStatus") <= 0
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate"))) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 5) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
						} else {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
						}
						if (entity.getPersistentData().getDouble("SecondLeftArmStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Second Left Arm")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("SecondLeftArmStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Second Left Arm")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("SecondLeftArmStatus", (entity.getPersistentData().getDouble("SecondLeftArmStatus") + 1));
					}
				}
				if (entity.getPersistentData().getDouble("SecondRightArmStatus") <= 0
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate"))) {
					rand = Mth.nextInt(RandomSource.create(), 1, 10);
					if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower
							- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) >= 0
							&& (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST)) >= 0
							&& rand >= 5) {
						if (entity.getPersistentData().getBoolean("PRESS_M") == true) {
							{
								double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
										- (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST));
								entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.RCTOutput = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @s run jjc_cursepower -" + (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST)) * Mth.nextDouble(RandomSource.create(), 1, 3) + " @s"));
								}
							}
						}
						if (entity.getPersistentData().getDouble("jjcrArmsDamageScore") >= 0) {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") - 1));
						} else {
							entity.getPersistentData().putDouble("jjcrArmsDamageScore", 0);
						}
						if (entity.getPersistentData().getDouble("SecondRightArmStatus") == 0) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A72recover \u00A7rhis " + "\u00A7l" + "Second Right Arm")), false);
								}
							}
						} else if (entity.getPersistentData().getDouble("SecondRightArmStatus") == -1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " " + "\u00A7l\u00A7arestore \u00A7rhis " + "\u00A7l" + "Second Right Arm")), false);
								}
							}
						}
						entity.getPersistentData().putDouble("SecondRightArmStatus", (entity.getPersistentData().getDouble("SecondRightArmStatus") + 1));
					}
				}
			}
		}
	}
}
