package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final HashMap<ItemLike, Integer> FUEL_ITEMS = new HashMap<>();

    public static final List<Item> INVISIBLE_ARMOR = registerArmor(ModMaterials.INVISIBLE, 15, new Item.Properties());
    public static final List<Item> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.REINFORCED_INVISIBLE, 30, new Item.Properties());
    public static final Item HANDLE = registerItem("handle", new Item(new Item.Properties()));
    public static final List<Item> IRON_EXTRA_TOOLS = registerExtraTools("iron", Tiers.IRON, ModTiers.IRON_HARD, new Item.Properties());
    public static final List<Item> GOLDEN_EXTRA_TOOLS = registerExtraTools("golden", Tiers.GOLD, ModTiers.GOLD_HARD, new Item.Properties());
    public static final List<Item> DIAMOND_EXTRA_TOOLS = registerExtraTools("diamond", Tiers.DIAMOND, ModTiers.DIAMOND_HARD, new Item.Properties());
    public static final List<Item> NETHERITE_EXTRA_TOOLS = registerExtraTools("netherite", Tiers.NETHERITE, ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant());
    public static final List<Item> ENDERITE_EXTRA_TOOLS = registerExtraTools("enderite", ModTiers.ENDERITE, ModTiers.ENDERITE_HARD, new Item.Properties().fireResistant());
    public static final List<Item> STEEL_EXTRA_TOOLS = registerExtraTools("steel", ModTiers.STEEL, ModTiers.STEEL_HARD, new Item.Properties());
    public static final List<Item> BRONZE_EXTRA_TOOLS = registerExtraTools("bronze", ModTiers.BRONZE, ModTiers.BRONZE_HARD, new Item.Properties());
    public static final List<Item> ZURITE_EXTRA_TOOLS = registerExtraTools("zurite", ModTiers.ZURITE, ModTiers.ZURITE_HARD, new Item.Properties().fireResistant());
    public static final Item IRON_REPAIR_KIT = registerItem("iron_repair_kit", new BaseRepairKitItem(ModConfig.ironKitRepairAmount, new Item.Properties()));
    public static final Item DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", new BaseRepairKitItem(ModConfig.diamondKitRepairAmount, new Item.Properties()));
    public static final Item NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", new BaseRepairKitItem(ModConfig.netheriteKitRepairAmount, new Item.Properties().fireResistant()));
    public static final Item CRAFTING_PLATE = registerItem("crafting_plate", new CraftingPlateItem());
    public static final Item ENDER_BAG = registerItem("ender_bag", new EnderBagItem());
    public static final Block BULB_BLOCK = registerBlock("bulb", new BaseLightBlock(4, 2));
    public static final Item BULB = registerItem("bulb", new BaseWearableItem(BULB_BLOCK, new Item.Properties()));
    public static final Block LAMP_BLOCK = registerBlock("lamp", new BaseLightBlock(8, 2));
    public static final Item LAMP = registerItem("lamp", new BaseWearableItem(LAMP_BLOCK, new Item.Properties()));
    public static final Block NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", new BaseLightBlock(8, 2));
    public static final Item NETHERITE_LAMP = registerItem("netherite_lamp", new NetheriteLampItem(NETHERITE_LAMP_BLOCK, new Item.Properties()));
    public static final Block GLOW_CORE_BLOCK = registerBlock("glow_core", new BaseLightBlock(8, 8));
    public static final Item GLOW_CORE = registerItem("glow_core", new BaseWearableItem(GLOW_CORE_BLOCK, new Item.Properties()));

    private static Block registerBlock(String name, Block block, Item.Properties itemProp) {
        registerItem(name, new BlockItem(block, itemProp));
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, name), block);
    }

    private static Item registerItem(String name, Item item) {
        var itemReg = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name), item);
        ITEMS.add(itemReg);
        return itemReg;
    }

    private static List<Item> registerTools(String name, Tier tier, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", new SwordItem(tier, itemProp.attributes(SwordItem.createAttributes(tier, 3, -2.4f)))),
                registerItem(name + "_pickaxe", new PickaxeItem(tier, itemProp.attributes(PickaxeItem.createAttributes(tier, 1f, -2.8f)))),
                registerItem(name + "_axe", new AxeItem(tier, itemProp.attributes(AxeItem.createAttributes(tier, attr[0], attr[1])))),
                registerItem(name + "_shovel", new ShovelItem(tier, itemProp.attributes(ShovelItem.createAttributes(tier, 1.5f, -3f)))),
                registerItem(name + "_hoe", new HoeItem(tier, itemProp.attributes(HoeItem.createAttributes(tier, attr[2], attr[3]))))
        );
    }

    private static List<Item> registerExtraTools(String name, Tier tier, Tier tierHard, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_multitool", new BaseMultitoolItem(tierHard, itemProp)),
                registerItem(name + "_hammer", new BaseHammerItem(tierHard, itemProp)),
                registerItem(name + "_lumberaxe", new BaseLumberaxeItem(tierHard, itemProp)),
                registerItem(name + "_excavator", new BaseExcavatorItem(tierHard, itemProp)),
                registerItem(name + "_glass_cutter", new BaseGlassCutterItem(tier, itemProp))
        );
    }

    private static List<Item> registerArmor(Holder<ArmorMaterial> material, int durabilityMultiplier, Item.Properties itemProp) {
        String name = material.getRegisteredName().substring(material.getRegisteredName().indexOf(ResourceLocation.NAMESPACE_SEPARATOR) + 1);
        return List.of(
                registerItem(name + "_helmet", new BaseArmorItem(material, Type.HELMET, durabilityMultiplier, itemProp)),
                registerItem(name + "_chestplate", new BaseArmorItem(material, Type.CHESTPLATE, durabilityMultiplier, itemProp)),
                registerItem(name + "_leggings", new BaseArmorItem(material, Type.LEGGINGS, durabilityMultiplier, itemProp)),
                registerItem(name + "_boots", new BaseArmorItem(material, Type.BOOTS, durabilityMultiplier, itemProp))
        );
    }

    public static void init() {
        FUEL_ITEMS.put(HANDLE, 200);

        FUEL_ITEMS.forEach(FuelRegistry.INSTANCE::add);
    }
}
