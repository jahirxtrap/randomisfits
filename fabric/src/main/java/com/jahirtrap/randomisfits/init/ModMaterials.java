package com.jahirtrap.randomisfits.init;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModMaterials {
    public interface Armor {
        ArmorMaterial ZURITE = new ArmorMaterial(31, createMap(new int[]{3, 6, 8, 3, 11}),
                16, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5f, 0.1f, ModTags.Items.REPAIRS_ZURITE_SET, ResourceLocation.fromNamespaceAndPath(MODID, "zurite"));
        ArmorMaterial INVISIBLE = new ArmorMaterial(15, createMap(new int[]{2, 5, 6, 2, 5}),
                9, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ConventionalItemTags.GLASS_BLOCKS_COLORLESS, ResourceLocation.fromNamespaceAndPath(MODID, "invisible"));
        ArmorMaterial REINFORCED_INVISIBLE = new ArmorMaterial(30, createMap(new int[]{3, 6, 8, 3, 11}),
                10, SoundEvents.ARMOR_EQUIP_GENERIC, 2f, 0f, ConventionalItemTags.GLASS_BLOCKS_COLORLESS, ResourceLocation.fromNamespaceAndPath(MODID, "reinforced_invisible"));

        private static EnumMap<ArmorType, Integer> createMap(int[] values) {
            EnumMap<ArmorType, Integer> enumMap = new EnumMap<>(ArmorType.class);
            for (int i = 0; i < values.length; i++) enumMap.put(ArmorType.values()[i], values[i]);
            return enumMap;
        }
    }

    public interface Tool {
        ToolMaterial ZURITE = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1320, 8.5f, 4f, 16, ModTags.Items.REPAIRS_ZURITE_SET);
        ToolMaterial IRON_HARD = copy(ToolMaterial.IRON, 2, 0);
        ToolMaterial DIAMOND_HARD = copy(ToolMaterial.DIAMOND, 2, 0);
        ToolMaterial NETHERITE_HARD = copy(ToolMaterial.NETHERITE, 2, 0);
        ToolMaterial ZURITE_HARD = copy(ZURITE, 2, 0);

        private static ToolMaterial copy(ToolMaterial material, int i, float j) {
            return new ToolMaterial(material.incorrectBlocksForDrops(), material.durability() * i, material.speed() + j, material.attackDamageBonus(), material.enchantmentValue(), material.repairItems());
        }
    }
}
