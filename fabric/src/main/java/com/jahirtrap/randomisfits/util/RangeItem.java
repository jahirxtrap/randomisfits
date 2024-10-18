package com.jahirtrap.randomisfits.util;

import com.jahirtrap.randomisfits.init.ModComponents;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public interface RangeItem {
    DataComponentType<Boolean> RANGE_KEY = ModComponents.RANGE_KEY;

    default boolean getMode(ItemStack stack) {
        if (!stack.getComponents().has(RANGE_KEY))
            setMode(stack, true);

        return stack.getOrDefault(RANGE_KEY, true);
    }

    default void setMode(ItemStack stack, Boolean range) {
        stack.set(RANGE_KEY, range);
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
