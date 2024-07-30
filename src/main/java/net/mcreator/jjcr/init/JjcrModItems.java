
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.jjcr.item.IconJJCRItem;
import net.mcreator.jjcr.item.CELevel5iItem;
import net.mcreator.jjcr.item.CELevel4iItem;
import net.mcreator.jjcr.item.CELevel3iItem;
import net.mcreator.jjcr.item.CELevel2iItem;
import net.mcreator.jjcr.item.CELevel1iItem;
import net.mcreator.jjcr.JjcrMod;

public class JjcrModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JjcrMod.MODID);
	public static final RegistryObject<Item> ICON_JJCR = REGISTRY.register("icon_jjcr", () -> new IconJJCRItem());
	public static final RegistryObject<Item> CE_LEVEL_1I = REGISTRY.register("ce_level_1i", () -> new CELevel1iItem());
	public static final RegistryObject<Item> CE_LEVEL_2I = REGISTRY.register("ce_level_2i", () -> new CELevel2iItem());
	public static final RegistryObject<Item> CE_LEVEL_3I = REGISTRY.register("ce_level_3i", () -> new CELevel3iItem());
	public static final RegistryObject<Item> CE_LEVEL_4I = REGISTRY.register("ce_level_4i", () -> new CELevel4iItem());
	public static final RegistryObject<Item> CE_LEVEL_5I = REGISTRY.register("ce_level_5i", () -> new CELevel5iItem());
	public static final RegistryObject<Item> TECH_SPAWN_EGG = REGISTRY.register("tech_spawn_egg", () -> new ForgeSpawnEggItem(JjcrModEntities.TECH, -1, -16777216, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
