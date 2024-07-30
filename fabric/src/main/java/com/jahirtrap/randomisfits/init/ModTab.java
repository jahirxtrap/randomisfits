package com.jahirtrap.randomisfits.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModTab {
    public static CreativeModeTab TAB_RANDOMISFITS = FabricItemGroupBuilder.build(
            new ResourceLocation(MODID, "tab_randomisfits"), () -> new ItemStack(ModContent.NETHERITE_MULTITOOL));

    public static void init() {
    }
}
