package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModItems {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> INVISIBLE_HELMET = registerItem("invisible_helmet", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_CHESTPLATE = registerItem("invisible_chestplate", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_LEGGINGS = registerItem("invisible_leggings", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_BOOTS = registerItem("invisible_boots", () -> new BaseArmorItem(ModMaterials.INVISIBLE, Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_HELMET = registerItem("reinforced_invisible_helmet", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.HELMET, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_CHESTPLATE = registerItem("reinforced_invisible_chestplate", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_LEGGINGS = registerItem("reinforced_invisible_leggings", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_BOOTS = registerItem("reinforced_invisible_boots", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, Type.BOOTS, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> IRON_MULTITOOL = registerItem("iron_multitool", () -> new BaseMultitoolItem(ModTiers.IRON_MULTITOOL, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_MULTITOOL = registerItem("diamond_multitool", () -> new BaseMultitoolItem(ModTiers.DIAMOND_MULTITOOL, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_MULTITOOL = registerItem("netherite_multitool", () -> new BaseMultitoolItem(ModTiers.NETHERITE_MULTITOOL, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> REPAIR_KIT = registerItem("repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.kitRepairAmount));
    public static final DeferredItem<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.diamondKitRepairAmount));
    public static final DeferredItem<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", () -> new BaseRepairKitItem(new Item.Properties().fireResistant(), ModConfig.netheriteKitRepairAmount));
    public static final DeferredBlock<Block> LAMP_BLOCK = registerBlock("lamp", BaseLampBlock::new);
    public static final DeferredItem<Item> LAMP = registerItem("lamp", () -> new BaseWearableItem(LAMP_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", BaseLampBlock::new);
    public static final DeferredItem<Item> NETHERITE_LAMP = registerItem("netherite_lamp", () -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK.get(), new Item.Properties()));

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties properties) {
        var block = BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
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
