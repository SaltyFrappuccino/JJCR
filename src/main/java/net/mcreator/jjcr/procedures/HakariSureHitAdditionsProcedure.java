package net.mcreator.jjcr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.jjcr.init.JjcrModGameRules;
import net.mcreator.jjcr.JjcrMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class HakariSureHitAdditionsProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:dagon_domain_jp")), SoundSource.NEUTRAL, 0, 0);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jjcr:dagon_domain_jp")), SoundSource.NEUTRAL, 0, 0, false);
					}
				}
			}
			world = _worldorig;
		}
		if (world.getLevelData().getGameRules().getBoolean(JjcrModGameRules.JJCR_ADVANCED_TECHNIQUE_HAKARI_SURE_HIT)) {
			if (entity.getPersistentData().getDouble("cnt1") == 1 && entity.getPersistentData().getDouble("skill") == 2920) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(22 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player && (entityiterator == entity) == false) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										"Idle Death Gamble: CR Private Pure Love Train Version 1/239 is based on a real pachinko machine and gets its theme from the eponymously named romance manga series. The user's goal is to hit the jackpot by lining up three of the same symbols decorated with the characters of Private Pure Love Train."),
										false);
							JjcrMod.queueServerWork(10, () -> {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(
											"The jackpot bonus grants the user unlimited cursed energy and a fully automatic reverse cursed technique for four minutes and eleven seconds, the duration of the Private Pure Love Train theme song, \"Admiring You\"."),
											false);
								JjcrMod.queueServerWork(10, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal(
												"The user must participate in the flow of the game in order to hit the aforementioned jackpot, with only a one in two-hundred and thirty-nine chance of doing so. All the rules of the game are transferred into the opponent's brain through the domain's sure-hit effect. This process is harmless, and as a trade-off, the construction and cursed technique infusion of this domain are extremely fast, activating in less than 0.2 seconds. This also makes Idle Death Gamble very effective in a clash of domains."),
												false);
									JjcrMod.queueServerWork(10, () -> {
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(
													"The game begins in normal mode, where those inside appear on a neutral stage. As the battle begins, the user can manifest three different types of visual effect indicators in battle: shutter doors, reserve balls, and consecutive effects. Conjuring doors and balls are offensive attacks, but consecutive effects are defensive indicators that redo a sequence to revert damage. Doors and reserve balls come in a green, red, or gold rarity to symbolize a higher chance at a jackpot. Rainbow-colored indicators or re-doing four consecutive effects guarantees a jackpot. The user can choose which visual indicator to manifest, but their success is up to luck. Generating one or more visual indicators progresses the stage to a riichi scenario and reveals two of three of the numbers needed for a jackpot."),
													false);
										JjcrMod.queueServerWork(10, () -> {
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal(
														"There are four riichi scenarios with different chances of hitting a jackpot, with the final train riichi having over an eighty percent chance. Each of the scenarios changes the stage and uses the characters of Private Pure Love Train in a different way. For example, the transit card riichi scenario takes the user and their opponent to a different part of the train station where Yuki must pass through the gate and get to work on time to hit the jackpot. This is a low-chance scenario and is likely to fail without rare visual indicators. The user's opponent cannot obstruct the visualization of the riichi scenarios and must watch it unfold or defeat the caster before it ends."),
														false);
											JjcrMod.queueServerWork(10, () -> {
												if (entityiterator instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal(
															"Failure to hit a jackpot within a scenario will revert the stage back to the start. This will repeat until the user wins or runs out of chances to do so, with the number of possible spins decreasing with every missed jackpot. On the first activation of consecutive expansions, the probability of hitting the jackpot is over twenty percent."),
															false);
												JjcrMod.queueServerWork(10, () -> {
													if (entityiterator instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(
																"If a jackpot is hit, the domain disappears, and Admiring You plays out loud around the user, who receives a bonus of unlimited cursed energy for the duration of the song. The user has no restrictions on cursed energy and can receive bonus amounts randomly throughout the round. The unlimited cursed energy causes the body to reflexively heal itself even if the user never learned to perform reverse cursed technique. This prevents the user's body from retaining damage and makes them effectively unkillable for four minutes and eleven seconds."),
																false);
													JjcrMod.queueServerWork(10, () -> {
														if (entityiterator instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal(
																	"By the end of the song, the user's cursed energy recedes back to normal and their cursed technique has already been replenished. This allows them to open their domain repeatedly as long as a jackpot is achieved. The conditions of the game carry over from consecutive uses as well. If the user lined up three odd numbers, the stage will open in advanced probability rather than the neutral state. If the user lined up even numbers, they will start on a stage with faster spins. There is also a chance for the stage to begin in hidden probability, a pachinko mode similar to faster spins but actually carries an increased probability to hit the jackpot."),
																	false);
													});
												});
											});
										});
									});
								});
							});
						}
					}
				}
			}
		}
	}
}
