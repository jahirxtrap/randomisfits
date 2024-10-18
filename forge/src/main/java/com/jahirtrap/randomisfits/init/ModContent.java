package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);

    public static final RegistryObject<Item> ZURITE_INGOT = registerItem("zurite_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Block> ZURITE_BLOCK = registerBlock("zurite_block", () -> new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.NETHERITE_BLOCK)), new Item.Properties().fireResistant());
    public static final RegistryObject<Item> ZURITE_UPGRADE_SMITHING_TEMPLATE = registerItem("zurite_upgrade_smithing_template", () -> BaseSmithingTemplateItem.createUpgradeTemplate("zurite"));
    public static final List<RegistryObject<Item>> ZURITE_TOOLS = registerTools("zurite", ModTiers.ZURITE, new float[]{5f, -3f, -4f, 0f}, new Item.Properties().fireResistant());
    public static final List<RegistryObject<Item>> ZURITE_ARMOR = registerArmor(ModMaterials.ZURITE, 31, new Item.Properties().fireResistant());
    public static final List<RegistryObject<Item>> INVISIBLE_ARMOR = registerArmor(ModMaterials.INVISIBLE, 15, new Item.Properties());
    public static final List<RegistryObject<Item>> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.REINFORCED_INVISIBLE, 30, new Item.Properties());
    public static final RegistryObject<Item> HANDLE = registerItem("handle", () -> new BaseFuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> IRON_MULTITOOL = registerItem("iron_multitool", () -> new BaseMultitoolItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_MULTITOOL = registerItem("diamond_multitool", () -> new BaseMultitoolItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_MULTITOOL = registerItem("netherite_multitool", () -> new BaseMultitoolItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ZURITE_MULTITOOL = registerItem("zurite_multitool", () -> new BaseMultitoolItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IRON_HAMMER = registerItem("iron_hammer", () -> new BaseHammerItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HAMMER = registerItem("diamond_hammer", () -> new BaseHammerItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_HAMMER = registerItem("netherite_hammer", () -> new BaseHammerItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ZURITE_HAMMER = registerItem("zurite_hammer", () -> new BaseHammerItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IRON_LUMBERAXE = registerItem("iron_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_LUMBERAXE = registerItem("diamond_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_LUMBERAXE = registerItem("netherite_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ZURITE_LUMBERAXE = registerItem("zurite_lumberaxe", () -> new BaseLumberaxeItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IRON_EXCAVATOR = registerItem("iron_excavator", () -> new BaseExcavatorItem(ModTiers.IRON_HARD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_EXCAVATOR = registerItem("diamond_excavator", () -> new BaseExcavatorItem(ModTiers.DIAMOND_HARD, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_EXCAVATOR = registerItem("netherite_excavator", () -> new BaseExcavatorItem(ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ZURITE_EXCAVATOR = registerItem("zurite_excavator", () -> new BaseExcavatorItem(ModTiers.ZURITE_HARD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> GLASS_CUTTER = registerItem("glass_cutter", () -> new BaseGlassCutterItem(Tiers.IRON, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_GLASS_CUTTER = registerItem("diamond_glass_cutter", () -> new BaseGlassCutterItem(Tiers.DIAMOND, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_GLASS_CUTTER = registerItem("netherite_glass_cutter", () -> new BaseGlassCutterItem(Tiers.NETHERITE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ZURITE_GLASS_CUTTER = registerItem("zurite_glass_cutter", () -> new BaseGlassCutterItem(ModTiers.ZURITE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> REPAIR_KIT = registerItem("repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.kitRepairAmount));
    public static final RegistryObject<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), ModConfig.diamondKitRepairAmount));
    public static final RegistryObject<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", () -> new BaseRepairKitItem(new Item.Properties().fireResistant(), ModConfig.netheriteKitRepairAmount));
    public static final RegistryObject<Item> CRAFTING_PLATE = registerItem("crafting_plate", CraftingPlateItem::new);
    public static final RegistryObject<Item> ENDER_BAG = registerItem("ender_bag", EnderBagItem::new);
    public static final RegistryObject<Block> BULB_BLOCK = registerBlock("bulb", () -> new BaseLightBlock(4, 2));
    public static final RegistryObject<Item> BULB = registerItem("bulb", () -> new BaseWearableItem(BULB_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> LAMP_BLOCK = registerBlock("lamp", () -> new BaseLightBlock(8, 2));
    public static final RegistryObject<Item> LAMP = registerItem("lamp", () -> new BaseWearableItem(LAMP_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", () -> new BaseLightBlock(8, 2));
    public static final RegistryObject<Item> NETHERITE_LAMP = registerItem("netherite_lamp", () -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> GLOW_CORE_BLOCK = registerBlock("glow_core", () -> new BaseLightBlock(8, 8));
    public static final RegistryObject<Item> GLOW_CORE = registerItem("glow_core", () -> new BaseWearableItem(GLOW_CORE_BLOCK.get(), new Item.Properties()));

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties properties) {
        var blockReg = registerBlock(name, supplier);
        registerItem(name, () -> new BlockItem(blockReg.get(), properties));
        return blockReg;
    }

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
        return BLOCKS.register(name, supplier);
    }

    public static RegistryObject<Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static List<RegistryObject<Item>> registerTools(String name, Tier tier, float[] attr, Item.Properties properties) {
        return List.of(
                registerItem(name + "_sword", () -> new SwordItem(tier, properties.attributes(SwordItem.createAttributes(tier, 3, -2.4f)))),
                registerItem(name + "_pickaxe", () -> new PickaxeItem(tier, properties.attributes(PickaxeItem.createAttributes(tier, 1f, -2.8f)))),
                registerItem(name + "_axe", () -> new AxeItem(tier, properties.attributes(AxeItem.createAttributes(tier, attr[0], attr[1])))),
                registerItem(name + "_shovel", () -> new ShovelItem(tier, properties.attributes(ShovelItem.createAttributes(tier, 1.5f, -3f)))),
                registerItem(name + "_hoe", () -> new HoeItem(tier, properties.attributes(HoeItem.createAttributes(tier, attr[2], attr[3]))))
        );
    }

    private static List<RegistryObject<Item>> registerArmor(RegistryObject<ArmorMaterial> material, int durabilityMultiplier, Item.Properties properties) {
        String name = material.getId().getPath();
        return List.of(
                registerItem(name + "_helmet", () -> new BaseArmorItem(material.getHolder().get(), Type.HELMET, durabilityMultiplier, properties)),
                registerItem(name + "_chestplate", () -> new BaseArmorItem(material.getHolder().get(), Type.CHESTPLATE, durabilityMultiplier, properties)),
                registerItem(name + "_leggings", () -> new BaseArmorItem(material.getHolder().get(), Type.LEGGINGS, durabilityMultiplier, properties)),
                registerItem(name + "_boots", () -> new BaseArmorItem(material.getHolder().get(), Type.BOOTS, durabilityMultiplier, properties))
        );
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}
