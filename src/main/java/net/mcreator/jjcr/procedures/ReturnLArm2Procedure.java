package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnLArm2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate"))) {
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SecondLeftArmStatus == 1) {
				return "\u00A7l" + "\u00A72" + "L Arm 2";
			} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SecondLeftArmStatus == 0) {
				return "\u00A7l" + "\u00A76" + "L Arm 2";
			} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SecondLeftArmStatus == -1) {
				return "\u00A7l" + "\u00A74" + "L Arm 2";
			}
		}
		return "";
	}
}
