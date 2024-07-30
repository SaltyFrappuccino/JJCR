package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SukunaBodyChestplateBuffProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate"))) {
			if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
				/*code*/
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 2400, 99, false, false));
			}
			if (entity.getPersistentData().getDouble("cnt5") == 9 && entity.getPersistentData().getDouble("skill") == 105) {
				entity.getPersistentData().putDouble("cnt5", 17);
			}
			if (entity.getPersistentData().getDouble("cnt6") > 2.5 && entity.getPersistentData().getDouble("skill") == 106) {
				entity.getPersistentData().putDouble("cnt6", 5);
			}
			if (entity.getPersistentData().getDouble("cnt6") > 2.5 && entity.getPersistentData().getDouble("skill") == 107) {
				entity.getPersistentData().putDouble("cnt6", 5);
			}
		}
	}
}
