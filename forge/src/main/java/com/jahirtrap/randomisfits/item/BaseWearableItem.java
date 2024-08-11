package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;

public class BaseWearableItem extends BlockItem {
    public BaseWearableItem(Block block, Properties properties) {
        super(block, properties.tab(TAB_RANDOMISFITS));
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        if (ModConfig.wearableLightBlocks) return EquipmentSlot.HEAD;
        else return EquipmentSlot.MAINHAND;
    }
}
