package com.jahirtrap.randomisfits;

import com.jahirtrap.configlib.TXFConfig;
import com.jahirtrap.randomisfits.init.RandomisfitsModBlocks;
import com.jahirtrap.randomisfits.init.RandomisfitsModConfig;
import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.fabricmc.api.ModInitializer;

public class RandomisfitsMod implements ModInitializer {

    public static final String MODID = "randomisfits";

    @Override
    public void onInitialize() {
        TXFConfig.init(MODID, RandomisfitsModConfig.class);
        RandomisfitsModBlocks.init();
        RandomisfitsModItems.init();
        RandomisfitsModTab.init();
    }
}
