package net.mcreator.jjcr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.jjcr.network.JjcrModVariables;
import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerWithTraitDamageEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM_CE_TRAITS)) {
				if (((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyTrait).equals("") == false
						&& ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyTrait).equals("")) {
					((LivingHurtEvent) event).setAmount(((float) (amount * 1.25)));
				} else if (((sourceentity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).CursedEnergyTrait).equals("") == false && entity instanceof Player == false) {
					((LivingHurtEvent) event).setAmount(((float) (amount * 1.25)));
				}
			}
		}
	}
}
