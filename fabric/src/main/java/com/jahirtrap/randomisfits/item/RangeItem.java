package com.jahirtrap.randomisfits.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public interface RangeItem {
    String RANGE_KEY = "Range";

    default boolean getMode(ItemStack stack) {
        if (stack.getTag() != null && !stack.getTag().contains(RANGE_KEY))
            setMode(stack, true);

        return stack.getOrCreateTag().getBoolean(RANGE_KEY);
    }

    default void setMode(ItemStack stack, Boolean range) {
        stack.getOrCreateTag().putBoolean(RANGE_KEY, range);
    }

    default String getModeText(Boolean range) {
        String mode;
        if (range) mode = Component.translatable("randomisfits.range.mode.yes").getString();
        else mode = Component.translatable("randomisfits.range.mode.no").getString();

        return mode;
    }

    default boolean enableRange(ItemStack stack) {
        return getMode(stack);
    }

    default int getRange() {
        return 1;
    }
}
