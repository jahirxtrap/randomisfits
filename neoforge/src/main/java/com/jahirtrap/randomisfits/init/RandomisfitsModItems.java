package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.item.*;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class RandomisfitsModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> INVISIBLE_HELMET = REGISTRY.register("invisible_helmet", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_CHESTPLATE = REGISTRY.register("invisible_chestplate", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_LEGGINGS = REGISTRY.register("invisible_leggings", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> INVISIBLE_BOOTS = REGISTRY.register("invisible_boots", () -> new BaseArmorItem(RandomisfitsMaterials.INVISIBLE, Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_HELMET = REGISTRY.register("reinforced_invisible_helmet", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.HELMET, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_CHESTPLATE = REGISTRY.register("reinforced_invisible_chestplate", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_LEGGINGS = REGISTRY.register("reinforced_invisible_leggings", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> REINFORCED_INVISIBLE_BOOTS = REGISTRY.register("reinforced_invisible_boots", () -> new BaseArmorItem(RandomisfitsMaterials.REINFORCED_INVISIBLE, Type.BOOTS, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> IRON_MULTITOOL = REGISTRY.register("iron_multitool", () -> new BaseMultitoolItem(RandomisfitsTiers.IRON_MULTITOOL, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_MULTITOOL = REGISTRY.register("diamond_multitool", () -> new BaseMultitoolItem(RandomisfitsTiers.DIAMOND_MULTITOOL, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_MULTITOOL = REGISTRY.register("netherite_multitool", () -> new BaseMultitoolItem(RandomisfitsTiers.NETHERITE_MULTITOOL, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> REPAIR_KIT = REGISTRY.register("repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), RandomisfitsModConfig.kitRepairAmount));
    public static final DeferredItem<Item> DIAMOND_REPAIR_KIT = REGISTRY.register("diamond_repair_kit", () -> new BaseRepairKitItem(new Item.Properties(), RandomisfitsModConfig.diamondKitRepairAmount));
    public static final DeferredItem<Item> NETHERITE_REPAIR_KIT = REGISTRY.register("netherite_repair_kit", () -> new BaseRepairKitItem(new Item.Properties().fireResistant(), RandomisfitsModConfig.netheriteKitRepairAmount));
    public static final DeferredItem<Item> LAMP = REGISTRY.register("lamp", () -> new BaseWearableItem(RandomisfitsModBlocks.LAMP.get(), new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_LAMP = REGISTRY.register("netherite_lamp", () -> new NetheriteLampItem(RandomisfitsModBlocks.NETHERITE_LAMP.get(), new Item.Properties()));

    private static DeferredItem<Item> block(DeferredBlock<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
