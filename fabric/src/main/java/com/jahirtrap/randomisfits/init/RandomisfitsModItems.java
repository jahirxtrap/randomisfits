package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.item.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class RandomisfitsModItems {
    public static final Item INVISIBLE_HELMET = RegistryObject("invisible_helmet", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.HELMET, 15, new Item.Properties()));
    public static final Item INVISIBLE_CHESTPLATE = RegistryObject("invisible_chestplate", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.CHESTPLATE, 15, new Item.Properties()));
    public static final Item INVISIBLE_LEGGINGS = RegistryObject("invisible_leggings", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.LEGGINGS, 15, new Item.Properties()));
    public static final Item INVISIBLE_BOOTS = RegistryObject("invisible_boots", new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.BOOTS, 15, new Item.Properties()));
    public static final Item REINFORCED_INVISIBLE_HELMET = RegistryObject("reinforced_invisible_helmet", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.HELMET, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_CHESTPLATE = RegistryObject("reinforced_invisible_chestplate", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.CHESTPLATE, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_LEGGINGS = RegistryObject("reinforced_invisible_leggings", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.LEGGINGS, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item REINFORCED_INVISIBLE_BOOTS = RegistryObject("reinforced_invisible_boots", new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.BOOTS, 30, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item IRON_MULTITOOL = RegistryObject("iron_multitool", new BaseMultitoolItem(RandomisfitsTiers.IRON_MULTITOOL, new Item.Properties()));
    public static final Item DIAMOND_MULTITOOL = RegistryObject("diamond_multitool", new BaseMultitoolItem(RandomisfitsTiers.DIAMOND_MULTITOOL, new Item.Properties()));
    public static final Item NETHERITE_MULTITOOL = RegistryObject("netherite_multitool", new BaseMultitoolItem(RandomisfitsTiers.NETHERITE_MULTITOOL, new Item.Properties().fireResistant()));
    public static final Item REPAIR_KIT = RegistryObject("repair_kit", new BaseRepairKitItem(new Item.Properties(), RandomisfitsModConfig.kitRepairAmount));
    public static final Item DIAMOND_REPAIR_KIT = RegistryObject("diamond_repair_kit", new BaseRepairKitItem(new Item.Properties(), RandomisfitsModConfig.diamondKitRepairAmount));
    public static final Item NETHERITE_REPAIR_KIT = RegistryObject("netherite_repair_kit", new BaseRepairKitItem(new Item.Properties().fireResistant(), RandomisfitsModConfig.netheriteKitRepairAmount));
    public static final Item LAMP = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, "lamp"), new BaseWearableItem(RandomisfitsModBlocks.LAMP, new Item.Properties()));
    public static final Item NETHERITE_LAMP = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, "netherite_lamp"), new NetheriteLampItem(RandomisfitsModBlocks.NETHERITE_LAMP, new Item.Properties()));

    public static void init() {
    }

    public static Item RegistryObject(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name), item);
    }
}
