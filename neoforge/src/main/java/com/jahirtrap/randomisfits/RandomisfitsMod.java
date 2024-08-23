package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import com.jahirtrap.randomisfits.init.ModMaterials;
import com.jahirtrap.randomisfits.init.ModTab;
import com.jahirtrap.randomisfits.network.PacketHandler;
import com.jahirtrap.randomisfits.util.configlib.TXFConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod(IEventBus bus) {
        TXFConfig.init(MODID, ModConfig.class);
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (client, parent) -> TXFConfig.getScreen(parent, MODID));

        ModMaterials.init(bus);
        ModContent.init(bus);
        ModTab.init(bus);
        PacketHandler.init(bus);
    }
}
