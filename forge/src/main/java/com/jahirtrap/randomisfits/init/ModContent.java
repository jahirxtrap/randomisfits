package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);
    public static final HashMap<RegistryObject<? extends ItemLike>, Integer> FUEL_ITEMS = new HashMap<>();

    public static final List<RegistryObject<Item>> INVISIBLE_ARMOR = registerArmor(ModMaterials.Armor.INVISIBLE, new Item.Properties());
    public static final List<RegistryObject<Item>> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.Armor.REINFORCED_INVISIBLE, new Item.Properties());
    public static final RegistryObject<Item> HANDLE = registerItem("handle", Item::new, new Item.Properties());
    public static final List<RegistryObject<Item>> IRON_EXTRA_TOOLS = registerExtraTools("iron", ToolMaterial.IRON, ModMaterials.Tool.IRON_HARD, new Item.Properties());
    public static final List<RegistryObject<Item>> GOLDEN_EXTRA_TOOLS = registerExtraTools("golden", ToolMaterial.GOLD, ModMaterials.Tool.GOLD_HARD, new Item.Properties());
    public static final List<RegistryObject<Item>> DIAMOND_EXTRA_TOOLS = registerExtraTools("diamond", ToolMaterial.DIAMOND, ModMaterials.Tool.DIAMOND_HARD, new Item.Properties());
    public static final List<RegistryObject<Item>> NETHERITE_EXTRA_TOOLS = registerExtraTools("netherite", ToolMaterial.NETHERITE, ModMaterials.Tool.NETHERITE_HARD, new Item.Properties().fireResistant());
    public static final List<RegistryObject<Item>> ENDERITE_EXTRA_TOOLS = registerExtraTools("enderite", ModMaterials.Tool.ENDERITE, ModMaterials.Tool.ENDERITE_HARD, new Item.Properties().fireResistant());
    public static final List<RegistryObject<Item>> STEEL_EXTRA_TOOLS = registerExtraTools("steel", ModMaterials.Tool.STEEL, ModMaterials.Tool.STEEL_HARD, new Item.Properties());
    public static final List<RegistryObject<Item>> BRONZE_EXTRA_TOOLS = registerExtraTools("bronze", ModMaterials.Tool.BRONZE, ModMaterials.Tool.BRONZE_HARD, new Item.Properties());
    public static final List<RegistryObject<Item>> ZURITE_EXTRA_TOOLS = registerExtraTools("zurite", ModMaterials.Tool.ZURITE, ModMaterials.Tool.ZURITE_HARD, new Item.Properties().fireResistant());
    public static final RegistryObject<Item> IRON_REPAIR_KIT = registerItem("iron_repair_kit", (p) -> new BaseRepairKitItem(ModConfig.ironKitRepairAmount, p), new Item.Properties());
    public static final RegistryObject<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", (p) -> new BaseRepairKitItem(ModConfig.diamondKitRepairAmount, p), new Item.Properties());
    public static final RegistryObject<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", (p) -> new BaseRepairKitItem(ModConfig.netheriteKitRepairAmount, p), new Item.Properties().fireResistant());
    public static final RegistryObject<Item> CRAFTING_PLATE = registerItem("crafting_plate", CraftingPlateItem::new, new Item.Properties());
    public static final RegistryObject<Item> ENDER_BAG = registerItem("ender_bag", EnderBagItem::new, new Item.Properties());
    public static final RegistryObject<Block> BULB_BLOCK = registerBlock("bulb", (p) -> new BaseLightBlock(4, 2, p), BlockBehaviour.Properties.of());
    public static final RegistryObject<Item> BULB = registerItem("bulb", (p) -> new BaseWearableItem(BULB_BLOCK.get(), p), new Item.Properties());
    public static final RegistryObject<Block> LAMP_BLOCK = registerBlock("lamp", (p) -> new BaseLightBlock(8, 2, p), BlockBehaviour.Properties.of());
    public static final RegistryObject<Item> LAMP = registerItem("lamp", (p) -> new BaseWearableItem(LAMP_BLOCK.get(), p), new Item.Properties());
    public static final RegistryObject<Block> NETHERITE_LAMP_BLOCK = registerBlock("netherite_lamp", (p) -> new BaseLightBlock(8, 2, p), BlockBehaviour.Properties.of());
    public static final RegistryObject<Item> NETHERITE_LAMP = registerItem("netherite_lamp", (p) -> new NetheriteLampItem(NETHERITE_LAMP_BLOCK.get(), p), new Item.Properties());
    public static final RegistryObject<Block> GLOW_CORE_BLOCK = registerBlock("glow_core", (p) -> new BaseLightBlock(8, 8, p), BlockBehaviour.Properties.of());
    public static final RegistryObject<Item> GLOW_CORE = registerItem("glow_core", (p) -> new BaseWearableItem(GLOW_CORE_BLOCK.get(), p), new Item.Properties());

    private static RegistryObject<Block> registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockProp, Item.Properties itemProp) {
        var blockReg = registerBlock(name, function, blockProp);
        registerItem(name, (p) -> new BlockItem(blockReg.get(), p), itemProp.useBlockDescriptionPrefix());
        return blockReg;
    }

    private static RegistryObject<Block> registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties blockProp) {
        return BLOCKS.register(name, () -> function.apply(blockProp.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, name)))));
    }

    private static RegistryObject<Item> registerItem(String name, Function<Item.Properties, Item> function, Item.Properties itemProp) {
        return ITEMS.register(name, () -> function.apply(itemProp.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name)))));
    }

    private static List<RegistryObject<Item>> registerTools(String name, ToolMaterial material, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", (p) -> new SwordItem(material, 3f, -2.4f, p), itemProp),
                registerItem(name + "_pickaxe", (p) -> new PickaxeItem(material, 1f, -2.8f, p), itemProp),
                registerItem(name + "_axe", (p) -> new AxeItem(material, attr[0], attr[1], p), itemProp),
                registerItem(name + "_shovel", (p) -> new ShovelItem(material, 1.5f, -3f, p), itemProp),
                registerItem(name + "_hoe", (p) -> new HoeItem(material, attr[2], attr[3], p), itemProp)
        );
    }

    private static List<RegistryObject<Item>> registerExtraTools(String name, ToolMaterial material, ToolMaterial materialHard, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_multitool", (p) -> new BaseMultitoolItem(materialHard, p), itemProp),
                registerItem(name + "_hammer", (p) -> new BaseHammerItem(materialHard, p), itemProp),
                registerItem(name + "_lumberaxe", (p) -> new BaseLumberaxeItem(materialHard, p), itemProp),
                registerItem(name + "_excavator", (p) -> new BaseExcavatorItem(materialHard, p), itemProp),
                registerItem(name + "_glass_cutter", (p) -> new BaseGlassCutterItem(material, p), itemProp)
        );
    }

    private static List<RegistryObject<Item>> registerArmor(ArmorMaterial material, Item.Properties itemProp) {
        String name = material.modelId().getPath();
        return List.of(
                registerItem(name + "_helmet", (p) -> new ArmorItem(material, ArmorType.HELMET, p), itemProp),
                registerItem(name + "_chestplate", (p) -> new ArmorItem(material, ArmorType.CHESTPLATE, p), itemProp),
                registerItem(name + "_leggings", (p) -> new ArmorItem(material, ArmorType.LEGGINGS, p), itemProp),
                registerItem(name + "_boots", (p) -> new ArmorItem(material, ArmorType.BOOTS, p), itemProp)
        );
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);

        FUEL_ITEMS.put(HANDLE, 200);

        MinecraftForge.EVENT_BUS.addListener((FurnaceFuelBurnTimeEvent event) -> FUEL_ITEMS.forEach((item, burnTime) -> {
            if (item.get() == event.getItemStack().getItem()) event.setBurnTime(burnTime);
        }));
    }
}
