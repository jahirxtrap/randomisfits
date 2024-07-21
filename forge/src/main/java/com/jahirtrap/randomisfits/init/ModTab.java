package com.jahirtrap.randomisfits.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static CreativeModeTab TAB_RANDOMISFITS;

    public static void init() {
        TAB_RANDOMISFITS = new CreativeModeTab("randomisfits.tab_randomisfits") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ModItems.NETHERITE_MULTITOOL.get());
            }
        };
    }
}