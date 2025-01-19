package com.jahirtrap.randomisfits.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> TAB_RANDOMISFITS = TABS.register("tab_randomisfits", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModContent.NETHERITE_EXTRA_TOOLS.get(0).get()))
            .displayItems((features, event) -> {
                for (DeferredHolder<Item, ? extends Item> item : ModContent.ITEMS.getEntries())
                    event.accept(item.get());
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TABS.register(bus);
    }
}
