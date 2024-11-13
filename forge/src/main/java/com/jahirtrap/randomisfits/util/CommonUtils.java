package com.jahirtrap.randomisfits.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

public class CommonUtils {
    public static Component coloredTextComponent(String string, ChatFormatting color) {
        var textComponent = new TextComponent(string);
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

    public static String snakeToTitleCase(String string) {
        var result = new StringBuilder();
        for (String word : string.split("_"))
            if (!word.isEmpty())
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");

        return result.toString().trim();
    }

    public static int blueBar(ItemStack stack) {
        float f = Math.max(0, (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage());
        return Mth.hsvToRgb(1 - (f / 3), 1, 1);
    }
}
