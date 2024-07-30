package com.jahirtrap.randomisfits.util;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CommonUtils {
    public static Component coloredTextComponent(String string, ChatFormatting color) {
        var textComponent = Component.literal(string);
        textComponent.withStyle(color);
        return textComponent;
    }

    public static String formatText(float amount) {
        if (amount % 1.0 == 0) {
            return String.format("%.0f", amount);
        } else {
            return String.valueOf(amount);
        }
    }

    public static TagKey<Item> itemTag(String string) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(string));
    }
}
