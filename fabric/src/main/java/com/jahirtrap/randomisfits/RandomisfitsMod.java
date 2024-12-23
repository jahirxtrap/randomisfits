package com.jahirtrap.randomisfits;

import com.jahirtrap.configlib.TXFConfig;
import com.jahirtrap.randomisfits.init.ModComponents;
import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import com.jahirtrap.randomisfits.init.ModTab;
import com.jahirtrap.randomisfits.network.PacketHandler;
import net.fabricmc.api.ModInitializer;

public class RandomisfitsMod implements ModInitializer {

    public static final String MODID = "randomisfits";

    @Override
    public void onInitialize() {
        TXFConfig.init(MODID, ModConfig.class);
        ModComponents.init();
        ModContent.init();
        ModTab.init();
        PacketHandler.init();
    }
}
