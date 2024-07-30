package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import com.jahirtrap.randomisfits.init.ModTab;
import com.jahirtrap.randomisfits.util.configlib.TXFConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.ConfigScreenHandler;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod(IEventBus bus) {
        TXFConfig.init(MODID, ModConfig.class);
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> TXFConfig.getScreen(parent, MODID)));

        ModContent.init(bus);
        ModTab.init(bus);
    }
}
