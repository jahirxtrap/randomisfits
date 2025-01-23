package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLightBlock;
import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModContent {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Registries.PAINTING_VARIANT, MODID);
    public static final HashMap<DeferredHolder<?, ? extends ItemLike>, Integer> FUEL_ITEMS = new HashMap<>();

    public static final List<DeferredItem<Item>> INVISIBLE_ARMOR = registerArmor(ModMaterials.INVISIBLE, new Item.Properties());
    public static final List<DeferredItem<Item>> REINFORCED_INVISIBLE_ARMOR = registerArmor(ModMaterials.REINFORCED_INVISIBLE, new Item.Properties());
    public static final DeferredItem<Item> HANDLE = registerItem("handle", () -> new Item(new Item.Properties()));
    public static final List<DeferredItem<Item>> IRON_EXTRA_TOOLS = registerExtraTools("iron", Tiers.IRON, ModTiers.IRON_HARD, new Item.Properties());
    public static final List<DeferredItem<Item>> GOLDEN_EXTRA_TOOLS = registerExtraTools("golden", Tiers.GOLD, ModTiers.GOLD_HARD, new Item.Properties());
    public static final List<DeferredItem<Item>> DIAMOND_EXTRA_TOOLS = registerExtraTools("diamond", Tiers.DIAMOND, ModTiers.DIAMOND_HARD, new Item.Properties());
    public static final List<DeferredItem<Item>> NETHERITE_EXTRA_TOOLS = registerExtraTools("netherite", Tiers.NETHERITE, ModTiers.NETHERITE_HARD, new Item.Properties().fireResistant());
    public static final List<DeferredItem<Item>> ENDERITE_EXTRA_TOOLS = registerExtraTools("enderite", ModTiers.ENDERITE, ModTiers.ENDERITE_HARD, new Item.Properties().fireResistant());
    public static final List<DeferredItem<Item>> STEEL_EXTRA_TOOLS = registerExtraTools("steel", ModTiers.STEEL, ModTiers.STEEL_HARD, new Item.Properties());
    public static final List<DeferredItem<Item>> BRONZE_EXTRA_TOOLS = registerExtraTools("bronze", ModTiers.BRONZE, ModTiers.BRONZE_HARD, new Item.Properties());
    public static final List<DeferredItem<Item>> ZURITE_EXTRA_TOOLS = registerExtraTools("zurite", ModTiers.ZURITE, ModTiers.ZURITE_HARD, new Item.Properties().fireResistant());
    public static final DeferredItem<Item> IRON_REPAIR_KIT = registerItem("iron_repair_kit", () -> new BaseRepairKitItem(ModConfig.ironKitRepairAmount, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_REPAIR_KIT = registerItem("diamond_repair_kit", () -> new BaseRepairKitItem(ModConfig.diamondKitRepairAmount, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_REPAIR_KIT = registerItem("netherite_repair_kit", () -> new BaseRepairKitItem(ModConfig.netheriteKitRepairAmount, new Item.Properties().fireResistant()));
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
    public static final Supplier<PaintingVariant> MISFIT_PAINTING = registerPainting("misfit", () -> new PaintingVariant(16, 16));

    private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties itemProp) {
        var blockReg = registerBlock(name, supplier);
        registerItem(name, () -> new BlockItem(blockReg.get(), itemProp));
        return blockReg;
    }

    private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier) {
        return BLOCKS.register(name, supplier);
    }

    private static DeferredItem<Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static List<DeferredItem<Item>> registerTools(String name, Tier tier, float[] attr, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_sword", () -> new SwordItem(tier, 3, -2.4f, itemProp)),
                registerItem(name + "_pickaxe", () -> new PickaxeItem(tier, 1, -2.8f, itemProp)),
                registerItem(name + "_axe", () -> new AxeItem(tier, attr[0], attr[1], itemProp)),
                registerItem(name + "_shovel", () -> new ShovelItem(tier, 1.5f, -3f, itemProp)),
                registerItem(name + "_hoe", () -> new HoeItem(tier, (int) attr[2], attr[3], itemProp))
        );
    }

    private static List<DeferredItem<Item>> registerExtraTools(String name, Tier tier, Tier tierHard, Item.Properties itemProp) {
        return List.of(
                registerItem(name + "_multitool", () -> new BaseMultitoolItem(tierHard, itemProp)),
                registerItem(name + "_hammer", () -> new BaseHammerItem(tierHard, itemProp)),
                registerItem(name + "_lumberaxe", () -> new BaseLumberaxeItem(tierHard, itemProp)),
                registerItem(name + "_excavator", () -> new BaseExcavatorItem(tierHard, itemProp)),
                registerItem(name + "_glass_cutter", () -> new BaseGlassCutterItem(tier, itemProp))
        );
    }

    private static List<DeferredItem<Item>> registerArmor(ArmorMaterial material, Item.Properties itemProp) {
        String name = material.getName().substring(material.getName().indexOf(ResourceLocation.NAMESPACE_SEPARATOR) + 1);
        return List.of(
                registerItem(name + "_helmet", () -> new BaseArmorItem(material, Type.HELMET, itemProp)),
                registerItem(name + "_chestplate", () -> new BaseArmorItem(material, Type.CHESTPLATE, itemProp)),
                registerItem(name + "_leggings", () -> new BaseArmorItem(material, Type.LEGGINGS, itemProp)),
                registerItem(name + "_boots", () -> new BaseArmorItem(material, Type.BOOTS, itemProp))
        );
    }

    private static Supplier<PaintingVariant> registerPainting(String name, Supplier<PaintingVariant> supplier) {
        return PAINTINGS.register(name, supplier);
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        PAINTINGS.register(bus);

        FUEL_ITEMS.put(HANDLE, 200);

        NeoForge.EVENT_BUS.addListener((FurnaceFuelBurnTimeEvent event) -> FUEL_ITEMS.forEach((item, burnTime) -> {
            if (item.get() == event.getItemStack().getItem()) event.setBurnTime(burnTime);
        }));
    }
}
