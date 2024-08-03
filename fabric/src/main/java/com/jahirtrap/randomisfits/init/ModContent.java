package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;

public class ModContent {
    public static final Item INVISIBLE_HELMET = registerItem("invisible_helmet", new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.HEAD, new Item.Properties()));
    public static final Item INVISIBLE_CHESTPLATE = registerItem("invisible_chestplate", new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.CHEST, new Item.Properties()));
    public static final Item INVISIBLE_LEGGINGS = registerItem("invisible_leggings", new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.LEGS, new Item.Properties()));
    public static final Item INVISIBLE_BOOTS = registerItem("invisible_boots", new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.FEET, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_HELMET = registerItem("reinforced_invisible_helmet", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.HEAD, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_CHESTPLATE = registerItem("reinforced_invisible_chestplate", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.CHEST, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_LEGGINGS = registerItem("reinforced_invisible_leggings", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.LEGS, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_BOOTS = registerItem("reinforced_invisible_boots", new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.FEET, new Item.Properties()));
    public static final Item IRON_MULTITOOL = registerItem("iron_multitool", new BaseMultitoolItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_MULTITOOL = registerItem("diamond_multitool", new BaseMultitoolItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_MULTITOOL = registerItem("netherite_multitool", new BaseMultitoolItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new BaseHammerItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer", new BaseHammerItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer", new BaseHammerItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item IRON_LUMBERAXE = registerItem("iron_lumberaxe", new BaseLumberaxeItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_LUMBERAXE = registerItem("diamond_lumberaxe", new BaseLumberaxeItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_LUMBERAXE = registerItem("netherite_lumberaxe", new BaseLumberaxeItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item IRON_EXCAVATOR = registerItem("iron_excavator", new BaseExcavatorItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_EXCAVATOR = registerItem("diamond_excavator", new BaseExcavatorItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_EXCAVATOR = registerItem("netherite_excavator", new BaseExcavatorItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item REPAIR_KIT = registerItem("repair_kit", new BaseRepairKitItem(new Item.Properties(), ModConfig.kitRepairAmount));
    public static final Item DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", new BaseRepairKitItem(new Item.Properties(), ModConfig.diamondKitRepairAmount));
    public static final Item NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", new BaseRepairKitItem(new Item.Properties().fireResistant(), ModConfig.netheriteKitRepairAmount));
    public static final Item ENDER_BAG = registerItem("ender_bag", new EnderBagItem());
    public static final Block LAMP_BLOCK = registerBlock("lamp", new BaseLampBlock());
    public static final Item LAMP = registerItem("lamp", new BaseWearableItem(LAMP_BLOCK, new Item.Properties()));
    public static final Block NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", new BaseLampBlock());
    public static final Item NETHERITE_LAMP = registerItem("netherite_lamp", new NetheriteLampItem(NETHERITE_LAMP_BLOCK, new Item.Properties()));
    public static final Motive MISFIT_PAINTING = registerPainting("misfit", new Motive(16, 16));

    public static Block registerBlock(String name, Block block, Item.Properties properties) {
        registerItem(name, new BlockItem(block, properties.tab(TAB_RANDOMISFITS)));
        return registerBlock(name, block);
    }

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(MODID, name), block);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), item);
    }

    private static Motive registerPainting(String name, Motive motive) {
        return Registry.register(Registry.MOTIVE, new ResourceLocation(MODID, name), motive);
    }

    public static void init() {
    }
}
