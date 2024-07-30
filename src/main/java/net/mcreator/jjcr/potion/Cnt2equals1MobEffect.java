
package net.mcreator.jjcr.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jjcr.procedures.Cnt2equlas1TickProcedure;

public class Cnt2equals1MobEffect extends MobEffect {
	public Cnt2equals1MobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Cnt2equlas1TickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
