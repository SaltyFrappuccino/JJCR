package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ChangeCostAndLabelProcedure {
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
		if (entity.getPersistentData().getDouble("jjcrCustomCT") == 1) {
			if (entity.getPersistentData().getDouble("jjcrCustomSkill") == 1) {/*code*/
				{
					double _setval = 1200;
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueCost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				/*code*/
				{
					double _setval = 15;
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechnique = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				/*code*/
				{
					Boolean _setval = false;
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PhysicalAttack = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				/*code*/
				{
					String _setval = "Custom CT: Gravity";
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (entity.getPersistentData().getDouble("jjcrCustomSkill") == 2) {/*code*/
				{
					Boolean _setval = false;
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PhysicalAttack = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				/*code*/
				{
					double _setval = 15;
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechnique = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				/*code*/
				{
					double _setval = 4000000;
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueCost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				/*code*/
				{
					String _setval = "Custom CT: God's Hand";
					entity.getCapability(net.mcreator.jujutsucraft.network.JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
