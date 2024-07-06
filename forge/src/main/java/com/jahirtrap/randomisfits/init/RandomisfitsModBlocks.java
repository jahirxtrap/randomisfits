package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.block.BaseLampBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class RandomisfitsModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> LAMP = REGISTRY.register("lamp", BaseLampBlock::new);
    public static final RegistryObject<Block> NETHERITE_LAMP = REGISTRY.register("netherite_lamp", BaseLampBlock::new);
}
