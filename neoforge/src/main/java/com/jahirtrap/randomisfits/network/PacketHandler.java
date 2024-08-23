package com.jahirtrap.randomisfits.network;

import com.jahirtrap.randomisfits.network.message.MessageOpenMenu;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class PacketHandler {
    private static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID);

        registrar.playToServer(MessageOpenMenu.TYPE, MessageOpenMenu.CODEC, MessageOpenMenu::handle);
    }

    public static void init(IEventBus bus) {
        bus.addListener(PacketHandler::register);
    }
}
