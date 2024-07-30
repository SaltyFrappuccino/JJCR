package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;

public class TechSummonedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:gavel"))).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:uniform_higuruma_chestplate"))));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:uniform_higuruma_chestplate"))));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:uniform_higuruma_leggings"))));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:uniform_higuruma_leggings"))));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:uniform_gojo_boots"))));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:uniform_gojo_boots"))));
			}
		}
		entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
		entity.getPersistentData().putBoolean("jjkChara", true);
		entity.getPersistentData().putBoolean("UseCursedTechnique", true);
		entity.getPersistentData().putDouble("cnt_reverse_lim", 0);
		entity.getPersistentData().putDouble("cnt_simpleDomain", 1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, 23, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 3, false, false));
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("tagName", 0);
	}
}
