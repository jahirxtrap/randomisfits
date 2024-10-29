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

        private static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }
    }

    public interface Blocks {
        TagKey<Block> MINEABLE_WITH_GLASS_CUTTER = modTag("mineable/glass_cutter");
        TagKey<Block> MINEABLE_WITH_MULTITOOL = modTag("mineable/multitool");

        private static TagKey<Block> modTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(MODID, name));
        }
    }
}
