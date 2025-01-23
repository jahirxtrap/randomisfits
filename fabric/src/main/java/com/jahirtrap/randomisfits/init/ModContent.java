package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;

public class ModContent {
    public static final HashMap<ItemLike, Integer> FUEL_ITEMS = new HashMap<>();

    public static final List<Item> INVISIBLE_ARMOR = registerArmor(ModMaterials.INVISIBLE, new Item.Properties());
    public static final List<Item> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.REINFORCED_INVISIBLE, new Item.Properties());
    public static final Item HANDLE = registerItem("handle", new BaseItem(new Item.Properties()));
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
    public static final Motive MISFIT_PAINTING = registerPainting("misfit", new Motive(16, 16));

    private static Block registerBlock(String name, Block block, Item.Properties itemProp) {
        registerItem(name, new BlockItem(block, itemProp.tab(TAB_RANDOMISFITS)));
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(MODID, name), block);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(MODID, name), item);
    }

    private static List<Item> registerTools(String name, Tier tier, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", new SwordItem(tier, 3, -2.4f, itemProp.tab(TAB_RANDOMISFITS))),
                registerItem(name + "_pickaxe", new PickaxeItem(tier, 1, -2.8f, itemProp.tab(TAB_RANDOMISFITS))),
                registerItem(name + "_axe", new AxeItem(tier, attr[0], attr[1], itemProp.tab(TAB_RANDOMISFITS))),
                registerItem(name + "_shovel", new ShovelItem(tier, 1.5f, -3f, itemProp.tab(TAB_RANDOMISFITS))),
                registerItem(name + "_hoe", new HoeItem(tier, (int) attr[2], attr[3], itemProp.tab(TAB_RANDOMISFITS)))
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

    private static List<Item> registerArmor(ArmorMaterial material, Item.Properties itemProp) {
        String name = material.getName().substring(material.getName().indexOf(ResourceLocation.NAMESPACE_SEPARATOR) + 1);
        return List.of(
                registerItem(name + "_helmet", new BaseArmorItem(material, EquipmentSlot.HEAD, itemProp)),
                registerItem(name + "_chestplate", new BaseArmorItem(material, EquipmentSlot.CHEST, itemProp)),
                registerItem(name + "_leggings", new BaseArmorItem(material, EquipmentSlot.LEGS, itemProp)),
                registerItem(name + "_boots", new BaseArmorItem(material, EquipmentSlot.FEET, itemProp))
        );
    }

    private static Motive registerPainting(String name, Motive motive) {
        return Registry.register(Registry.MOTIVE, new ResourceLocation(MODID, name), motive);
    }

    public static void init() {
        FUEL_ITEMS.put(HANDLE, 200);

        FUEL_ITEMS.forEach(FuelRegistry.INSTANCE::add);
    }
}
