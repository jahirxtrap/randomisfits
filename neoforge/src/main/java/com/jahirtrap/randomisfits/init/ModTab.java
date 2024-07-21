package com.jahirtrap.randomisfits.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> TAB_RANDOMISFITS = TABS.register("tab_randomisfits", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.NETHERITE_MULTITOOL.get()))
            .displayItems((features, event) -> {
                event.accept(ModItems.INVISIBLE_HELMET);
                event.accept(ModItems.INVISIBLE_CHESTPLATE);
                event.accept(ModItems.INVISIBLE_LEGGINGS);
                event.accept(ModItems.INVISIBLE_BOOTS);
                event.accept(ModItems.REINFORCED_INVISIBLE_HELMET);
                event.accept(ModItems.REINFORCED_INVISIBLE_CHESTPLATE);
                event.accept(ModItems.REINFORCED_INVISIBLE_LEGGINGS);
                event.accept(ModItems.REINFORCED_INVISIBLE_BOOTS);
                event.accept(ModItems.IRON_MULTITOOL);
                event.accept(ModItems.DIAMOND_MULTITOOL);
                event.accept(ModItems.NETHERITE_MULTITOOL);
                event.accept(ModItems.REPAIR_KIT);
                event.accept(ModItems.DIAMOND_REPAIR_KIT);
                event.accept(ModItems.NETHERITE_REPAIR_KIT);
                event.accept(ModItems.LAMP);
                event.accept(ModItems.NETHERITE_LAMP);
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TABS.register(bus);
    }
}
