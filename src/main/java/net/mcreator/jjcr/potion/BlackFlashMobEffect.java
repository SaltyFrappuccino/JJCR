
package net.mcreator.jjcr.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jjcr.procedures.BlackFlashEndedProcedure;

public class BlackFlashMobEffect extends MobEffect {
	public BlackFlashMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13421773);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BlackFlashEndedProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
