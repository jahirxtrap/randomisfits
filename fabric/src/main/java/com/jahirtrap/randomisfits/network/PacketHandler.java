package com.jahirtrap.randomisfits.network;

import com.jahirtrap.randomisfits.network.message.MessageOpenMenu;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PacketHandler {
    public static void init() {
        PayloadTypeRegistry.playC2S().register(MessageOpenMenu.TYPE, MessageOpenMenu.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(MessageOpenMenu.TYPE, MessageOpenMenu::handle);
    }
}
