package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RandomisfitsModTab {
    public static CreativeModeTab TAB_RANDOMISFITS = FabricItemGroupBuilder.build(
            new ResourceLocation(RandomisfitsMod.MODID, "tab_randomisfits"), () -> new ItemStack(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE));

    public static void init() {
    }
}
