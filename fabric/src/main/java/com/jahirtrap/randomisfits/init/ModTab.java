package com.jahirtrap.randomisfits.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    public static void init() {
        CreativeModeTab TAB_RANDOMISFITS = FabricItemGroup.builder(new ResourceLocation(MODID, "tab_randomisfits"))
                .icon(() -> new ItemStack(ModContent.NETHERITE_MULTITOOL))
                .displayItems((features, event) -> {
                    for (Item item : ModContent.ITEMS)
                        event.accept(item);
                })
                .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
                .build();
    }
}
