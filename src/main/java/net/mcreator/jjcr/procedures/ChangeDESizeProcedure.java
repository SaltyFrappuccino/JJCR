package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ChangeDESizeProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:dagon_domain_jp")), SoundSource.NEUTRAL, 0, 0);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:dagon_domain_jp")), SoundSource.NEUTRAL, 0, 0, false);
					}
				}
			}
			world = _worldorig;
		}
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_DE_SYSTEM)) {
			if (entity.getPersistentData().getDouble("skill") % 100 == 20 && (entity.getPersistentData().getDouble("cnt3") >= 19 || entity.getPersistentData().getDouble("cnt1") >= 1)) {
				if (entity.getPersistentData().getDouble("jjcrDomainType") == 1) {
					if (entity.getPersistentData().getDouble("cnt1") == 25 && entity.getPersistentData().getDouble("cnt3") == 20) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 3), false, false));
					} /*code*/
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 30;
					JjcrModVariables.MapVariables.get(world).syncData(world);
				} else if (entity.getPersistentData().getDouble("jjcrDomainType") == 0) {
					if (entity.getPersistentData().getDouble("cnt1") == 25 && entity.getPersistentData().getDouble("cnt3") == 20) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 5), false, false));
					} /*code*/
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
					JjcrModVariables.MapVariables.get(world).syncData(world);
				} else if (entity.getPersistentData().getDouble("jjcrDomainType") == -1) {
					if (entity.getPersistentData().getDouble("cnt1") == 25 && entity.getPersistentData().getDouble("cnt3") == 20) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 7), false, false));
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement grant @s only jujutsucraft:anti_open_barrier_type_domain");
						}
					} /*code*/
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
					JjcrModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
