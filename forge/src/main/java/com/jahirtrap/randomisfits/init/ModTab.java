package com.jahirtrap.randomisfits.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> TAB_RANDOMISFITS = TABS.register("tab_randomisfits", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModContent.NETHERITE_MULTITOOL.get()))
            .displayItems((features, event) -> {
                event.accept(ModContent.INVISIBLE_HELMET.get());
                event.accept(ModContent.INVISIBLE_CHESTPLATE.get());
                event.accept(ModContent.INVISIBLE_LEGGINGS.get());
                event.accept(ModContent.INVISIBLE_BOOTS.get());
                event.accept(ModContent.REINFORCED_INVISIBLE_HELMET.get());
                event.accept(ModContent.REINFORCED_INVISIBLE_CHESTPLATE.get());
                event.accept(ModContent.REINFORCED_INVISIBLE_LEGGINGS.get());
                event.accept(ModContent.REINFORCED_INVISIBLE_BOOTS.get());
                event.accept(ModContent.IRON_MULTITOOL.get());
                event.accept(ModContent.DIAMOND_MULTITOOL.get());
                event.accept(ModContent.NETHERITE_MULTITOOL.get());
                event.accept(ModContent.IRON_HAMMER.get());
                event.accept(ModContent.DIAMOND_HAMMER.get());
                event.accept(ModContent.NETHERITE_HAMMER.get());
                event.accept(ModContent.IRON_EXCAVATOR.get());
                event.accept(ModContent.DIAMOND_EXCAVATOR.get());
                event.accept(ModContent.NETHERITE_EXCAVATOR.get());
                event.accept(ModContent.REPAIR_KIT.get());
                event.accept(ModContent.DIAMOND_REPAIR_KIT.get());
                event.accept(ModContent.NETHERITE_REPAIR_KIT.get());
                event.accept(ModContent.LAMP.get());
                event.accept(ModContent.NETHERITE_LAMP.get());
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TABS.register(bus);
    }
}
