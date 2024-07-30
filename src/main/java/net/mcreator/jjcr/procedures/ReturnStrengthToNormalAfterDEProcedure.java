package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ReturnStrengthToNormalAfterDEProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_DE_SYSTEM)) {
			if (entity.getPersistentData().getDouble("cnt1") == 0 && entity.getPersistentData().getDouble("skill_domain") == 0 && entity.getPersistentData().getBoolean("jjcrFlagUsingDE") == true
					&& (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				entity.getPersistentData().putBoolean("jjcrFlagUsingDE", false);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DAMAGE_BOOST);
				JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
				JujutsucraftModVariables.MapVariables.get(world).syncData(world);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run advancement revoke @s only jujutsucraft:anti_open_barrier_type_domain");
					}
				}
			}
		}
	}
}
