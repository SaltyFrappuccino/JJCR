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

import net.mcreator.jujutsucraft.procedures.SummonMergedBeastAgitoProcedure;
import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.JjcrMod;

public class SacrificeShikigamiesForAgitoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_round_deer"))).isDone()) == true
				&& (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
						&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_tiger_funeral"))).isDone()) == true
				&& (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
						&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_great_serpent"))).isDone()) == true
				&& (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
						&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_nue"))).isDone()) == true) {
			if (entity instanceof LivingEntity _livEnt0 && (_livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false)) {
				if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCursePower >= 600) {
					if (entity.getPersistentData().getDouble("TenShadowsTechnique11") != -2 || entity.getPersistentData().getDouble("TenShadowsTechnique9") != -2 || entity.getPersistentData().getDouble("TenShadowsTechnique5") != -2) {
						entity.getPersistentData().putDouble("TenShadowsTechnique5", (-2));
						entity.getPersistentData().putDouble("TenShadowsTechnique9", (-2));
						entity.getPersistentData().putDouble("TenShadowsTechnique11", (-2));
						entity.getPersistentData().putDouble("skill", 617);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "jjc_cursepower -600 @s");
							}
						}
						entity.getPersistentData().putBoolean("PRESS_Z", true);
						/*code*/
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 30, 1, false, false));
						/*code*/
						SummonMergedBeastAgitoProcedure.execute(world, x, y, z, entity);
						JjcrMod.queueServerWork(20, () -> {
							entity.getPersistentData().putBoolean("PRESS_Z", false);
						});
					} else if (entity.getPersistentData().getDouble("TenShadowsTechnique11") == 346324636) {
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.NONE);
					}
				}
			}
		}
	}
}
