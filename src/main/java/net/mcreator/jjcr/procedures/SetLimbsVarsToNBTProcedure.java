package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SetLimbsVarsToNBTProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity.getPersistentData().getDouble("HeadStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HeadStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("ChestStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ChestStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("BellyStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BellyStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("RightArmStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RightArmStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("LeftArmStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LeftArmStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("RightLegStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RightLegStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("LeftLegStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LeftLegStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("SecondRightArmStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SecondRightArmStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getPersistentData().getDouble("SecondLeftArmStatus");
			entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SecondLeftArmStatus = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
