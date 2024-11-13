package com.jahirtrap.randomisfits.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTags {
    public interface Blocks {
        TagKey<Block> MINEABLE_WITH_GLASS_CUTTER = modTag("mineable/glass_cutter");
        TagKey<Block> MINEABLE_WITH_MULTITOOL = modTag("mineable/multitool");
        TagKey<Block> ANCHOR_BLOCKS = modTag("anchor_blocks");

        private static TagKey<Block> modTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(MODID, name));
        }
    }
}
