package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;

public class BaseWearableItem extends BlockItem {
    public BaseWearableItem(Block block, Properties properties) {
        super(block, properties.useBlockDescriptionPrefix().component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.HEAD).build()));
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        if (ModConfig.wearableLightBlocks) return EquipmentSlot.HEAD;
        else return EquipmentSlot.MAINHAND;
    }
}
