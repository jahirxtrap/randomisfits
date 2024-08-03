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
            .icon(() -> new ItemStack(ModContent.NETHERITE_MULTITOOL.get()))
            .displayItems((features, event) -> {
                event.accept(ModContent.INVISIBLE_HELMET);
                event.accept(ModContent.INVISIBLE_CHESTPLATE);
                event.accept(ModContent.INVISIBLE_LEGGINGS);
                event.accept(ModContent.INVISIBLE_BOOTS);
                event.accept(ModContent.REINFORCED_INVISIBLE_HELMET);
                event.accept(ModContent.REINFORCED_INVISIBLE_CHESTPLATE);
                event.accept(ModContent.REINFORCED_INVISIBLE_LEGGINGS);
                event.accept(ModContent.REINFORCED_INVISIBLE_BOOTS);
                event.accept(ModContent.IRON_MULTITOOL);
                event.accept(ModContent.DIAMOND_MULTITOOL);
                event.accept(ModContent.NETHERITE_MULTITOOL);
                event.accept(ModContent.IRON_HAMMER);
                event.accept(ModContent.DIAMOND_HAMMER);
                event.accept(ModContent.NETHERITE_HAMMER);
                event.accept(ModContent.IRON_LUMBERAXE);
                event.accept(ModContent.DIAMOND_LUMBERAXE);
                event.accept(ModContent.NETHERITE_LUMBERAXE);
                event.accept(ModContent.IRON_EXCAVATOR);
                event.accept(ModContent.DIAMOND_EXCAVATOR);
                event.accept(ModContent.NETHERITE_EXCAVATOR);
                event.accept(ModContent.REPAIR_KIT);
                event.accept(ModContent.DIAMOND_REPAIR_KIT);
                event.accept(ModContent.NETHERITE_REPAIR_KIT);
                event.accept(ModContent.ENDER_BAG);
                event.accept(ModContent.LAMP);
                event.accept(ModContent.NETHERITE_LAMP);
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TABS.register(bus);
    }
}
