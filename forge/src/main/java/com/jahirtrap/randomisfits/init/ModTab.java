package com.jahirtrap.randomisfits.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    private static void register(CreativeModeTabEvent.Register register) {
        CreativeModeTab TAB_RANDOMISFITS = register.registerCreativeModeTab(new ResourceLocation(MODID, "tab_randomisfits"), builder -> builder.icon(() -> new ItemStack(ModContent.NETHERITE_EXTRA_TOOLS.get(0).get()))
                .displayItems((features, event) -> {
                    for (RegistryObject<Item> item : ModContent.ITEMS.getEntries())
                        event.accept(item.get());
                })
                .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
                .build());
    }

    public static void init(IEventBus bus) {
        bus.addListener(ModTab::register);
    }
}
