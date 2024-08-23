package com.jahirtrap.randomisfits.network;

import com.jahirtrap.randomisfits.network.message.MessageOpenMenu;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class PacketHandler {
    private static void register(RegisterPayloadHandlerEvent event) {
        IPayloadRegistrar registrar = event.registrar(MODID);

        registrar.play(MessageOpenMenu.ID, MessageOpenMenu::new, MessageOpenMenu::handle);
    }

    public static void init(IEventBus bus) {
        bus.addListener(PacketHandler::register);
    }
}
