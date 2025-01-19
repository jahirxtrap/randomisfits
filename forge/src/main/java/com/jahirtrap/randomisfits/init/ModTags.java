package com.jahirtrap.randomisfits.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTags {
    public interface Items {
        TagKey<Item> ZURITE_INGOTS = create(new ResourceLocation("forge:ingots/zurite"));
        TagKey<Item> STEEL_INGOTS = create(new ResourceLocation("forge:ingots/steel"));
        TagKey<Item> BRONZE_INGOTS = create(new ResourceLocation("forge:ingots/bronze"));
        TagKey<Item> ENDERITE_INGOTS = create(new ResourceLocation("forge:ingots/enderite"));

        private static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registry.ITEM_REGISTRY, name);
        }
    }

    public interface Blocks {
        TagKey<Block> MINEABLE_WITH_GLASS_CUTTER = modTag("mineable/glass_cutter");
        TagKey<Block> MINEABLE_WITH_MULTITOOL = modTag("mineable/multitool");
        TagKey<Block> ANCHOR_BLOCKS = modTag("anchor_blocks");

        private static TagKey<Block> modTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, name));
        }
    }
}
