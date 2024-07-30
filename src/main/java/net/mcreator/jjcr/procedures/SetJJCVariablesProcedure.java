package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SetJJCVariablesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueCost = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechnique = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerLevel;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerCursePower;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCursePower = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCurseTechnique = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerExperience;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerExperience = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			boolean _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PhysicalAttack;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PhysicalAttack = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerTechniqueUsedNumber = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCurseTechnique2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerProfession;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerProfession = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
				{
			double _setval = (entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX;
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCursePowerMAX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
