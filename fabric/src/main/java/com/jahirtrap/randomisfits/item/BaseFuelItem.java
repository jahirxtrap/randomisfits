package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.util.FuelItem;
import net.minecraft.world.item.ItemStack;

public class BaseFuelItem extends BaseItem implements FuelItem {
    private final int burnTime;

    public BaseFuelItem(Properties properties, int burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        return burnTime;
    }
}
