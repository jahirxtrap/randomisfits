package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final HashMap<ItemLike, Integer> FUEL_ITEMS = new HashMap<>();

    public static final Item ZURITE_INGOT = registerItem("zurite_ingot", Item::new, new Item.Properties().fireResistant());
    public static final Block ZURITE_BLOCK = registerBlock("zurite_block", Block::new, BlockBehaviour.Properties.ofLegacyCopy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.COLOR_GRAY), new Item.Properties().fireResistant());
    public static final Item ZURITE_UPGRADE_SMITHING_TEMPLATE = registerItem("zurite_upgrade_smithing_template", (p) -> BaseSmithingTemplateItem.createUpgradeTemplate("zurite", p), new Item.Properties());
    public static final List<Item> ZURITE_TOOLS = registerTools("zurite", ModMaterials.Tool.ZURITE, new float[]{5f, -3f, -4f, 0f}, new Item.Properties().fireResistant());
    public static final List<Item> ZURITE_ARMOR = registerArmor(ModMaterials.Armor.ZURITE, new Item.Properties().fireResistant());
    public static final List<Item> INVISIBLE_ARMOR = registerArmor(ModMaterials.Armor.INVISIBLE, new Item.Properties());
    public static final List<Item> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.Armor.REINFORCED_INVISIBLE, new Item.Properties());
    public static final Item HANDLE = registerItem("handle", Item::new, new Item.Properties());
    public static final List<Item> IRON_EXTRA_TOOLS = registerExtraTools("iron", ToolMaterial.IRON, ModMaterials.Tool.IRON_HARD, new Item.Properties());
    public static final List<Item> GOLDEN_EXTRA_TOOLS = registerExtraTools("golden", ToolMaterial.GOLD, ModMaterials.Tool.GOLD_HARD, new Item.Properties());
    public static final List<Item> DIAMOND_EXTRA_TOOLS = registerExtraTools("diamond", ToolMaterial.DIAMOND, ModMaterials.Tool.DIAMOND_HARD, new Item.Properties());
    public static final List<Item> NETHERITE_EXTRA_TOOLS = registerExtraTools("netherite", ToolMaterial.NETHERITE, ModMaterials.Tool.NETHERITE_HARD, new Item.Properties().fireResistant());
    public static final List<Item> ENDERITE_EXTRA_TOOLS = registerExtraTools("enderite", ModMaterials.Tool.ENDERITE, ModMaterials.Tool.ENDERITE_HARD, new Item.Properties().fireResistant());
    public static final List<Item> STEEL_EXTRA_TOOLS = registerExtraTools("steel", ModMaterials.Tool.STEEL, ModMaterials.Tool.STEEL_HARD, new Item.Properties());
    public static final List<Item> BRONZE_EXTRA_TOOLS = registerExtraTools("bronze", ModMaterials.Tool.BRONZE, ModMaterials.Tool.BRONZE_HARD, new Item.Properties());
    public static final List<Item> ZURITE_EXTRA_TOOLS = registerExtraTools("zurite", ModMaterials.Tool.ZURITE, ModMaterials.Tool.ZURITE_HARD, new Item.Properties().fireResistant());
    public static final Item IRON_REPAIR_KIT = registerItem("iron_repair_kit", (p) -> new BaseRepairKitItem(ModConfig.ironKitRepairAmount, p), new Item.Properties());
    public static final Item DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", (p) -> new BaseRepairKitItem(ModConfig.diamondKitRepairAmount, p), new Item.Properties());
    public static final Item NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", (p) -> new BaseRepairKitItem(ModConfig.netheriteKitRepairAmount, p), new Item.Properties().fireResistant());
    public static final Item CRAFTING_PLATE = registerItem("crafting_plate", CraftingPlateItem::new, new Item.Properties());
    public static final Item ENDER_BAG = registerItem("ender_bag", EnderBagItem::new, new Item.Properties());
    public static final Item TRAVELER_RELIC_FRAGMENT = registerItem("traveler_relic_fragment", (p) -> new TravelerRelicItem(true, p), new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final Item TRAVELER_RELIC = registerItem("traveler_relic", (p) -> new TravelerRelicItem(false, p), new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final Item LINK_RELIC = registerItem("link_relic", LinkRelicItem::new, new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final Block ANCHOR_STONE = registerBlock("anchor_stone", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5f, 6f).sound(SoundType.LODESTONE).requiresCorrectToolForDrops(), new Item.Properties().fireResistant());
    public static final Block BULB_BLOCK = registerBlock("bulb", (p) -> new BaseLightBlock(4, 2, p), BlockBehaviour.Properties.of());
    public static final Item BULB = registerItem("bulb", (p) -> new BaseWearableItem(BULB_BLOCK, p), new Item.Properties());
    public static final Block LAMP_BLOCK = registerBlock("lamp", (p) -> new BaseLightBlock(8, 2, p), BlockBehaviour.Properties.of());
    public static final Item LAMP = registerItem("lamp", (p) -> new BaseWearableItem(LAMP_BLOCK, p), new Item.Properties());
    public static final Block NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", (p) -> new BaseLightBlock(8, 2, p), BlockBehaviour.Properties.of());
    public static final Item NETHERITE_LAMP = registerItem("netherite_lamp", (p) -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK, p), new Item.Properties());
    public static final Block GLOW_CORE_BLOCK = registerBlock("glow_core", (p) -> new BaseLightBlock(8, 8, p), BlockBehaviour.Properties.of());
    public static final Item GLOW_CORE = registerItem("glow_core", (p) -> new BaseWearableItem(GLOW_CORE_BLOCK, p), new Item.Properties());

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockProp, Item.Properties itemProp) {
        var blockReg = registerBlock(name, function, blockProp);
        registerItem(name, (p) -> new BlockItem(blockReg, p), itemProp.useBlockDescriptionPrefix());
        return blockReg;
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockProp) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, name)), function.apply(blockProp.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, name)))));
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function, Item.Properties itemProp) {
        var itemReg = Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name)), function.apply(itemProp.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name)))));
        ITEMS.add(itemReg);
        return itemReg;
    }

    private static List<Item> registerTools(String name, ToolMaterial material, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", (p) -> new SwordItem(material, 3f, -2.4f, p), itemProp),
                registerItem(name + "_pickaxe", (p) -> new PickaxeItem(material, 1f, -2.8f, p), itemProp),
                registerItem(name + "_axe", (p) -> new AxeItem(material, attr[0], attr[1], p), itemProp),
                registerItem(name + "_shovel", (p) -> new ShovelItem(material, 1.5f, -3f, p), itemProp),
                registerItem(name + "_hoe", (p) -> new HoeItem(material, attr[2], attr[3], p), itemProp)
        );
    }

    private static List<Item> registerExtraTools(String name, ToolMaterial material, ToolMaterial materialHard, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_multitool", (p) -> new BaseMultitoolItem(materialHard, p), itemProp),
                registerItem(name + "_hammer", (p) -> new BaseHammerItem(materialHard, p), itemProp),
                registerItem(name + "_lumberaxe", (p) -> new BaseLumberaxeItem(materialHard, p), itemProp),
                registerItem(name + "_excavator", (p) -> new BaseExcavatorItem(materialHard, p), itemProp),
                registerItem(name + "_glass_cutter", (p) -> new BaseGlassCutterItem(material, p), itemProp)
        );
    }

    private static List<Item> registerArmor(ArmorMaterial material, Item.Properties itemProp) {
        String name = material.modelId().getPath();
        return List.of(
                registerItem(name + "_helmet", (p) -> new ArmorItem(material, ArmorType.HELMET, p), itemProp),
                registerItem(name + "_chestplate", (p) -> new ArmorItem(material, ArmorType.CHESTPLATE, p), itemProp),
                registerItem(name + "_leggings", (p) -> new ArmorItem(material, ArmorType.LEGGINGS, p), itemProp),
                registerItem(name + "_boots", (p) -> new ArmorItem(material, ArmorType.BOOTS, p), itemProp)
        );
    }

    public static void init() {
        FUEL_ITEMS.put(HANDLE, 200);

        FuelRegistryEvents.BUILD.register((builder, context) -> FUEL_ITEMS.forEach(builder::add));
    }
}
