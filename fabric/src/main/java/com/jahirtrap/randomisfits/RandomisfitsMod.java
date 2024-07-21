package com.jahirtrap.randomisfits;

import com.jahirtrap.configlib.TXFConfig;
import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModItems;
import com.jahirtrap.randomisfits.init.ModTab;
import net.fabricmc.api.ModInitializer;

public class RandomisfitsMod implements ModInitializer {

    public static final String MODID = "randomisfits";

    @Override
    public void onInitialize() {
        TXFConfig.init(MODID, ModConfig.class);
        ModItems.init();
        ModTab.init();
    }
}
