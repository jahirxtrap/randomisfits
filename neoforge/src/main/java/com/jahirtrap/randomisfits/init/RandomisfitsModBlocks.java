package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class RandomisfitsModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> LAMP = REGISTRY.register("lamp", BaseLampBlock::new);
    public static final DeferredBlock<Block> NETHERITE_LAMP = REGISTRY.register("netherite_lamp", BaseLampBlock::new);
}
