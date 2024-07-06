package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.item.BaseArmorItem;
import com.jahirtrap.randomisfits.item.BaseWearableItem;
import com.jahirtrap.randomisfits.item.NetheriteLampItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.RandomisfitsModTab.TAB_RANDOMISFITS;

public class RandomisfitsModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> INVISIBLE_HELMET = REGISTRY.register("invisible_helmet", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_CHESTPLATE = REGISTRY.register("invisible_chestplate", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_LEGGINGS = REGISTRY.register("invisible_leggings", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<Item> INVISIBLE_BOOTS = REGISTRY.register("invisible_boots", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, EquipmentSlot.FEET, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_HELMET = REGISTRY.register("reinforced_invisible_helmet", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_CHESTPLATE = REGISTRY.register("reinforced_invisible_chestplate", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.CHEST, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_LEGGINGS = REGISTRY.register("reinforced_invisible_leggings", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.LEGS, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> REINFORCED_INVISIBLE_BOOTS = REGISTRY.register("reinforced_invisible_boots", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, EquipmentSlot.FEET, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> LAMP = REGISTRY.register("lamp", () -> new BaseWearableItem(RandomisfitsModBlocks.LAMP.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_LAMP = REGISTRY.register("netherite_lamp", () -> new NetheriteLampItem(RandomisfitsModBlocks.NETHERITE_LAMP.get(), new Item.Properties()));

    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(TAB_RANDOMISFITS)));
    }
}
