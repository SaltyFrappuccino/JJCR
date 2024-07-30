package net.mcreator.jjcr.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.JjcrMod;

public class FastDomainExpansionPriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.UNSTABLE.get())) == false
				&& (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false && entity instanceof ServerPlayer _plr0
				&& _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).isDone()) {
			entity.getPersistentData().putBoolean("PRESS_Z", true);
			entity.getPersistentData().putDouble("skill", new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(Math.round((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).PlayerCurseTechnique) + "" + 20));
			{
				double _setval = 20;
				entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerSelectCurseTechnique = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			/*code*/
			{
				double _setval = 20;
				entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerSelectCurseTechnique = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
			JjcrMod.queueServerWork(70, () -> {
				entity.getPersistentData().putBoolean("PRESS_Z", false);
			});
			if (false) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "clear");
			}
		}
	}
}
