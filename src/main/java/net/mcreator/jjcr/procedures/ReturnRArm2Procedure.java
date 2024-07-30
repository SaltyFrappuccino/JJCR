package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjcr.network.JjcrModVariables;

public class ReturnRArm2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_body_chestplate")) == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()) {
			if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SecondRightArmStatus == 1) {
				return "\u00A7l" + "\u00A72" + "R Arm 2";
			} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SecondRightArmStatus == 0) {
				return "\u00A7l" + "\u00A76" + "R Arm 2";
			} else if ((entity.getCapability(JjcrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JjcrModVariables.PlayerVariables())).SecondRightArmStatus == -1) {
				return "\u00A7l" + "\u00A74" + "R Arm 2";
			}
		}
		return "";
	}
}
