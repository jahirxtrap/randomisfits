package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.RandomisfitsModTab.TAB_RANDOMISFITS;

public class RandomisfitsModItems {
    public static final Item INVISIBLE_HELMET = RegistryObject("invisible_helmet", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.HEAD, new Item.Properties()));
    public static final Item INVISIBLE_CHESTPLATE = RegistryObject("invisible_chestplate", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.CHEST, new Item.Properties()));
    public static final Item INVISIBLE_LEGGINGS = RegistryObject("invisible_leggings", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.LEGS, new Item.Properties()));
    public static final Item INVISIBLE_BOOTS = RegistryObject("invisible_boots", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.FEET, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_HELMET = RegistryObject("reinforced_invisible_helmet", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_CHESTPLATE = RegistryObject("reinforced_invisible_chestplate", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.CHEST, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_LEGGINGS = RegistryObject("reinforced_invisible_leggings", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.LEGS, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_BOOTS = RegistryObject("reinforced_invisible_boots", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.FEET, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item IRON_MULTITOOL = RegistryObject("iron_multitool", new BaseMultitoolItem(RandomisfitsTiers.IRON_MULTITOOL, new Item.Properties()));
    public static final Item DIAMOND_MULTITOOL = RegistryObject("diamond_multitool", new BaseMultitoolItem(RandomisfitsTiers.DIAMOND_MULTITOOL, new Item.Properties()));
    public static final Item NETHERITE_MULTITOOL = RegistryObject("netherite_multitool", new BaseMultitoolItem(RandomisfitsTiers.NETHERITE_MULTITOOL, new Item.Properties().fireResistant()));
    public static final Item REPAIR_KIT = RegistryObject("repair_kit", new BaseRepairKitItem(new Item.Properties(), RandomisfitsModConfig.kitRepairAmount));
    public static final Item DIAMOND_REPAIR_KIT = RegistryObject("diamond_repair_kit", new BaseRepairKitItem(new Item.Properties(), RandomisfitsModConfig.diamondKitRepairAmount));
    public static final Item NETHERITE_REPAIR_KIT = RegistryObject("netherite_repair_kit", new BaseRepairKitItem(new Item.Properties().fireResistant(), RandomisfitsModConfig.netheriteKitRepairAmount));
    public static final Item LAMP = RegistryObject("lamp", new BaseWearableItem(RandomisfitsModBlocks.LAMP, new Item.Properties()));
    public static final Item NETHERITE_LAMP = RegistryObject("netherite_lamp", new NetheriteLampItem(RandomisfitsModBlocks.NETHERITE_LAMP, new Item.Properties()));

    public static void init() {
    }

    public static Item RegistryObject(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), item);
    }

    public static Item block(String name, Block block) {
        return Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), new BlockItem(block, new Item.Properties().tab(TAB_RANDOMISFITS)));
    }
}
