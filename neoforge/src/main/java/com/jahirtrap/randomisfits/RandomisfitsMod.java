package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModBlocks;
import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod(IEventBus bus) {
        RandomisfitsModBlocks.REGISTRY.register(bus);
        RandomisfitsModItems.REGISTRY.register(bus);
        RandomisfitsModTab.init(bus);
    }
}
