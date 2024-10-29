package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.util.WearableItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class BaseWearableItem extends BlockItem implements WearableItem {
    public BaseWearableItem(Block block, Properties properties) {
        super(block, properties.useBlockDescriptionPrefix());
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        if (ModConfig.wearableLightBlocks) return EquipmentSlot.HEAD;
        else return EquipmentSlot.MAINHAND;
    }
}
