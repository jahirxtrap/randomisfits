package com.jahirtrap.randomisfits;

import com.jahirtrap.configlib.TXFConfig;
import com.jahirtrap.randomisfits.init.ModComponents;
import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import com.jahirtrap.randomisfits.init.ModTab;
import com.jahirtrap.randomisfits.network.PacketHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RandomisfitsMod.MODID)
public class RandomisfitsMod {

    public static final String MODID = "randomisfits";

    public RandomisfitsMod(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        TXFConfig.init(MODID, ModConfig.class);
        ModComponents.init(bus);
        ModContent.init(bus);
        ModTab.init(bus);
        PacketHandler.init();
    }
}
