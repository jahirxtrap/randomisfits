package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final HashMap<ItemLike, Integer> FUEL_ITEMS = new HashMap<>();

    public static final Item ZURITE_INGOT = registerItem("zurite_ingot", new Item(new Item.Properties().fireResistant()));
    public static final Block ZURITE_BLOCK = registerBlock("zurite_block", new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.NETHERITE_BLOCK)), new Item.Properties().fireResistant());
    public static final Item ZURITE_UPGRADE_SMITHING_TEMPLATE = registerItem("zurite_upgrade_smithing_template", BaseSmithingTemplateItem.createUpgradeTemplate("zurite"));
    public static final List<Item> ZURITE_TOOLS = registerTools("zurite", ModTiers.ZURITE, new float[]{5f, -3f, -4f, 0f}, new Item.Properties().fireResistant());
    public static final List<Item> ZURITE_ARMOR = registerArmor(ModMaterials.ZURITE, new Item.Properties().fireResistant());
    public static final List<Item> INVISIBLE_ARMOR = registerArmor(ModMaterials.INVISIBLE, new Item.Properties());
    public static final List<Item> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.REINFORCED_INVISIBLE, new Item.Properties());
    public static final Item HANDLE = registerItem("handle", new Item(new Item.Properties()));
    public static final Item IRON_MULTITOOL = registerItem("iron_multitool", new BaseMultitoolItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_MULTITOOL = registerItem("diamond_multitool", new BaseMultitoolItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_MULTITOOL = registerItem("netherite_multitool", new BaseMultitoolItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item ZURITE_MULTITOOL = registerItem("zurite_multitool", new BaseMultitoolItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new BaseHammerItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer", new BaseHammerItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer", new BaseHammerItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item ZURITE_HAMMER = registerItem("zurite_hammer", new BaseHammerItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final Item IRON_LUMBERAXE = registerItem("iron_lumberaxe", new BaseLumberaxeItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_LUMBERAXE = registerItem("diamond_lumberaxe", new BaseLumberaxeItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_LUMBERAXE = registerItem("netherite_lumberaxe", new BaseLumberaxeItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item ZURITE_LUMBERAXE = registerItem("zurite_lumberaxe", new BaseLumberaxeItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final Item IRON_EXCAVATOR = registerItem("iron_excavator", new BaseExcavatorItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final Item DIAMOND_EXCAVATOR = registerItem("diamond_excavator", new BaseExcavatorItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final Item NETHERITE_EXCAVATOR = registerItem("netherite_excavator", new BaseExcavatorItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final Item ZURITE_EXCAVATOR = registerItem("zurite_excavator", new BaseExcavatorItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final Item GLASS_CUTTER = registerItem("glass_cutter", new BaseGlassCutterItem(Tiers.IRON, new Item.Properties()));
    public static final Item DIAMOND_GLASS_CUTTER = registerItem("diamond_glass_cutter", new BaseGlassCutterItem(Tiers.DIAMOND, new Item.Properties()));
    public static final Item NETHERITE_GLASS_CUTTER = registerItem("netherite_glass_cutter", new BaseGlassCutterItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final Item ZURITE_GLASS_CUTTER = registerItem("zurite_glass_cutter", new BaseGlassCutterItem(ModTiers.ZURITE, new Item.Properties().fireResistant()));
    public static final Item REPAIR_KIT = registerItem("repair_kit", new BaseRepairKitItem(ModConfig.kitRepairAmount, new Item.Properties()));
    public static final Item DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", new BaseRepairKitItem(ModConfig.diamondKitRepairAmount, new Item.Properties()));
    public static final Item NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", new BaseRepairKitItem(ModConfig.netheriteKitRepairAmount, new Item.Properties().fireResistant()));
    public static final Item CRAFTING_PLATE = registerItem("crafting_plate", new CraftingPlateItem());
    public static final Item ENDER_BAG = registerItem("ender_bag", new EnderBagItem());
    public static final Item TRAVELER_RELIC_FRAGMENT = registerItem("traveler_relic_fragment", new TravelerRelicItem(true, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final Item TRAVELER_RELIC = registerItem("traveler_relic", new TravelerRelicItem(false, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final Item LINK_RELIC = registerItem("link_relic", new LinkRelicItem(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final Block ANCHOR_STONE = registerBlock("anchor_stone", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5f, 6f).sound(SoundType.LODESTONE).requiresCorrectToolForDrops()), new Item.Properties().fireResistant());
    public static final Block BULB_BLOCK = registerBlock("bulb", new BaseLightBlock(4, 2));
    public static final Item BULB = registerItem("bulb", new BaseWearableItem(BULB_BLOCK, new Item.Properties()));
    public static final Block LAMP_BLOCK = registerBlock("lamp", new BaseLightBlock(8, 2));
    public static final Item LAMP = registerItem("lamp", new BaseWearableItem(LAMP_BLOCK, new Item.Properties()));
    public static final Block NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", new BaseLightBlock(8, 2));
    public static final Item NETHERITE_LAMP = registerItem("netherite_lamp", new NetheriteLampItem(NETHERITE_LAMP_BLOCK, new Item.Properties()));
    public static final Block GLOW_CORE_BLOCK = registerBlock("glow_core", new BaseLightBlock(8, 8));
    public static final Item GLOW_CORE = registerItem("glow_core", new BaseWearableItem(GLOW_CORE_BLOCK, new Item.Properties()));
    public static final PaintingVariant MISFIT_PAINTING = registerPainting("misfit", new PaintingVariant(16, 16));

    private static Block registerBlock(String name, Block block, Item.Properties itemProp) {
        registerItem(name, new BlockItem(block, itemProp));
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name), block);
    }

    private static Item registerItem(String name, Item item) {
        var itemReg = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
        ITEMS.add(itemReg);
        return itemReg;
    }

    private static List<Item> registerTools(String name, Tier tier, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", new SwordItem(tier, 3, -2.4f, itemProp)),
                registerItem(name + "_pickaxe", new PickaxeItem(tier, 1, -2.8f, itemProp)),
                registerItem(name + "_axe", new AxeItem(tier, attr[0], attr[1], itemProp)),
                registerItem(name + "_shovel", new ShovelItem(tier, 1.5f, -3f, itemProp)),
                registerItem(name + "_hoe", new HoeItem(tier, (int) attr[2], attr[3], itemProp))
        );
    }

    private static List<Item> registerArmor(ArmorMaterial material, Item.Properties itemProp) {
        String name = material.getName().substring(material.getName().indexOf(ResourceLocation.NAMESPACE_SEPARATOR) + 1);
        return List.of(
                registerItem(name + "_helmet", new BaseArmorItem(material, Type.HELMET, itemProp)),
                registerItem(name + "_chestplate", new BaseArmorItem(material, Type.CHESTPLATE, itemProp)),
                registerItem(name + "_leggings", new BaseArmorItem(material, Type.LEGGINGS, itemProp)),
                registerItem(name + "_boots", new BaseArmorItem(material, Type.BOOTS, itemProp))
        );
    }

    private static PaintingVariant registerPainting(String name, PaintingVariant variant) {
        return Registry.register(BuiltInRegistries.PAINTING_VARIANT, new ResourceLocation(MODID, name), variant);
    }

    public static void init() {
        FUEL_ITEMS.put(HANDLE, 200);

        FUEL_ITEMS.forEach(FuelRegistry.INSTANCE::add);
    }
}
