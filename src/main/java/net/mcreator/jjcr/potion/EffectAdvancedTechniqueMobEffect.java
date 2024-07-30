
package net.mcreator.jjcr.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class EffectAdvancedTechniqueMobEffect extends MobEffect {
	public EffectAdvancedTechniqueMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -256);
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
