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
                .icon(() -> new ItemStack(ModItems.NETHERITE_MULTITOOL))
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
                .build();
    }
}
