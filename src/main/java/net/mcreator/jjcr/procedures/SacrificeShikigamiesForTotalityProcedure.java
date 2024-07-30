package net.mcreator.jjcr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.procedures.SummonDivineDogTotalityProcedure;
import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.JjcrMod;

public class SacrificeShikigamiesForTotalityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_divine_dogs"))).isDone()) == true) {
			if (entity instanceof LivingEntity _livEnt0 && (_livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false)) {
				if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 400) {
					entity.getPersistentData().putDouble("TenShadowsTechnique2", (-2));
					entity.getPersistentData().putDouble("skill", 607);
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "jjc_cursepower -400 @s");
						}
					}
					entity.getPersistentData().putBoolean("PRESS_Z", true);
					/*code*/
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 30, 1, false, false));
					/*code*/
					SummonDivineDogTotalityProcedure.execute(world, x, y, z, entity);
					JjcrMod.queueServerWork(20, () -> {
						entity.getPersistentData().putBoolean("PRESS_Z", false);
					});
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 0, Level.ExplosionInteraction.NONE);
				}
			}
		}
	}
}
