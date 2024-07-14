package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModBlocks;
import com.jahirtrap.randomisfits.init.RandomisfitsModConfig;
import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import com.jahirtrap.randomisfits.util.configlib.TXFConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        TXFConfig.init(MODID, RandomisfitsModConfig.class);
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> TXFConfig.getScreen(parent, MODID)));

        RandomisfitsModBlocks.REGISTRY.register(bus);
        RandomisfitsModItems.REGISTRY.register(bus);
        RandomisfitsModTab.init();
    }
}
