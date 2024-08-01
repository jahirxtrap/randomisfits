package com.jahirtrap.randomisfits.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    public static void init() {
        CreativeModeTab TAB_RANDOMISFITS = FabricItemGroup.builder(new ResourceLocation(MODID, "tab_randomisfits"))
                .icon(() -> new ItemStack(ModContent.NETHERITE_MULTITOOL))
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
                    event.accept(ModContent.LAMP);
                    event.accept(ModContent.NETHERITE_LAMP);
                })
                .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
                .build();
    }
}
