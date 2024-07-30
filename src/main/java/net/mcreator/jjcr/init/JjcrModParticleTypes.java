
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.jjcr.JjcrMod;

public class JjcrModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, JjcrMod.MODID);
	public static final RegistryObject<SimpleParticleType> CURSED_ENERGY_BLUE = REGISTRY.register("cursed_energy_blue", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CURSED_ENERGY_RED = REGISTRY.register("cursed_energy_red", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CURSED_ENERGY_GREEN = REGISTRY.register("cursed_energy_green", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> CURSED_ENERGY_ORANGE = REGISTRY.register("cursed_energy_orange", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> LIGHTNING = REGISTRY.register("lightning", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ICE = REGISTRY.register("ice", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> POISON = REGISTRY.register("poison", () -> new SimpleParticleType(false));
}
