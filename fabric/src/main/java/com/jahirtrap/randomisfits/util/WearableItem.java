package com.jahirtrap.randomisfits.util;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public interface WearableItem {
    EquipmentSlot getEquipmentSlot(ItemStack stack);
}
