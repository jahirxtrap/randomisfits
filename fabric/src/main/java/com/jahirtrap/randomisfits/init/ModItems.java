package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModItems {
    public static final Item INVISIBLE_HELMET = registerItem("invisible_helmet", new BaseArmorItem(ModMaterials.INVISIBLE, Type.HELMET, 15, new Item.Properties()));
    public static final Item INVISIBLE_CHESTPLATE = registerItem("invisible_chestplate", new BaseArmorItem(ModMaterials.INVISIBLE, Type.CHESTPLATE, 15, new Item.Properties()));
    public static final Item INVISIBLE_LEGGINGS = registerItem("invisible_leggings", new BaseArmorItem(ModMaterials.INVISIBLE, Type.LEGGINGS, 15, new Item.Properties()));
    public static final Item INVISIBLE_BOOTS = registerItem("invisible_boots", new BaseArmorItem(ModMaterials.INVISIBLE, Type.BOOTS, 15, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_HELMET = registerItem("reinforced_invisible_helmet", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.HELMET, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_CHESTPLATE = registerItem("reinforced_invisible_chestplate", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.CHESTPLATE, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_LEGGINGS = registerItem("reinforced_invisible_leggings", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.LEGGINGS, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_BOOTS = registerItem("reinforced_invisible_boots", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.BOOTS, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item IRON_MULTITOOL = registerItem("iron_multitool", new BaseMultitoolItem(ModTiers.IRON_MULTITOOL, new Item.Properties()));
    public static final Item DIAMOND_MULTITOOL = registerItem("diamond_multitool", new BaseMultitoolItem(ModTiers.DIAMOND_MULTITOOL, new Item.Properties()));
    public static final Item NETHERITE_MULTITOOL = registerItem("netherite_multitool", new BaseMultitoolItem(ModTiers.NETHERITE_MULTITOOL, new Item.Properties().fireResistant()));
    public static final Item REPAIR_KIT = registerItem("repair_kit", new BaseRepairKitItem(new Item.Properties(), ModConfig.kitRepairAmount));
    public static final Item DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", new BaseRepairKitItem(new Item.Properties(), ModConfig.diamondKitRepairAmount));
    public static final Item NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", new BaseRepairKitItem(new Item.Properties().fireResistant(), ModConfig.netheriteKitRepairAmount));
    public static final Block LAMP_BLOCK = registerBlock("lamp", new BaseLampBlock());
    public static final Item LAMP = registerItem("lamp", new BaseWearableItem(LAMP_BLOCK, new Item.Properties()));
    public static final Block NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", new BaseLampBlock());
    public static final Item NETHERITE_LAMP = registerItem("netherite_lamp", new NetheriteLampItem(NETHERITE_LAMP_BLOCK, new Item.Properties()));

    public static Block registerBlock(String name, Block block, Item.Properties properties) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), new BlockItem(block, properties));
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name), block);
    }

    public static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name), block);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
    }

    public static void init() {
    }
}
