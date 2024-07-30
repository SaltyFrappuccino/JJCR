
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JjcrModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_SHOW_DAMAGE = GameRules.register("jjcrShowDamage", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_LIMB_SYSTEM = GameRules.register("jjcrLimbSystem", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_LIMB_SYSTEM_DAMAGE_CHANCE = GameRules.register("jjcrLimbSystemDamageChance", GameRules.Category.MISC, GameRules.IntegerValue.create(60));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_MAX_MODIFIER = GameRules.register("jjcrRCTSystemRCTOutputMAXModifier", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_LEVEL_MODIFIER = GameRules.register("jjcrRCTSystemRCTLevelModifier", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_RCT_SYSTEM = GameRules.register("jjcrRCTSystem", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_INCREASE_VALUE = GameRules.register("jjcrRCTSystemRCTOutputIncreaseValue", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_DECREASE_VALUE = GameRules.register("jjcrRCTSystemRCTOutputDecreaseValue", GameRules.Category.MISC, GameRules.IntegerValue.create(8));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_DECREASE_TIREDNESS = GameRules.register("jjcrRCTSystemRCTOutputDecreaseTiredness", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_TIREDNESS_VALUE = GameRules.register("jjcrRCTSystemRCTTirednessValue", GameRules.Category.PLAYER, GameRules.IntegerValue.create(5));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_DE_SYSTEM_DE_LEVEL_MODIFIER = GameRules.register("jjcrDESystemDELevelModifier", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_LIMB_SYSTEM_LIMB_AFFECTS_PLAYER = GameRules.register("jjcrLimbSystemLimbAffectsPlayer", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_TO_ENTITY_CE_COST = GameRules.register("jjcrRCTSystemRCTOutputToEntityCECost", GameRules.Category.PLAYER, GameRules.IntegerValue.create(500));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_TO_ENTITY_RCT_COST = GameRules.register("jjcrRCTSystemRCTOutputToEntityRCTCost", GameRules.Category.PLAYER, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_TO_WEAPON_CE_COST = GameRules.register("jjcrRCTSystemRCTOutputToWeaponCECost", GameRules.Category.PLAYER, GameRules.IntegerValue.create(250));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_RCT_OUTPUT_TO_WEAPON_RCT_COST = GameRules.register("jjcrRCTSystemRCTOutputToWeaponRCTCost", GameRules.Category.PLAYER, GameRules.IntegerValue.create(50));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_RCT_SYSTEM_ENABLE_TECHNIQUE_BURNOUT_HEALING = GameRules.register("jjcrRCTSystemEnableTechniqueBurnoutHealing", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJRC_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_CE_COST = GameRules.register("jjrcRCTSystemTechniqueBurnoutHealingCECost", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_TECHNIQUE_BURNOUT_HEALING_RCT_COST = GameRules.register("jjcrRCTSystemTechniqueBurnoutHealingRCTCost", GameRules.Category.MISC, GameRules.IntegerValue.create(500));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_POISON_HEALING_RCT_COST = GameRules.register("jjcrRCTSystemPoisonHealingRCTCost", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_LIMB_SYSTEM_BLEEDING = GameRules.register("jjcrLimbSystemBleeding", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_LIMB_SYSTEM_BLEEDING_CHANCE = GameRules.register("jjcrLimbSystemBleedingChance", GameRules.Category.MISC, GameRules.IntegerValue.create(50));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_HEALS_LIMB_CE_COST = GameRules.register("jjcrRCTSystemHealsLimbCECost", GameRules.Category.PLAYER, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_RCT_SYSTEM_HEALS_LIMB_RCT_COST = GameRules.register("jjcrRCTSystemHealsLimbRCTCost", GameRules.Category.PLAYER, GameRules.IntegerValue.create(50));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CE_SYSTEM_ALWAYS_SHOW_CE_PARTICLES = GameRules.register("jjcrCESystemAlwaysShowCEParticles", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CE_SYSTEM_CE_PARTICLES_VALUE = GameRules.register("jjcrCESystemCEParticlesValue", GameRules.Category.MISC, GameRules.IntegerValue.create(10));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CE_SYSTEM = GameRules.register("jjcrCESystem", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CE_SYSTEM_CE_LEVEL_MODIFIER = GameRules.register("jjcrCESystemCELevelModifier", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CE_SYSTEM_CE_TRAITS = GameRules.register("jjcrCESystemCETraits", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CE_SYSTEM_BODY_STRENGTHENING = GameRules.register("jjcrCESystemBodyStrengthening", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CE_SYSTEM_CE_BODY_STRENGTHENING_COST = GameRules.register("jjcrCESystemCEBodyStrengtheningCost", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CE_SYSTEM_STRIKES_STRENGTHENING = GameRules.register("jjcrCESystemStrikesStrengthening", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CE_SYSTEM_STRIKES_STRENGTHENING_COST = GameRules.register("jjcrCESystemStrikesStrengtheningCost", GameRules.Category.MISC, GameRules.IntegerValue.create(150));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CE_SYSTEM_INCREASE_OUTPUT = GameRules.register("jjcrCESystemIncreaseOutput", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CE_SYSTEM_INCREASE_OUTPUT_COST = GameRules.register("jjcrCESystemIncreaseOutputCost", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_DE_SYSTEM = GameRules.register("jjcrDESystem", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_COSMETIC = GameRules.register("jjcrCosmetic", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_COSMETIC_SHOW_DE_TITLES = GameRules.register("jjcrCosmeticShowDETitles", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_COSMETIC_DE_VOICE_OVER = GameRules.register("jjcrCosmeticDEVoiceOver", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_CT_SYSTEM_CT_TARGET_EXTENSION = GameRules.register("jjcrCTSystemCTTargetExtension", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CT_SYSTEM_CT_TARGET_EXTENSION_COST = GameRules.register("jjcrCTSystemCTTargetExtensionCost", GameRules.Category.MISC, GameRules.IntegerValue.create(2000));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_GOJO_DISABLE_HOLLOW_PURPLE_IN_DE = GameRules.register("jjcrGojoDisableHollowPurpleInDE", GameRules.Category.MISC, GameRules.IntegerValue.create(2));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_BLACK_FLASH = GameRules.register("jjcrBlackFlash", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_BLACK_FLASH_CHANCE = GameRules.register("jjcrBlackFlashChance", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_BLACK_FLASH_RESTORE_CE = GameRules.register("jjcrBlackFlashRestoreCE", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_BLACK_FLASH_RESTORE_RCT_OUTPUT = GameRules.register("jjcrBlackFlashRestoreRCTOutput", GameRules.Category.MISC, GameRules.IntegerValue.create(500));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE = GameRules.register("jjcrAdvancedTechnique", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_MEGUMI = GameRules.register("jjcrAdvancedTechniqueMegumi", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_MEGUMI_SUMMON_AGITO = GameRules.register("jjcrAdvancedTechniqueMegumiSummonAgito", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_AIR_COMBAT = GameRules.register("jjcrAirCombat", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_BREAK_CONCENTRATION = GameRules.register("jjcrBreakConcentration", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_CE_SYSTEM_INCREASE_OUTPUT_MAX = GameRules.register("jjcrCESystemIncreaseOutputMAX", GameRules.Category.MISC, GameRules.IntegerValue.create(10));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_COSMETIC_SKILLS_VOICE_OVER = GameRules.register("jjcrCosmeticSkillsVoiceOver", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_COSMETIC_SKILLS_TITLES = GameRules.register("jjcrCosmeticSkillsTitles", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_OTHER_GOJO_FLIGHT = GameRules.register("jjcrOtherGojoFlight", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_OTHER_ULTRA_RAPID_FIRE = GameRules.register("jjcrOtherUltraRapidFire", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_OTHER_WATER_WALKING = GameRules.register("jjcrOtherWaterWalking", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_MEGUMI_SUMMONS_TOTALITY = GameRules.register("jjcrAdvancedTechniqueMegumiSummonsTotality", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_MEGUMI_BUFF_SHIKIGAMIES = GameRules.register("jjcrAdvancedTechniqueMegumiBuffShikigamies", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_ADVANCED_TECHNIQUE_MEGUMI_BUFF_SHIKIGAMIES_COST = GameRules.register("jjcrAdvancedTechniqueMegumiBuffShikigamiesCost", GameRules.Category.MISC, GameRules.IntegerValue.create(500));
	public static final GameRules.Key<GameRules.IntegerValue> JJCR_ADVANCED_TECHNIQUE_SUKUNA_INFINITY_DISMANTLE_BARRAGE_COST = GameRules.register("jjcrAdvancedTechniqueSukunaInfinityDismantleBarrageCost", GameRules.Category.MISC,
			GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_SUKUNA_INFINITY_DISMANTLE_BARRAGE = GameRules.register("jjcrAdvancedTechniqueSukunaInfinityDismantleBarrage", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_SUKUNA_OVERRIDE_FUUGA = GameRules.register("jjcrAdvancedTechniqueSukunaOverrideFuuga", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJCR_ADVANCED_TECHNIQUE_HAKARI_SURE_HIT = GameRules.register("jjcrAdvancedTechniqueHakariSureHit", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
