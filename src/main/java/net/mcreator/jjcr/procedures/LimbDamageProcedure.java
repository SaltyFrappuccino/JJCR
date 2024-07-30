package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class LimbDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double rand = 0;
		double limbRand = 0;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_LIMB_SYSTEM)) {
			if (amount >= (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) - Mth.nextInt(RandomSource.create(), 0, 5)) {
				rand = Mth.nextInt(RandomSource.create(), 1, (int) sourceentity.getPersistentData().getDouble("jjcrLimbDamageChance"));
				if (rand == 1) {
					if (entity.getPersistentData().getDouble("HeadStatus") == 1) {
						entity.getPersistentData().putDouble("HeadStatus", 0);
						{
							double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput - 100;
							entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTOutput = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Head")), false);
							}
						}
					} else if (entity.getPersistentData().getDouble("HeadStatus") == 0) {
						entity.getPersistentData().putDouble("HeadStatus", (-1));
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth(0);
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 999999);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s minecraft:insta_damage 30 255");
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Head")), false);
							}
						}
					}
				} else if (rand == 2 || rand == 3) {
					if (entity.getPersistentData().getDouble("ChestStatus") == 1) {
						entity.getPersistentData().putDouble("ChestStatus", 0);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:cooldown_time_combat 5 1 true");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:cooldown_time 5 1 true");
							}
						}
						((LivingHurtEvent) event).setAmount(((float) (amount * 1.25)));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Chest")), false);
							}
						}
					} else if (entity.getPersistentData().getDouble("ChestStatus") == 0) {
						entity.getPersistentData().putDouble("ChestStatus", (-1));
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:cooldown_time_combat 15 1 true");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:cooldown_time 15 1 true");
							}
						}
						((LivingHurtEvent) event).setAmount(((float) (amount * 1.5)));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Chest")), false);
							}
						}
					}
				} else if (rand == 4 || rand == 5) {
					if (entity.getPersistentData().getDouble("BellyStatus") == 1) {
						entity.getPersistentData().putDouble("BellyStatus", 0);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower -500 @s");
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Belly")), false);
							}
						}
					} else if (entity.getPersistentData().getDouble("BellyStatus") == 0) {
						entity.getPersistentData().putDouble("BellyStatus", (-1));
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower -1500 @s");
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Belly")), false);
							}
						}
					}
				} else if (rand >= 6 && rand <= 8) {
					if (entity.getPersistentData().getDouble("RightArmStatus") == 1) {
						entity.getPersistentData().putDouble("RightArmStatus", 0);
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Right Arm")), false);
							}
						}
					} else if (entity.getPersistentData().getDouble("RightArmStatus") == 0) {
						entity.getPersistentData().putDouble("RightArmStatus", (-1));
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Right Arm")),
											false);
							}
						}
					}
				} else if (rand >= 9 && rand <= 11) {
					if (entity.getPersistentData().getDouble("LeftArmStatus") == 1) {
						entity.getPersistentData().putDouble("LeftArmStatus", 0);
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Left Arm")), false);
							}
						}
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
					} else if (entity.getPersistentData().getDouble("LeftArmStatus") == 0) {
						entity.getPersistentData().putDouble("LeftArmStatus", (-1));
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Left Arm")),
											false);
							}
						}
					}
				} else if (rand >= 12 && rand <= 14) {
					if (entity.getPersistentData().getDouble("LeftLegStatus") == 1) {
						entity.getPersistentData().putDouble("LeftLegStatus", 0);
						entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Left Leg")), false);
							}
						}
					} else if (entity.getPersistentData().getDouble("LeftLegStatus") == 0) {
						entity.getPersistentData().putDouble("LeftLegStatus", (-1));
						entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Left Leg")),
											false);
							}
						}
					}
				} else if (rand >= 15 && rand <= 17) {
					if (entity.getPersistentData().getDouble("RightLegStatus") == 1) {
						entity.getPersistentData().putDouble("RightLegStatus", 0);
						entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Right Leg")), false);
							}
						}
					} else if (entity.getPersistentData().getDouble("RightLegStatus") == 0) {
						entity.getPersistentData().putDouble("RightLegStatus", (-1));
						entity.getPersistentData().putDouble("jjcrLegDamageScore", (entity.getPersistentData().getDouble("jjcrLegDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Right Leg")),
											false);
							}
						}
					}
				} else if (rand >= 18 && rand <= 20
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate"))) {
					if (entity.getPersistentData().getDouble("SecondRightArmStatus") == 1) {
						entity.getPersistentData().putDouble("SecondRightArmStatus", 0);
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Second Right Arm")),
											false);
							}
						}
					} else if (entity.getPersistentData().getDouble("SecondRightArmStatus") == 0) {
						entity.getPersistentData().putDouble("SecondRightArmStatus", (-1));
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Second Right Arm")), false);
							}
						}
					}
				} else if (rand >= 21 && rand <= 23
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate"))) {
					if (entity.getPersistentData().getDouble("SecondLeftArmStatus") == 1) {
						entity.getPersistentData().putDouble("SecondLeftArmStatus", 0);
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A74" + "damaged \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Second Left Arm")),
											false);
							}
						}
					} else if (entity.getPersistentData().getDouble("SecondLeftArmStatus") == 0) {
						entity.getPersistentData().putDouble("SecondLeftArmStatus", (-1));
						entity.getPersistentData().putDouble("jjcrArmsDamageScore", (entity.getPersistentData().getDouble("jjcrArmsDamageScore") + 1));
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((sourceentity.getDisplayName().getString() + " \u00A7l\u00A77" + "destroyed \u00A7r\u00A7l" + entity.getDisplayName().getString() + "'s \u00A7l" + "Second Left Arm")),
											false);
							}
						}
					}
				}
				JjcrMod.queueServerWork(1, () -> {
					entity.getPersistentData().putDouble("tagName", 0);
				});
			}
		}
	}
}
