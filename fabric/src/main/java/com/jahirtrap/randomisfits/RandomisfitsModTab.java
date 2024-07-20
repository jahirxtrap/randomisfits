package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RandomisfitsModTab {

    public static void init() {
        CreativeModeTab TAB_RANDOMISFITS = FabricItemGroup.builder(new ResourceLocation(RandomisfitsMod.MODID, "tab_randomisfits"))
                .icon(() -> new ItemStack(RandomisfitsModItems.NETHERITE_MULTITOOL))
                .displayItems((features, event) -> {
                    event.accept(RandomisfitsModItems.INVISIBLE_HELMET);
                    event.accept(RandomisfitsModItems.INVISIBLE_CHESTPLATE);
                    event.accept(RandomisfitsModItems.INVISIBLE_LEGGINGS);
                    event.accept(RandomisfitsModItems.INVISIBLE_BOOTS);
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_HELMET);
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE);
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_LEGGINGS);
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_BOOTS);
                    event.accept(RandomisfitsModItems.IRON_MULTITOOL);
                    event.accept(RandomisfitsModItems.DIAMOND_MULTITOOL);
                    event.accept(RandomisfitsModItems.NETHERITE_MULTITOOL);
                    event.accept(RandomisfitsModItems.REPAIR_KIT);
                    event.accept(RandomisfitsModItems.DIAMOND_REPAIR_KIT);
                    event.accept(RandomisfitsModItems.NETHERITE_REPAIR_KIT);
                    event.accept(RandomisfitsModItems.LAMP);
                    event.accept(RandomisfitsModItems.NETHERITE_LAMP);
                })
                .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
                .build();
    }

}
