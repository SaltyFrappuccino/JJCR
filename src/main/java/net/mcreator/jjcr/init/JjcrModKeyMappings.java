
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjcr.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.jjcr.network.ToggleAutoRCTKeyMessage;
import net.mcreator.jjcr.network.TechniqueBurnoutHealingMessage;
import net.mcreator.jjcr.network.StrikesStrengtheningMessage;
import net.mcreator.jjcr.network.SkillHotkey3Message;
import net.mcreator.jjcr.network.SkillHotkey2Message;
import net.mcreator.jjcr.network.SkillHotkey1Message;
import net.mcreator.jjcr.network.SaveFastSkillMessage;
import net.mcreator.jjcr.network.PassiveTechniqueMessage;
import net.mcreator.jjcr.network.OpenRPGInterfaceMessage;
import net.mcreator.jjcr.network.JJCRDebugVariablesMessage;
import net.mcreator.jjcr.network.JJCRDebugNBTMessage;
import net.mcreator.jjcr.network.IncreaseOutputMessage;
import net.mcreator.jjcr.network.FastDomainExpansionMessage;
import net.mcreator.jjcr.network.EnableFastSkillsHotkeysMessage;
import net.mcreator.jjcr.network.ChangeDETypeMessage;
import net.mcreator.jjcr.network.ChangeCTFromJJCRMessage;
import net.mcreator.jjcr.network.AdvancedTechniqueKeyMessage;
import net.mcreator.jjcr.JjcrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JjcrModKeyMappings {
	public static final KeyMapping JJCR_DEBUG_VARIABLES = new KeyMapping("key.jjcr.jjcr_debug_variables", GLFW.GLFW_KEY_K, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new JJCRDebugVariablesMessage(0, 0));
				JJCRDebugVariablesMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping JJCR_DEBUG_NBT = new KeyMapping("key.jjcr.jjcr_debug_nbt", GLFW.GLFW_KEY_L, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new JJCRDebugNBTMessage(0, 0));
				JJCRDebugNBTMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_RPG_INTERFACE = new KeyMapping("key.jjcr.open_rpg_interface", GLFW.GLFW_KEY_J, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new OpenRPGInterfaceMessage(0, 0));
				OpenRPGInterfaceMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHANGE_DE_TYPE = new KeyMapping("key.jjcr.change_de_type", GLFW.GLFW_KEY_N, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new ChangeDETypeMessage(0, 0));
				ChangeDETypeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ADVANCED_TECHNIQUE_KEY = new KeyMapping("key.jjcr.advanced_technique_key", GLFW.GLFW_KEY_C, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new AdvancedTechniqueKeyMessage(0, 0));
				AdvancedTechniqueKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ADVANCED_TECHNIQUE_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ADVANCED_TECHNIQUE_KEY_LASTPRESS);
				JjcrMod.PACKET_HANDLER.sendToServer(new AdvancedTechniqueKeyMessage(1, dt));
				AdvancedTechniqueKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TOGGLE_AUTO_RCT_KEY = new KeyMapping("key.jjcr.toggle_auto_rct_key", GLFW.GLFW_KEY_H, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new ToggleAutoRCTKeyMessage(0, 0));
				ToggleAutoRCTKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TECHNIQUE_BURNOUT_HEALING = new KeyMapping("key.jjcr.technique_burnout_healing", GLFW.GLFW_KEY_C, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new TechniqueBurnoutHealingMessage(0, 0));
				TechniqueBurnoutHealingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TECHNIQUE_BURNOUT_HEALING_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TECHNIQUE_BURNOUT_HEALING_LASTPRESS);
				JjcrMod.PACKET_HANDLER.sendToServer(new TechniqueBurnoutHealingMessage(1, dt));
				TechniqueBurnoutHealingMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ENABLE_FAST_SKILLS_HOTKEYS = new KeyMapping("key.jjcr.enable_fast_skills_hotkeys", GLFW.GLFW_KEY_U, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new EnableFastSkillsHotkeysMessage(0, 0));
				EnableFastSkillsHotkeysMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SAVE_FAST_SKILL = new KeyMapping("key.jjcr.save_fast_skill", GLFW.GLFW_KEY_Y, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new SaveFastSkillMessage(0, 0));
				SaveFastSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				SAVE_FAST_SKILL_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SAVE_FAST_SKILL_LASTPRESS);
				JjcrMod.PACKET_HANDLER.sendToServer(new SaveFastSkillMessage(1, dt));
				SaveFastSkillMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SKILL_HOTKEY_1 = new KeyMapping("key.jjcr.skill_hotkey_1", GLFW.GLFW_KEY_1, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new SkillHotkey1Message(0, 0));
				SkillHotkey1Message.pressAction(Minecraft.getInstance().player, 0, 0);
				SKILL_HOTKEY_1_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SKILL_HOTKEY_1_LASTPRESS);
				JjcrMod.PACKET_HANDLER.sendToServer(new SkillHotkey1Message(1, dt));
				SkillHotkey1Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SKILL_HOTKEY_2 = new KeyMapping("key.jjcr.skill_hotkey_2", GLFW.GLFW_KEY_2, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new SkillHotkey2Message(0, 0));
				SkillHotkey2Message.pressAction(Minecraft.getInstance().player, 0, 0);
				SKILL_HOTKEY_2_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SKILL_HOTKEY_2_LASTPRESS);
				JjcrMod.PACKET_HANDLER.sendToServer(new SkillHotkey2Message(1, dt));
				SkillHotkey2Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SKILL_HOTKEY_3 = new KeyMapping("key.jjcr.skill_hotkey_3", GLFW.GLFW_KEY_3, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new SkillHotkey3Message(0, 0));
				SkillHotkey3Message.pressAction(Minecraft.getInstance().player, 0, 0);
				SKILL_HOTKEY_3_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SKILL_HOTKEY_3_LASTPRESS);
				JjcrMod.PACKET_HANDLER.sendToServer(new SkillHotkey3Message(1, dt));
				SkillHotkey3Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FAST_DOMAIN_EXPANSION = new KeyMapping("key.jjcr.fast_domain_expansion", GLFW.GLFW_KEY_V, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new FastDomainExpansionMessage(0, 0));
				FastDomainExpansionMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PASSIVE_TECHNIQUE = new KeyMapping("key.jjcr.passive_technique", GLFW.GLFW_KEY_F, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new PassiveTechniqueMessage(0, 0));
				PassiveTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHANGE_CT_FROM_JJCR = new KeyMapping("key.jjcr.change_ct_from_jjcr", GLFW.GLFW_KEY_R, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new ChangeCTFromJJCRMessage(0, 0));
				ChangeCTFromJJCRMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping STRIKES_STRENGTHENING = new KeyMapping("key.jjcr.strikes_strengthening", GLFW.GLFW_KEY_X, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new StrikesStrengtheningMessage(0, 0));
				StrikesStrengtheningMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping INCREASE_OUTPUT = new KeyMapping("key.jjcr.increase_output", GLFW.GLFW_KEY_Y, "key.categories.jjcr") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JjcrMod.PACKET_HANDLER.sendToServer(new IncreaseOutputMessage(0, 0));
				IncreaseOutputMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long ADVANCED_TECHNIQUE_KEY_LASTPRESS = 0;
	private static long TECHNIQUE_BURNOUT_HEALING_LASTPRESS = 0;
	private static long SAVE_FAST_SKILL_LASTPRESS = 0;
	private static long SKILL_HOTKEY_1_LASTPRESS = 0;
	private static long SKILL_HOTKEY_2_LASTPRESS = 0;
	private static long SKILL_HOTKEY_3_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(JJCR_DEBUG_VARIABLES);
		event.register(JJCR_DEBUG_NBT);
		event.register(OPEN_RPG_INTERFACE);
		event.register(CHANGE_DE_TYPE);
		event.register(ADVANCED_TECHNIQUE_KEY);
		event.register(TOGGLE_AUTO_RCT_KEY);
		event.register(TECHNIQUE_BURNOUT_HEALING);
		event.register(ENABLE_FAST_SKILLS_HOTKEYS);
		event.register(SAVE_FAST_SKILL);
		event.register(SKILL_HOTKEY_1);
		event.register(SKILL_HOTKEY_2);
		event.register(SKILL_HOTKEY_3);
		event.register(FAST_DOMAIN_EXPANSION);
		event.register(PASSIVE_TECHNIQUE);
		event.register(CHANGE_CT_FROM_JJCR);
		event.register(STRIKES_STRENGTHENING);
		event.register(INCREASE_OUTPUT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				JJCR_DEBUG_VARIABLES.consumeClick();
				JJCR_DEBUG_NBT.consumeClick();
				OPEN_RPG_INTERFACE.consumeClick();
				CHANGE_DE_TYPE.consumeClick();
				ADVANCED_TECHNIQUE_KEY.consumeClick();
				TOGGLE_AUTO_RCT_KEY.consumeClick();
				TECHNIQUE_BURNOUT_HEALING.consumeClick();
				ENABLE_FAST_SKILLS_HOTKEYS.consumeClick();
				SAVE_FAST_SKILL.consumeClick();
				SKILL_HOTKEY_1.consumeClick();
				SKILL_HOTKEY_2.consumeClick();
				SKILL_HOTKEY_3.consumeClick();
				FAST_DOMAIN_EXPANSION.consumeClick();
				PASSIVE_TECHNIQUE.consumeClick();
				CHANGE_CT_FROM_JJCR.consumeClick();
				STRIKES_STRENGTHENING.consumeClick();
				INCREASE_OUTPUT.consumeClick();
			}
		}
	}
}
