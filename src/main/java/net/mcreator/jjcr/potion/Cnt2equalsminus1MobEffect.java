
package net.mcreator.jjcr.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jjcr.procedures.Cnt2equalsminus1KazhdyiTikVoVriemiaEffiektaProcedure;

public class Cnt2equalsminus1MobEffect extends MobEffect {
	public Cnt2equalsminus1MobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Cnt2equalsminus1KazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
