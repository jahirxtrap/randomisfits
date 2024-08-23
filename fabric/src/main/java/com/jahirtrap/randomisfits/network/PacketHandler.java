package com.jahirtrap.randomisfits.network;

import com.jahirtrap.randomisfits.network.message.MessageOpenMenu;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PacketHandler {
    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(MessageOpenMenu.ID, MessageOpenMenu::handle);
    }
}
