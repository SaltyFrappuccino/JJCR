
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.jjcr.JjcrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JjcrModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JjcrMod.MODID);
	public static final RegistryObject<CreativeModeTab> CREATIVE_TAB_JJCR = REGISTRY.register("creative_tab_jjcr",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jjcr.creative_tab_jjcr")).icon(() -> new ItemStack(JjcrModItems.ICON_JJCR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JjcrModItems.ICON_JJCR.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(JjcrModItems.TECH_SPAWN_EGG.get());
		}
	}
}
