package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RCTOutputIncreaseWithTimeProcedure {
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
		assert Boolean.TRUE; //#dbg:RCTOutputIncreaseWithTime:RCTOutputIncreaseWithTime
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_RCT_SYSTEM)) {
			if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) == false) {
				if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput < (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new JjcrModVariables.PlayerVariables())).RCTOutputMAX) {
					if (entity.getPersistentData().getDouble("RCTOutputIncreaseCounter") >= 10) {
						entity.getPersistentData().putDouble("RCTOutputIncreaseCounter", 0);
						{
							double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput
									+ (world.getLevelData().getGameRules().getInt(JjcrModGameRules.JJCR_RCT_SYSTEM_RCT_OUTPUT_INCREASE_VALUE));
							entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTOutput = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity.getPersistentData().getDouble("RCTOutputIncreaseCounter") < 10) {
						entity.getPersistentData().putDouble("RCTOutputIncreaseCounter", (entity.getPersistentData().getDouble("RCTOutputIncreaseCounter") + 1));
					}
				} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput >= (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new JjcrModVariables.PlayerVariables())).RCTOutputMAX) {
					{
						double _setval = (entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutputMAX;
						entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RCTOutput = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).RCTOutput < 0) {
					{
						double _setval = 0;
						entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RCTOutput = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
