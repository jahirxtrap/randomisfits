package com.jahirtrap.randomisfits.init;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModMaterials {
    public interface Armor {
        ArmorMaterial INVISIBLE = new ArmorMaterial(15, createMap(new int[]{2, 5, 6, 2, 5}),
                9, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ConventionalItemTags.GLASS_BLOCKS_COLORLESS, createAsset("invisible"));
        ArmorMaterial REINFORCED_INVISIBLE = new ArmorMaterial(30, createMap(new int[]{3, 6, 8, 3, 11}),
                10, SoundEvents.ARMOR_EQUIP_GENERIC, 2f, 0f, ConventionalItemTags.GLASS_BLOCKS_COLORLESS, createAsset("reinforced_invisible"));

        private static EnumMap<ArmorType, Integer> createMap(int[] values) {
            EnumMap<ArmorType, Integer> enumMap = new EnumMap<>(ArmorType.class);
            for (int i = 0; i < values.length; i++) enumMap.put(ArmorType.values()[i], values[i]);
            return enumMap;
        }

        private static ResourceKey<EquipmentAsset> createAsset(String name) {
            return ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(MODID, name));
        }
    }

    public interface Tool {
        ToolMaterial ZURITE = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1320, 8.5f, 4f, 16, ModTags.Items.ZURITE_INGOTS);
        ToolMaterial STEEL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 501, 6.5f, 2f, 14, ModTags.Items.STEEL_INGOTS);
        ToolMaterial BRONZE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 350, 7f, 2f, 16, ModTags.Items.BRONZE_INGOTS);
        ToolMaterial ENDERITE = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4096, 15f, 5f, 17, ModTags.Items.ENDERITE_INGOTS);
        ToolMaterial COPPER_HARD = copy(ToolMaterial.COPPER, 2, 0);
        ToolMaterial IRON_HARD = copy(ToolMaterial.IRON, 2, 0);
        ToolMaterial GOLD_HARD = copy(ToolMaterial.GOLD, 10, 0);
        ToolMaterial DIAMOND_HARD = copy(ToolMaterial.DIAMOND, 2, 0);
        ToolMaterial NETHERITE_HARD = copy(ToolMaterial.NETHERITE, 2, 0);
        ToolMaterial ZURITE_HARD = copy(ZURITE, 2, 0);
        ToolMaterial STEEL_HARD = copy(STEEL, 2, 0);
        ToolMaterial BRONZE_HARD = copy(BRONZE, 2, 0);
        ToolMaterial ENDERITE_HARD = copy(ENDERITE, 2, 0);

        private static ToolMaterial copy(ToolMaterial material, int i, float j) {
            return new ToolMaterial(material.incorrectBlocksForDrops(), material.durability() * i, material.speed() + j, material.attackDamageBonus(), material.enchantmentValue(), material.repairItems());
        }
    }
}
