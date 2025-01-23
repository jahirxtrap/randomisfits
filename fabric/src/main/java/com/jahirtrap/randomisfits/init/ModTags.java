package com.jahirtrap.randomisfits.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTags {
    public interface Items {
        TagKey<Item> GLASS_COLORLESS = create(new ResourceLocation("c:glass_colorless"));
        TagKey<Item> ZURITE_INGOTS = create(new ResourceLocation("c:zurite_ingots"));
        TagKey<Item> STEEL_INGOTS = create(new ResourceLocation("c:steel_ingots"));
        TagKey<Item> BRONZE_INGOTS = create(new ResourceLocation("c:bronze_ingots"));
        TagKey<Item> ENDERITE_INGOTS = create(new ResourceLocation("c:enderite_ingots"));

        private static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }
    }

    public interface Blocks {
        TagKey<Block> MINEABLE_WITH_GLASS_CUTTER = create(new ResourceLocation(MODID, "mineable/glass_cutter"));
        TagKey<Block> MINEABLE_WITH_MULTITOOL = create(new ResourceLocation(MODID, "mineable/multitool"));

        private static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registries.BLOCK, name);
        }
    }
}
