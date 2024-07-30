
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.jjcr.world.inventory.RPGInterfaceMenu;
import net.mcreator.jjcr.JjcrMod;

public class JjcrModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, JjcrMod.MODID);
	public static final RegistryObject<MenuType<RPGInterfaceMenu>> RPG_INTERFACE = REGISTRY.register("rpg_interface", () -> IForgeMenuType.create(RPGInterfaceMenu::new));
}
