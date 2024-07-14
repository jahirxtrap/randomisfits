package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModBlocks;
import com.jahirtrap.randomisfits.init.RandomisfitsModConfig;
import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import com.jahirtrap.randomisfits.util.configlib.TXFConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod(IEventBus bus) {
        TXFConfig.init(MODID, RandomisfitsModConfig.class);
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (client, parent) -> TXFConfig.getScreen(parent, MODID));

        RandomisfitsModBlocks.REGISTRY.register(bus);
        RandomisfitsModItems.REGISTRY.register(bus);
        RandomisfitsModTab.init(bus);
    }
}
