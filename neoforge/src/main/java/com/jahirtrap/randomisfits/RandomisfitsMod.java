package com.jahirtrap.randomisfits;

import com.jahirtrap.configlib.TXFConfig;
import com.jahirtrap.randomisfits.init.ModComponents;
import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import com.jahirtrap.randomisfits.init.ModTab;
import com.jahirtrap.randomisfits.network.PacketHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod(IEventBus bus) {
        TXFConfig.init(MODID, ModConfig.class);
        ModComponents.init(bus);
        ModContent.init(bus);
        ModTab.init(bus);
        PacketHandler.init(bus);
    }
}
