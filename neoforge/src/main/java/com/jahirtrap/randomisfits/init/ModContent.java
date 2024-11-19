package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, MODID);

    public static final DeferredItem<Item> ZURITE_INGOT = registerItem("zurite_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredBlock<Block> ZURITE_BLOCK = registerBlock("zurite_block", () -> new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.NETHERITE_BLOCK)), new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ZURITE_UPGRADE_SMITHING_TEMPLATE = registerItem("zurite_upgrade_smithing_template", () -> BaseSmithingTemplateItem.createUpgradeTemplate("zurite"));
    public static final List<DeferredItem<Item>> ZURITE_TOOLS = registerTools("zurite", ModTiers.ZURITE, new float[]{5f, -3f, -4f, 0f}, new Item.Properties().fireResistant());
    public static final List<DeferredItem<Item>> ZURITE_ARMOR = registerArmor(ModMaterials.ZURITE, 31, new Item.Properties().fireResistant());
    public static final List<DeferredItem<Item>> INVISIBLE_ARMOR = registerArmor(ModMaterials.INVISIBLE, 15, new Item.Properties());
    public static final List<DeferredItem<Item>> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.REINFORCED_INVISIBLE, 30, new Item.Properties());
    public static final DeferredItem<Item> HANDLE = registerItem("handle", () -> new BaseFuelItem(200, new Item.Properties()));
    public static final DeferredItem<Item> IRON_MULTITOOL = registerItem("iron_multitool", () -> new BaseMultitoolItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_MULTITOOL = registerItem("diamond_multitool", () -> new BaseMultitoolItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_MULTITOOL = registerItem("netherite_multitool", () -> new BaseMultitoolItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ZURITE_MULTITOOL = registerItem("zurite_multitool", () -> new BaseMultitoolItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> IRON_HAMMER = registerItem("iron_hammer", () -> new BaseHammerItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_HAMMER = registerItem("diamond_hammer", () -> new BaseHammerItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_HAMMER = registerItem("netherite_hammer", () -> new BaseHammerItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ZURITE_HAMMER = registerItem("zurite_hammer", () -> new BaseHammerItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> IRON_LUMBERAXE = registerItem("iron_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_LUMBERAXE = registerItem("diamond_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_LUMBERAXE = registerItem("netherite_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ZURITE_LUMBERAXE = registerItem("zurite_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> IRON_EXCAVATOR = registerItem("iron_excavator", () -> new BaseExcavatorItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_EXCAVATOR = registerItem("diamond_excavator", () -> new BaseExcavatorItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_EXCAVATOR = registerItem("netherite_excavator", () -> new BaseExcavatorItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ZURITE_EXCAVATOR = registerItem("zurite_excavator", () -> new BaseExcavatorItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> GLASS_CUTTER = registerItem("glass_cutter", () -> new BaseGlassCutterItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_GLASS_CUTTER = registerItem("diamond_glass_cutter", () -> new BaseGlassCutterItem(Tiers.DIAMOND, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_GLASS_CUTTER = registerItem("netherite_glass_cutter", () -> new BaseGlassCutterItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ZURITE_GLASS_CUTTER = registerItem("zurite_glass_cutter", () -> new BaseGlassCutterItem(ModTiers.ZURITE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> REPAIR_KIT = registerItem("repair_kit", () -> new BaseRepairKitItem(ModConfig.kitRepairAmount, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", () -> new BaseRepairKitItem(ModConfig.diamondKitRepairAmount, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", () -> new BaseRepairKitItem(ModConfig.netheriteKitRepairAmount, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> CRAFTING_PLATE = registerItem("crafting_plate", CraftingPlateItem::new);
    public static final DeferredItem<Item> ENDER_BAG = registerItem("ender_bag", EnderBagItem::new);
    public static final DeferredItem<Item> TRAVELER_RELIC_FRAGMENT = registerItem("traveler_relic_fragment", () -> new TravelerRelicItem(true, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> TRAVELER_RELIC = registerItem("traveler_relic", () -> new TravelerRelicItem(false, new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> LINK_RELIC = registerItem("link_relic", () -> new LinkRelicItem(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final DeferredBlock<Block> ANCHOR_STONE = registerBlock("anchor_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5f, 6f).sound(SoundType.LODESTONE).requiresCorrectToolForDrops()), new Item.Properties().fireResistant());
    public static final DeferredBlock<Block> BULB_BLOCK = registerBlock("bulb", () -> new BaseLightBlock(4, 2));
    public static final DeferredItem<Item> BULB = registerItem("bulb", () -> new BaseWearableItem(BULB_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> LAMP_BLOCK = registerBlock("lamp", () -> new BaseLightBlock(8, 2));
    public static final DeferredItem<Item> LAMP = registerItem("lamp", () -> new BaseWearableItem(LAMP_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", () -> new BaseLightBlock(8, 2));
    public static final DeferredItem<Item> NETHERITE_LAMP = registerItem("netherite_lamp", () -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK.get(), new Item.Properties()));
    public static final DeferredBlock<Block> GLOW_CORE_BLOCK = registerBlock("glow_core", () -> new BaseLightBlock(8, 8));
    public static final DeferredItem<Item> GLOW_CORE = registerItem("glow_core", () -> new BaseWearableItem(GLOW_CORE_BLOCK.get(), new Item.Properties()));
    public static final Supplier<PaintingVariant> MISFIT_PAINTING = registerPainting("misfit", () -> new PaintingVariant(16, 16));

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties itemProp) {
        var blockReg = registerBlock(name, supplier);
        registerItem(name, () -> new BlockItem(blockReg.get(), itemProp));
        return blockReg;
    }

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier) {
        return BLOCKS.register(name, supplier);
    }

    public static DeferredItem<Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static List<DeferredItem<Item>> registerTools(String name, Tier tier, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", () -> new SwordItem(tier, itemProp.attributes(SwordItem.createAttributes(tier, 3, -2.4f)))),
                registerItem(name + "_pickaxe", () -> new PickaxeItem(tier, itemProp.attributes(PickaxeItem.createAttributes(tier, 1f, -2.8f)))),
                registerItem(name + "_axe", () -> new AxeItem(tier, itemProp.attributes(AxeItem.createAttributes(tier, attr[0], attr[1])))),
                registerItem(name + "_shovel", () -> new ShovelItem(tier, itemProp.attributes(ShovelItem.createAttributes(tier, 1.5f, -3f)))),
                registerItem(name + "_hoe", () -> new HoeItem(tier, itemProp.attributes(HoeItem.createAttributes(tier, attr[2], attr[3]))))
        );
    }

    private static List<DeferredItem<Item>> registerArmor(Holder<ArmorMaterial> material, int durabilityMultiplier, Item.Properties itemProp) {
        String name = material.getRegisteredName().substring(material.getRegisteredName().indexOf(ResourceLocation.NAMESPACE_SEPARATOR) + 1);
        return List.of(
                registerItem(name + "_helmet", () -> new BaseArmorItem(material, Type.HELMET, durabilityMultiplier, itemProp)),
                registerItem(name + "_chestplate", () -> new BaseArmorItem(material, Type.CHESTPLATE, durabilityMultiplier, itemProp)),
                registerItem(name + "_leggings", () -> new BaseArmorItem(material, Type.LEGGINGS, durabilityMultiplier, itemProp)),
                registerItem(name + "_boots", () -> new BaseArmorItem(material, Type.BOOTS, durabilityMultiplier, itemProp))
        );
    }

    private static Supplier<PaintingVariant> registerPainting(String name, Supplier<PaintingVariant> supplier) {
        return PAINTINGS.register(name, supplier);
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        PAINTINGS.register(bus);
    }
}
