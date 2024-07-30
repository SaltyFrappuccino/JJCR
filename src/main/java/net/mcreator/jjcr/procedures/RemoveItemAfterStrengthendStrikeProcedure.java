package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjcr.init.JjcrModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RemoveItemAfterStrengthendStrikeProcedure {
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
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM)) {
			if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_CE_SYSTEM_STRIKES_STRENGTHENING)) {
				if (entity.getPersistentData().getDouble("skill") % 100 <= 2 && entity.getPersistentData().getDouble("cnt1") > 7
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CursePower") > 0
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:cursed_technique_starter"))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:cursed_technique_starter"))) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:cursed_technique_starter"))) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			}
		}
	}
}
