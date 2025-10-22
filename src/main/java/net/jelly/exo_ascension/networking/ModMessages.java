package net.jelly.exo_ascension.networking;

import net.jelly.exo_ascension.ExoAscensionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(ExoAscensionMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(MultipartEntityMessage.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(MultipartEntityMessage::read)
                .encoder(MultipartEntityMessage::write)
                .consumerMainThread(MultipartEntityMessage::handle)
                .add();

        net.messageBuilder(AetherionArmMessage.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(AetherionArmMessage::read)
                .encoder(AetherionArmMessage::write)
                .consumerMainThread(AetherionArmMessage::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToTrackingPlayers(MSG message, Entity entity) {
        INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), message);
    }
}