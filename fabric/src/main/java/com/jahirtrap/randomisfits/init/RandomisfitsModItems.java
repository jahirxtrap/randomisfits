package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.item.BaseArmorItem;
import com.jahirtrap.randomisfits.item.BaseWearableItem;
import com.jahirtrap.randomisfits.item.NetheriteLampItem;
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
    public static final Item LAMP = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, "lamp"), new BaseWearableItem(RandomisfitsModBlocks.LAMP, new Item.Properties()));
    public static final Item NETHERITE_LAMP = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, "netherite_lamp"), new NetheriteLampItem(RandomisfitsModBlocks.NETHERITE_LAMP, new Item.Properties()));

    public static void init() {
    }

    public static Item RegistryObject(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MODID, name), item);
    }
}
