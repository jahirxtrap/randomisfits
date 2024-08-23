package com.jahirtrap.randomisfits.network;

import com.jahirtrap.randomisfits.network.message.MessageOpenMenu;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.Channel;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class PacketHandler {
    public static final int PROTOCOL_VERSION = 1;
    private static int nextId = 0;
    public static final SimpleChannel INSTANCE = ChannelBuilder
            .named(ResourceLocation.fromNamespaceAndPath(MODID, "network"))
            .networkProtocolVersion(PROTOCOL_VERSION)
            .clientAcceptedVersions(Channel.VersionTest.exact(PROTOCOL_VERSION))
            .serverAcceptedVersions(Channel.VersionTest.exact(PROTOCOL_VERSION))
            .simpleChannel();

    public static void init() {
        INSTANCE.messageBuilder(MessageOpenMenu.class, nextId++).codec(MessageOpenMenu.CODEC).consumerNetworkThread(MessageOpenMenu::handle).add();
    }

    public static <T> void sendToServer(T message) {
        INSTANCE.send(message, PacketDistributor.SERVER.noArg());
    }
}
