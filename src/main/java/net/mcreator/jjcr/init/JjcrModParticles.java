
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.jjcr.client.particle.PoisonParticle;
import net.mcreator.jjcr.client.particle.LightningParticle;
import net.mcreator.jjcr.client.particle.IceParticle;
import net.mcreator.jjcr.client.particle.CursedEnergyRedParticle;
import net.mcreator.jjcr.client.particle.CursedEnergyOrangeParticle;
import net.mcreator.jjcr.client.particle.CursedEnergyGreenParticle;
import net.mcreator.jjcr.client.particle.CursedEnergyBlueParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JjcrModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(JjcrModParticleTypes.CURSED_ENERGY_BLUE.get(), CursedEnergyBlueParticle::provider);
		event.registerSpriteSet(JjcrModParticleTypes.CURSED_ENERGY_RED.get(), CursedEnergyRedParticle::provider);
		event.registerSpriteSet(JjcrModParticleTypes.CURSED_ENERGY_GREEN.get(), CursedEnergyGreenParticle::provider);
		event.registerSpriteSet(JjcrModParticleTypes.CURSED_ENERGY_ORANGE.get(), CursedEnergyOrangeParticle::provider);
		event.registerSpriteSet(JjcrModParticleTypes.LIGHTNING.get(), LightningParticle::provider);
		event.registerSpriteSet(JjcrModParticleTypes.ICE.get(), IceParticle::provider);
		event.registerSpriteSet(JjcrModParticleTypes.POISON.get(), PoisonParticle::provider);
	}
}
