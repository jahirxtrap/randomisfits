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
            .icon(() -> new ItemStack(ModItems.NETHERITE_MULTITOOL.get()))
            .displayItems((features, event) -> {
                event.accept(ModItems.INVISIBLE_HELMET.get());
                event.accept(ModItems.INVISIBLE_CHESTPLATE.get());
                event.accept(ModItems.INVISIBLE_LEGGINGS.get());
                event.accept(ModItems.INVISIBLE_BOOTS.get());
                event.accept(ModItems.REINFORCED_INVISIBLE_HELMET.get());
                event.accept(ModItems.REINFORCED_INVISIBLE_CHESTPLATE.get());
                event.accept(ModItems.REINFORCED_INVISIBLE_LEGGINGS.get());
                event.accept(ModItems.REINFORCED_INVISIBLE_BOOTS.get());
                event.accept(ModItems.IRON_MULTITOOL.get());
                event.accept(ModItems.DIAMOND_MULTITOOL.get());
                event.accept(ModItems.NETHERITE_MULTITOOL.get());
                event.accept(ModItems.REPAIR_KIT.get());
                event.accept(ModItems.DIAMOND_REPAIR_KIT.get());
                event.accept(ModItems.NETHERITE_REPAIR_KIT.get());
                event.accept(ModItems.LAMP.get());
                event.accept(ModItems.NETHERITE_LAMP.get());
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TABS.register(bus);
    }
}
