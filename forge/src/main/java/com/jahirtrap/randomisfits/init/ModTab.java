package com.jahirtrap.randomisfits.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    public static void register(CreativeModeTabEvent.Register register) {
        CreativeModeTab TAB_RANDOMISFITS = register.registerCreativeModeTab(new ResourceLocation(MODID, "tab_randomisfits"), builder -> builder.icon(() -> new ItemStack(ModContent.NETHERITE_MULTITOOL.get()))
                .displayItems((features, event) -> {
                    event.accept(ModContent.INVISIBLE_HELMET.get());
                    event.accept(ModContent.INVISIBLE_CHESTPLATE.get());
                    event.accept(ModContent.INVISIBLE_LEGGINGS.get());
                    event.accept(ModContent.INVISIBLE_BOOTS.get());
                    event.accept(ModContent.REINFORCED_INVISIBLE_HELMET.get());
                    event.accept(ModContent.REINFORCED_INVISIBLE_CHESTPLATE.get());
                    event.accept(ModContent.REINFORCED_INVISIBLE_LEGGINGS.get());
                    event.accept(ModContent.REINFORCED_INVISIBLE_BOOTS.get());
                    event.accept(ModContent.HANDLE.get());
                    event.accept(ModContent.IRON_MULTITOOL.get());
                    event.accept(ModContent.DIAMOND_MULTITOOL.get());
                    event.accept(ModContent.NETHERITE_MULTITOOL.get());
                    event.accept(ModContent.IRON_HAMMER.get());
                    event.accept(ModContent.DIAMOND_HAMMER.get());
                    event.accept(ModContent.NETHERITE_HAMMER.get());
                    event.accept(ModContent.IRON_LUMBERAXE.get());
                    event.accept(ModContent.DIAMOND_LUMBERAXE.get());
                    event.accept(ModContent.NETHERITE_LUMBERAXE.get());
                    event.accept(ModContent.IRON_EXCAVATOR.get());
                    event.accept(ModContent.DIAMOND_EXCAVATOR.get());
                    event.accept(ModContent.NETHERITE_EXCAVATOR.get());
                    event.accept(ModContent.GLASS_CUTTER.get());
                    event.accept(ModContent.DIAMOND_GLASS_CUTTER.get());
                    event.accept(ModContent.NETHERITE_GLASS_CUTTER.get());
                    event.accept(ModContent.REPAIR_KIT.get());
                    event.accept(ModContent.DIAMOND_REPAIR_KIT.get());
                    event.accept(ModContent.NETHERITE_REPAIR_KIT.get());
                    event.accept(ModContent.CRAFTING_PLATE.get());
                    event.accept(ModContent.ENDER_BAG.get());
                    event.accept(ModContent.BULB.get());
                    event.accept(ModContent.LAMP.get());
                    event.accept(ModContent.NETHERITE_LAMP.get());
                    event.accept(ModContent.GLOW_CORE.get());
                })
                .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
                .build());
    }

    public static void init(IEventBus bus) {
        bus.addListener(ModTab::register);
    }
}
