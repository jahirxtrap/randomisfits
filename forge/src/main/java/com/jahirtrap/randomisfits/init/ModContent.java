package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;

public class ModContent {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registry.BLOCK_REGISTRY, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registry.ITEM_REGISTRY, MODID);
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registry.PAINTING_VARIANT_REGISTRY, MODID);

    public static final RegistryObject<Item> INVISIBLE_HELMET = registerItem("invisible_helmet", () -> new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_CHESTPLATE = registerItem("invisible_chestplate", () -> new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_LEGGINGS = registerItem("invisible_leggings", () -> new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_BOOTS = registerItem("invisible_boots", () -> new BaseArmorItem(ModMaterials.INVISIBLE, EquipmentSlot.FEET, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_HELMET = registerItem("reinforced_invisible_helmet", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_CHESTPLATE = registerItem("reinforced_invisible_chestplate", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.CHEST, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_LEGGINGS = registerItem("reinforced_invisible_leggings", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.LEGS, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_BOOTS = registerItem("reinforced_invisible_boots", () -> new BaseArmorItem(ModMaterials.REINFORCED_INVISIBLE, EquipmentSlot.FEET, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> IRON_MULTITOOL = registerItem("iron_multitool", () -> new BaseMultitoolItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_MULTITOOL = registerItem("diamond_multitool", () -> new BaseMultitoolItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_MULTITOOL = registerItem("netherite_multitool", () -> new BaseMultitoolItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IRON_HAMMER = registerItem("iron_hammer", () -> new BaseHammerItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HAMMER = registerItem("diamond_hammer", () -> new BaseHammerItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_HAMMER = registerItem("netherite_hammer", () -> new BaseHammerItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IRON_EXCAVATOR = registerItem("iron_excavator", () -> new BaseExcavatorItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_EXCAVATOR = registerItem("diamond_excavator", () -> new BaseExcavatorItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_EXCAVATOR = registerItem("netherite_excavator", () -> new BaseExcavatorItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> REPAIR_KIT = registerItem("repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.kitRepairAmount));
    public static final RegistryObject<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.diamondKitRepairAmount));
    public static final RegistryObject<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", () -> new BaseRepairKitItem(new Item.Properties().fireResistant(), ModConfig.netheriteKitRepairAmount));
    public static final RegistryObject<Block> LAMP_BLOCK = registerBlock("lamp", BaseLampBlock::new);
    public static final RegistryObject<Item> LAMP = registerItem("lamp", () -> new BaseWearableItem(LAMP_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", BaseLampBlock::new);
    public static final RegistryObject<Item> NETHERITE_LAMP = registerItem("netherite_lamp", () -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<PaintingVariant> MISFIT_PAINTING = registerPainting("misfit", () -> new PaintingVariant(16, 16));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties properties) {
        var block = registerBlock(name, supplier);
        registerItem(name, () -> new BlockItem(block.get(), properties.tab(TAB_RANDOMISFITS)));
        return block;
    }

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
        return BLOCKS.register(name, supplier);
    }

    public static RegistryObject<Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static RegistryObject<PaintingVariant> registerPainting(String name, Supplier<PaintingVariant> supplier) {
        return PAINTINGS.register(name, supplier);
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        PAINTINGS.register(bus);
    }
}