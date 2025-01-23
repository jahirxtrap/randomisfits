package com.jahirtrap.randomisfits.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTags {
    public interface Items {
        TagKey<Item> ZURITE_INGOTS = create(ResourceLocation.parse("c:ingots/zurite"));
        TagKey<Item> STEEL_INGOTS = create(ResourceLocation.parse("c:ingots/steel"));
        TagKey<Item> BRONZE_INGOTS = create(ResourceLocation.parse("c:ingots/bronze"));
        TagKey<Item> ENDERITE_INGOTS = create(ResourceLocation.parse("c:ingots/enderite"));

        private static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }
    }

    public interface Blocks {
        TagKey<Block> MINEABLE_WITH_GLASS_CUTTER = create(ResourceLocation.fromNamespaceAndPath(MODID, "mineable/glass_cutter"));
        TagKey<Block> MINEABLE_WITH_MULTITOOL = create(ResourceLocation.fromNamespaceAndPath(MODID, "mineable/multitool"));

        private static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registries.BLOCK, name);
        }
    }
}
