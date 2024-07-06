package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class RandomisfitsModBlocks {
    public static final Block LAMP = RegistryObject("lamp", new BaseLampBlock());
    public static final Block NETHERITE_LAMP = RegistryObject("netherite_lamp", new BaseLampBlock());

    public static void init() {
    }

    public static Block RegistryObject(String name, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(MODID, name), block);
    }
}
