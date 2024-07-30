
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjcr.JjcrMod;

public class JjcrModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JjcrMod.MODID);
	public static final RegistryObject<SoundEvent> DAGON_DOMAIN_JP = REGISTRY.register("dagon_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "dagon_domain_jp")));
	public static final RegistryObject<SoundEvent> HAKARI_DOMAIN_JP = REGISTRY.register("hakari_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "hakari_domain_jp")));
	public static final RegistryObject<SoundEvent> HANAMI_DOMAIN_JP = REGISTRY.register("hanami_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "hanami_domain_jp")));
	public static final RegistryObject<SoundEvent> JOGO_DOMAIN_JP = REGISTRY.register("jogo_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "jogo_domain_jp")));
	public static final RegistryObject<SoundEvent> MAHITO_DOMAIN_JP = REGISTRY.register("mahito_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "mahito_domain_jp")));
	public static final RegistryObject<SoundEvent> MEGUMI_DOMAIN_JP = REGISTRY.register("megumi_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "megumi_domain_jp")));
	public static final RegistryObject<SoundEvent> OKKOTSU_DOMAIN_JP = REGISTRY.register("okkotsu_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "okkotsu_domain_jp")));
	public static final RegistryObject<SoundEvent> SATORU_DOMAIN_JP = REGISTRY.register("satoru_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "satoru_domain_jp")));
	public static final RegistryObject<SoundEvent> SUKUNA_DOMAIN_JP = REGISTRY.register("sukuna_domain_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "sukuna_domain_jp")));
	public static final RegistryObject<SoundEvent> KOKUSEN_JP = REGISTRY.register("kokusen_jp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "kokusen_jp")));
	public static final RegistryObject<SoundEvent> FUGA_ENG = REGISTRY.register("fuga_eng", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjcr", "fuga_eng")));
}
