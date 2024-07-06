package com.jahirtrap.randomisfits.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsModTab.TAB_RANDOMISFITS;

public class BaseWearableItem extends BlockItem {
    public BaseWearableItem(Block block, Properties properties) {
        super(block, properties.tab(TAB_RANDOMISFITS));
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot slot, Entity entity) {
        return slot == EquipmentSlot.HEAD;
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
