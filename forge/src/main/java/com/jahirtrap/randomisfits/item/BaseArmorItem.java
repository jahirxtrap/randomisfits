package com.jahirtrap.randomisfits.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import static com.jahirtrap.randomisfits.RandomisfitsModTab.TAB_RANDOMISFITS;

public class BaseArmorItem extends ArmorItem {
    public BaseArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties.tab(TAB_RANDOMISFITS));
    }
}
