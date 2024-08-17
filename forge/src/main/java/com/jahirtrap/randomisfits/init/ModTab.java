package com.jahirtrap.randomisfits.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static final CreativeModeTab TAB_RANDOMISFITS = new CreativeModeTab("randomisfits.tab_randomisfits") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModContent.NETHERITE_MULTITOOL.get());
        }
    };
}
