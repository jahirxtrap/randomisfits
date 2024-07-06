package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class RandomisfitsModBlocks {
    public static final Block LAMP = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, "lamp"), new BaseLampBlock());
    public static final Block NETHERITE_LAMP = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, "netherite_lamp"), new BaseLampBlock());

    public static void init() {
    }

    public static Block RegistryObject(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), new BlockItem(block, new Item.Properties()));
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name), block);
    }
}
