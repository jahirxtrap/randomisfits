package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RandomisfitsModTab {
    public static CreativeModeTab TAB_RANDOMISFITS;

    public static void init() {
        TAB_RANDOMISFITS = new CreativeModeTab("randomisfits.tab_randomisfits") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE.get());
            }
        };
    }
}
