package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModBlocks;
import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.fabricmc.api.ModInitializer;

public class RandomisfitsMod implements ModInitializer {

    public static final String MODID = "randomisfits";

    @Override
    public void onInitialize() {
        RandomisfitsModBlocks.init();
        RandomisfitsModItems.init();
        RandomisfitsModTab.init();
    }
}
