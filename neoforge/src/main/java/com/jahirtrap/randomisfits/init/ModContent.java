package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> INVISIBLE_HELMET = registerItem("invisible_helmet", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.HELMET, 15, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_CHESTPLATE = registerItem("invisible_chestplate", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.CHESTPLATE, 15, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_LEGGINGS = registerItem("invisible_leggings", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.LEGGINGS, 15, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_BOOTS = registerItem("invisible_boots", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.BOOTS, 15, new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_HELMET = registerItem("reinforced_invisible_helmet", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.HELMET, 30, new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_CHESTPLATE = registerItem("reinforced_invisible_chestplate", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.CHESTPLATE, 30, new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_LEGGINGS = registerItem("reinforced_invisible_leggings", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.LEGGINGS, 30, new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_BOOTS = registerItem("reinforced_invisible_boots", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.BOOTS, 30, new Item.Properties()));
    public static final DeferredItem<Item> HANDLE = registerItem("handle", () -> new BaseFuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> IRON_MULTITOOL = registerItem("iron_multitool", () -> new BaseMultitoolItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_MULTITOOL = registerItem("diamond_multitool", () -> new BaseMultitoolItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_MULTITOOL = registerItem("netherite_multitool", () -> new BaseMultitoolItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> IRON_HAMMER = registerItem("iron_hammer", () -> new BaseHammerItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_HAMMER = registerItem("diamond_hammer", () -> new BaseHammerItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_HAMMER = registerItem("netherite_hammer", () -> new BaseHammerItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> IRON_LUMBERAXE = registerItem("iron_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_LUMBERAXE = registerItem("diamond_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_LUMBERAXE = registerItem("netherite_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> IRON_EXCAVATOR = registerItem("iron_excavator", () -> new BaseExcavatorItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_EXCAVATOR = registerItem("diamond_excavator", () -> new BaseExcavatorItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_EXCAVATOR = registerItem("netherite_excavator", () -> new BaseExcavatorItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> GLASS_CUTTER = registerItem("glass_cutter", () -> new BaseGlassCutterItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_GLASS_CUTTER = registerItem("diamond_glass_cutter", () -> new BaseGlassCutterItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_GLASS_CUTTER = registerItem("netherite_glass_cutter", () -> new BaseGlassCutterItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> REPAIR_KIT = registerItem("repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.kitRepairAmount));
    public static final DeferredItem<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.diamondKitRepairAmount));
    public static final DeferredItem<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", () -> new BaseRepairKitItem(new Item.Properties().fireResistant(), ModConfig.netheriteKitRepairAmount));
    public static final DeferredItem<Item> CRAFTING_PLATE = registerItem("crafting_plate", CraftingPlateItem::new);
    public static final DeferredItem<Item> ENDER_BAG = registerItem("ender_bag", EnderBagItem::new);
    public static final DeferredBlock<Block> BULB_BLOCK = registerBlock("bulb", () -> new BaseLightBlock(4, 2));
    public static final DeferredItem<Item> BULB = registerItem("bulb", () -> new BaseWearableItem(BULB_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> LAMP_BLOCK = registerBlock("lamp", () -> new BaseLightBlock(8, 2));
    public static final DeferredItem<Item> LAMP = registerItem("lamp", () -> new BaseWearableItem(LAMP_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", () -> new BaseLightBlock(8, 2));
    public static final DeferredItem<Item> NETHERITE_LAMP = registerItem("netherite_lamp", () -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> GLOW_CORE_BLOCK = registerBlock("glow_core", () -> new BaseLightBlock(8, 8));
    public static final DeferredItem<Item> GLOW_CORE = registerItem("glow_core", () -> new BaseWearableItem(GLOW_CORE_BLOCK.get(), new Item.Properties()));

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties properties) {
        var Block = registerBlock(name, supplier);
        registerItem(name, () -> new BlockItem(Block.get(), properties));
        return Block;
    }

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier) {
        return BLOCKS.register(name, supplier);
    }

    public static DeferredItem<Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}
