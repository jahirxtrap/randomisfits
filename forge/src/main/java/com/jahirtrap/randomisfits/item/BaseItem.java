package com.jahirtrap.randomisfits.item;

import net.minecraft.world.item.Item;

import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;

public class BaseItem extends Item {
    public BaseItem(Properties properties) {
        super(properties.tab(TAB_RANDOMISFITS));
    }
}
