package net.mcreator.jjcr.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.jjcr.JjcrMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JjcrModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		JjcrMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		JjcrMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.PhysicalLevel = original.PhysicalLevel;
			clone.SorceryLevel = original.SorceryLevel;
			clone.CursedTechniquesLevel = original.CursedTechniquesLevel;
			clone.CursedToolsLevel = original.CursedToolsLevel;
			clone.RCTLevel = original.RCTLevel;
			clone.DELevel = original.DELevel;
			clone.RCTOutputMAX = original.RCTOutputMAX;
			clone.CursedEnergyColor = original.CursedEnergyColor;
			clone.CursedEnergyTrait = original.CursedEnergyTrait;
			if (!event.isWasDeath()) {
				clone.PlayerSelectCurseTechniqueName = original.PlayerSelectCurseTechniqueName;
				clone.PlayerSelectCurseTechniqueCost = original.PlayerSelectCurseTechniqueCost;
				clone.PlayerSelectCurseTechnique = original.PlayerSelectCurseTechnique;
				clone.PlayerLevel = original.PlayerLevel;
				clone.PlayerCursePower = original.PlayerCursePower;
				clone.PlayerCurseTechnique = original.PlayerCurseTechnique;
				clone.PlayerExperience = original.PlayerExperience;
				clone.PlayerFame = original.PlayerFame;
				clone.PhysicalAttack = original.PhysicalAttack;
				clone.PlayerTechniqueUsedNumber = original.PlayerTechniqueUsedNumber;
				clone.PlayerCurseTechnique2 = original.PlayerCurseTechnique2;
				clone.PlayerCharge = original.PlayerCharge;
				clone.PlayerProfession = original.PlayerProfession;
				clone.PlayerCursePowerMAX = original.PlayerCursePowerMAX;
				clone.HeadStatus = original.HeadStatus;
				clone.ChestStatus = original.ChestStatus;
				clone.BellyStatus = original.BellyStatus;
				clone.RightArmStatus = original.RightArmStatus;
				clone.LeftArmStatus = original.LeftArmStatus;
				clone.RightLegStatus = original.RightLegStatus;
				clone.LeftLegStatus = original.LeftLegStatus;
				clone.RCTOutput = original.RCTOutput;
				clone.SecondLeftArmStatus = original.SecondLeftArmStatus;
				clone.SecondRightArmStatus = original.SecondRightArmStatus;
				clone.addon_ver = original.addon_ver;
				clone.BlackFlashChance = original.BlackFlashChance;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					JjcrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					JjcrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					JjcrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "jjcr_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				JjcrMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "jjcr_mapvars";
		public String HeadDamagedText = "You \u00A74hurt\u00A7r your  \u00A7lHead";
		public String HeadLostText = "You \u00A77lost \u00A7ryour \u00A7lHead";
		public String ChestDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lChest";
		public String ChestLostText = "You \u00A77lost \u00A7ryour \u00A7lChest";
		public String BellyDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lBelly";
		public String BellyLostText = "You \u00A77lost \u00A7ryour \u00A7lBelly";
		public String RightArmDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lRight Arm";
		public String RightArmLostText = "You \u00A77lost\u00A7r your \u00A7lRight Arm";
		public String LeftArmDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lLeft Arm";
		public String LeftArmLostText = "You \u00A77lost \u00A7ryour \u00A7lLeft Arm";
		public String RightLegDamagedText = "You \u00A74hurt\u00A7r your \u00A7lRight Leg";
		public String RightLegLostText = "You \u00A77lost \u00A7ryour \u00A7lRight Leg";
		public String LeftLegDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lLeft Leg";
		public String LeftLegLostText = "You \u00A77lost \u00A7ryour \u00A7lLeft Leg";
		public String HaventMasteredYet = "\"\u00A7lHaven't mastered yet\"";
		public String YourDomainTypeChangeToSmall = "Small DE";
		public String YourDomainTypeChangeToHuge = "Huge DE";
		public String YourDomainTypeChangeToNormal = "Normal DE";
		public String SecondLeftArmDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lSecond Left Arm";
		public String SecondLeftArmLostText = "You \u00A77lost \u00A7ryour \u00A7lSecond Left Arm";
		public String SecondRightArmDamagedText = "You \u00A74hurt \u00A7ryour \u00A7lSecond Right Arm";
		public String SecondRightArmLostText = "You \u00A77lost \u00A7ryour \u00A7lSecond Right Arm";
		public boolean WaterWalking = false;
		public boolean RCTOverlay = true;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			HeadDamagedText = nbt.getString("HeadDamagedText");
			HeadLostText = nbt.getString("HeadLostText");
			ChestDamagedText = nbt.getString("ChestDamagedText");
			ChestLostText = nbt.getString("ChestLostText");
			BellyDamagedText = nbt.getString("BellyDamagedText");
			BellyLostText = nbt.getString("BellyLostText");
			RightArmDamagedText = nbt.getString("RightArmDamagedText");
			RightArmLostText = nbt.getString("RightArmLostText");
			LeftArmDamagedText = nbt.getString("LeftArmDamagedText");
			LeftArmLostText = nbt.getString("LeftArmLostText");
			RightLegDamagedText = nbt.getString("RightLegDamagedText");
			RightLegLostText = nbt.getString("RightLegLostText");
			LeftLegDamagedText = nbt.getString("LeftLegDamagedText");
			LeftLegLostText = nbt.getString("LeftLegLostText");
			HaventMasteredYet = nbt.getString("HaventMasteredYet");
			YourDomainTypeChangeToSmall = nbt.getString("YourDomainTypeChangeToSmall");
			YourDomainTypeChangeToHuge = nbt.getString("YourDomainTypeChangeToHuge");
			YourDomainTypeChangeToNormal = nbt.getString("YourDomainTypeChangeToNormal");
			SecondLeftArmDamagedText = nbt.getString("SecondLeftArmDamagedText");
			SecondLeftArmLostText = nbt.getString("SecondLeftArmLostText");
			SecondRightArmDamagedText = nbt.getString("SecondRightArmDamagedText");
			SecondRightArmLostText = nbt.getString("SecondRightArmLostText");
			WaterWalking = nbt.getBoolean("WaterWalking");
			RCTOverlay = nbt.getBoolean("RCTOverlay");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putString("HeadDamagedText", HeadDamagedText);
			nbt.putString("HeadLostText", HeadLostText);
			nbt.putString("ChestDamagedText", ChestDamagedText);
			nbt.putString("ChestLostText", ChestLostText);
			nbt.putString("BellyDamagedText", BellyDamagedText);
			nbt.putString("BellyLostText", BellyLostText);
			nbt.putString("RightArmDamagedText", RightArmDamagedText);
			nbt.putString("RightArmLostText", RightArmLostText);
			nbt.putString("LeftArmDamagedText", LeftArmDamagedText);
			nbt.putString("LeftArmLostText", LeftArmLostText);
			nbt.putString("RightLegDamagedText", RightLegDamagedText);
			nbt.putString("RightLegLostText", RightLegLostText);
			nbt.putString("LeftLegDamagedText", LeftLegDamagedText);
			nbt.putString("LeftLegLostText", LeftLegLostText);
			nbt.putString("HaventMasteredYet", HaventMasteredYet);
			nbt.putString("YourDomainTypeChangeToSmall", YourDomainTypeChangeToSmall);
			nbt.putString("YourDomainTypeChangeToHuge", YourDomainTypeChangeToHuge);
			nbt.putString("YourDomainTypeChangeToNormal", YourDomainTypeChangeToNormal);
			nbt.putString("SecondLeftArmDamagedText", SecondLeftArmDamagedText);
			nbt.putString("SecondLeftArmLostText", SecondLeftArmLostText);
			nbt.putString("SecondRightArmDamagedText", SecondRightArmDamagedText);
			nbt.putString("SecondRightArmLostText", SecondRightArmLostText);
			nbt.putBoolean("WaterWalking", WaterWalking);
			nbt.putBoolean("RCTOverlay", RCTOverlay);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				JjcrMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("jjcr", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String PlayerSelectCurseTechniqueName = "\"\"";
		public double PlayerSelectCurseTechniqueCost = 0;
		public double PlayerSelectCurseTechnique = 0;
		public double PlayerLevel = 0;
		public double PlayerCursePower = 0;
		public double PlayerCurseTechnique = 0;
		public double PlayerExperience = 0;
		public double PlayerFame = 0;
		public boolean PhysicalAttack = false;
		public double PlayerTechniqueUsedNumber = 0;
		public double PlayerCurseTechnique2 = 0;
		public double PlayerCharge = 0;
		public double PlayerProfession = 0;
		public double PlayerCursePowerMAX = 0;
		public double PhysicalLevel = 0;
		public double SorceryLevel = 0;
		public double CursedTechniquesLevel = 0;
		public double CursedToolsLevel = 0;
		public double RCTLevel = 0;
		public double DELevel = 0.0;
		public double HeadStatus = 1.0;
		public double ChestStatus = 1.0;
		public double BellyStatus = 1.0;
		public double RightArmStatus = 1.0;
		public double LeftArmStatus = 1.0;
		public double RightLegStatus = 1.0;
		public double LeftLegStatus = 1.0;
		public double RCTOutput = 0.0;
		public double RCTOutputMAX = 0.0;
		public double SecondLeftArmStatus = 1.0;
		public double SecondRightArmStatus = 1.0;
		public String CursedEnergyColor = "";
		public String CursedEnergyTrait = "";
		public String addon_ver = "JJCR 2.3.1";
		public double BlackFlashChance = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				JjcrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("PlayerSelectCurseTechniqueName", PlayerSelectCurseTechniqueName);
			nbt.putDouble("PlayerSelectCurseTechniqueCost", PlayerSelectCurseTechniqueCost);
			nbt.putDouble("PlayerSelectCurseTechnique", PlayerSelectCurseTechnique);
			nbt.putDouble("PlayerLevel", PlayerLevel);
			nbt.putDouble("PlayerCursePower", PlayerCursePower);
			nbt.putDouble("PlayerCurseTechnique", PlayerCurseTechnique);
			nbt.putDouble("PlayerExperience", PlayerExperience);
			nbt.putDouble("PlayerFame", PlayerFame);
			nbt.putBoolean("PhysicalAttack", PhysicalAttack);
			nbt.putDouble("PlayerTechniqueUsedNumber", PlayerTechniqueUsedNumber);
			nbt.putDouble("PlayerCurseTechnique2", PlayerCurseTechnique2);
			nbt.putDouble("PlayerCharge", PlayerCharge);
			nbt.putDouble("PlayerProfession", PlayerProfession);
			nbt.putDouble("PlayerCursePowerMAX", PlayerCursePowerMAX);
			nbt.putDouble("PhysicalLevel", PhysicalLevel);
			nbt.putDouble("SorceryLevel", SorceryLevel);
			nbt.putDouble("CursedTechniquesLevel", CursedTechniquesLevel);
			nbt.putDouble("CursedToolsLevel", CursedToolsLevel);
			nbt.putDouble("RCTLevel", RCTLevel);
			nbt.putDouble("DELevel", DELevel);
			nbt.putDouble("HeadStatus", HeadStatus);
			nbt.putDouble("ChestStatus", ChestStatus);
			nbt.putDouble("BellyStatus", BellyStatus);
			nbt.putDouble("RightArmStatus", RightArmStatus);
			nbt.putDouble("LeftArmStatus", LeftArmStatus);
			nbt.putDouble("RightLegStatus", RightLegStatus);
			nbt.putDouble("LeftLegStatus", LeftLegStatus);
			nbt.putDouble("RCTOutput", RCTOutput);
			nbt.putDouble("RCTOutputMAX", RCTOutputMAX);
			nbt.putDouble("SecondLeftArmStatus", SecondLeftArmStatus);
			nbt.putDouble("SecondRightArmStatus", SecondRightArmStatus);
			nbt.putString("CursedEnergyColor", CursedEnergyColor);
			nbt.putString("CursedEnergyTrait", CursedEnergyTrait);
			nbt.putString("addon_ver", addon_ver);
			nbt.putDouble("BlackFlashChance", BlackFlashChance);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			PlayerSelectCurseTechniqueName = nbt.getString("PlayerSelectCurseTechniqueName");
			PlayerSelectCurseTechniqueCost = nbt.getDouble("PlayerSelectCurseTechniqueCost");
			PlayerSelectCurseTechnique = nbt.getDouble("PlayerSelectCurseTechnique");
			PlayerLevel = nbt.getDouble("PlayerLevel");
			PlayerCursePower = nbt.getDouble("PlayerCursePower");
			PlayerCurseTechnique = nbt.getDouble("PlayerCurseTechnique");
			PlayerExperience = nbt.getDouble("PlayerExperience");
			PlayerFame = nbt.getDouble("PlayerFame");
			PhysicalAttack = nbt.getBoolean("PhysicalAttack");
			PlayerTechniqueUsedNumber = nbt.getDouble("PlayerTechniqueUsedNumber");
			PlayerCurseTechnique2 = nbt.getDouble("PlayerCurseTechnique2");
			PlayerCharge = nbt.getDouble("PlayerCharge");
			PlayerProfession = nbt.getDouble("PlayerProfession");
			PlayerCursePowerMAX = nbt.getDouble("PlayerCursePowerMAX");
			PhysicalLevel = nbt.getDouble("PhysicalLevel");
			SorceryLevel = nbt.getDouble("SorceryLevel");
			CursedTechniquesLevel = nbt.getDouble("CursedTechniquesLevel");
			CursedToolsLevel = nbt.getDouble("CursedToolsLevel");
			RCTLevel = nbt.getDouble("RCTLevel");
			DELevel = nbt.getDouble("DELevel");
			HeadStatus = nbt.getDouble("HeadStatus");
			ChestStatus = nbt.getDouble("ChestStatus");
			BellyStatus = nbt.getDouble("BellyStatus");
			RightArmStatus = nbt.getDouble("RightArmStatus");
			LeftArmStatus = nbt.getDouble("LeftArmStatus");
			RightLegStatus = nbt.getDouble("RightLegStatus");
			LeftLegStatus = nbt.getDouble("LeftLegStatus");
			RCTOutput = nbt.getDouble("RCTOutput");
			RCTOutputMAX = nbt.getDouble("RCTOutputMAX");
			SecondLeftArmStatus = nbt.getDouble("SecondLeftArmStatus");
			SecondRightArmStatus = nbt.getDouble("SecondRightArmStatus");
			CursedEnergyColor = nbt.getString("CursedEnergyColor");
			CursedEnergyTrait = nbt.getString("CursedEnergyTrait");
			addon_ver = nbt.getString("addon_ver");
			BlackFlashChance = nbt.getDouble("BlackFlashChance");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.PlayerSelectCurseTechniqueName = message.data.PlayerSelectCurseTechniqueName;
					variables.PlayerSelectCurseTechniqueCost = message.data.PlayerSelectCurseTechniqueCost;
					variables.PlayerSelectCurseTechnique = message.data.PlayerSelectCurseTechnique;
					variables.PlayerLevel = message.data.PlayerLevel;
					variables.PlayerCursePower = message.data.PlayerCursePower;
					variables.PlayerCurseTechnique = message.data.PlayerCurseTechnique;
					variables.PlayerExperience = message.data.PlayerExperience;
					variables.PlayerFame = message.data.PlayerFame;
					variables.PhysicalAttack = message.data.PhysicalAttack;
					variables.PlayerTechniqueUsedNumber = message.data.PlayerTechniqueUsedNumber;
					variables.PlayerCurseTechnique2 = message.data.PlayerCurseTechnique2;
					variables.PlayerCharge = message.data.PlayerCharge;
					variables.PlayerProfession = message.data.PlayerProfession;
					variables.PlayerCursePowerMAX = message.data.PlayerCursePowerMAX;
					variables.PhysicalLevel = message.data.PhysicalLevel;
					variables.SorceryLevel = message.data.SorceryLevel;
					variables.CursedTechniquesLevel = message.data.CursedTechniquesLevel;
					variables.CursedToolsLevel = message.data.CursedToolsLevel;
					variables.RCTLevel = message.data.RCTLevel;
					variables.DELevel = message.data.DELevel;
					variables.HeadStatus = message.data.HeadStatus;
					variables.ChestStatus = message.data.ChestStatus;
					variables.BellyStatus = message.data.BellyStatus;
					variables.RightArmStatus = message.data.RightArmStatus;
					variables.LeftArmStatus = message.data.LeftArmStatus;
					variables.RightLegStatus = message.data.RightLegStatus;
					variables.LeftLegStatus = message.data.LeftLegStatus;
					variables.RCTOutput = message.data.RCTOutput;
					variables.RCTOutputMAX = message.data.RCTOutputMAX;
					variables.SecondLeftArmStatus = message.data.SecondLeftArmStatus;
					variables.SecondRightArmStatus = message.data.SecondRightArmStatus;
					variables.CursedEnergyColor = message.data.CursedEnergyColor;
					variables.CursedEnergyTrait = message.data.CursedEnergyTrait;
					variables.addon_ver = message.data.addon_ver;
					variables.BlackFlashChance = message.data.BlackFlashChance;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
