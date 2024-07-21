package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.util.WearableItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;

public class BaseWearableItem extends BlockItem implements WearableItem {
    public BaseWearableItem(Block block, Properties properties) {
        super(block, properties.tab(TAB_RANDOMISFITS));
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
