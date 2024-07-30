
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.jjcr.potion.TechDEMobEffect;
import net.mcreator.jjcr.potion.HugeDEMobEffect;
import net.mcreator.jjcr.potion.EffectAdvancedTechniqueMobEffect;
import net.mcreator.jjcr.potion.Cnt2equalsminus1MobEffect;
import net.mcreator.jjcr.potion.Cnt2equals2MobEffect;
import net.mcreator.jjcr.potion.Cnt2equals1MobEffect;
import net.mcreator.jjcr.potion.BleedingMobEffect;
import net.mcreator.jjcr.potion.BlackFlashMobEffect;
import net.mcreator.jjcr.JjcrMod;

public class JjcrModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JjcrMod.MODID);
	public static final RegistryObject<MobEffect> CNT_2EQUALSMINUS_1 = REGISTRY.register("cnt_2equalsminus_1", () -> new Cnt2equalsminus1MobEffect());
	public static final RegistryObject<MobEffect> CNT_2EQUALS_1 = REGISTRY.register("cnt_2equals_1", () -> new Cnt2equals1MobEffect());
	public static final RegistryObject<MobEffect> CNT_2EQUALS_2 = REGISTRY.register("cnt_2equals_2", () -> new Cnt2equals2MobEffect());
	public static final RegistryObject<MobEffect> EFFECT_ADVANCED_TECHNIQUE = REGISTRY.register("effect_advanced_technique", () -> new EffectAdvancedTechniqueMobEffect());
	public static final RegistryObject<MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final RegistryObject<MobEffect> TECH_DE = REGISTRY.register("tech_de", () -> new TechDEMobEffect());
	public static final RegistryObject<MobEffect> BLACK_FLASH = REGISTRY.register("black_flash", () -> new BlackFlashMobEffect());
	public static final RegistryObject<MobEffect> HUGE_DE = REGISTRY.register("huge_de", () -> new HugeDEMobEffect());
}
