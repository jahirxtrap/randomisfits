package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class RandomisfitsModTab {

    public static void register(CreativeModeTabEvent.Register register) {
        CreativeModeTab TAB_RANDOMISFITS = register.registerCreativeModeTab(new ResourceLocation(RandomisfitsMod.MODID, "tab_randomisfits"), builder -> builder.icon(() -> new ItemStack(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE.get()))
                .displayItems((features, event) -> {
                    event.accept(RandomisfitsModItems.INVISIBLE_HELMET.get());
                    event.accept(RandomisfitsModItems.INVISIBLE_CHESTPLATE.get());
                    event.accept(RandomisfitsModItems.INVISIBLE_LEGGINGS.get());
                    event.accept(RandomisfitsModItems.INVISIBLE_BOOTS.get());
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_HELMET.get());
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE.get());
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_LEGGINGS.get());
                    event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_BOOTS.get());
                    event.accept(RandomisfitsModItems.REPAIR_KIT.get());
                    event.accept(RandomisfitsModItems.DIAMOND_REPAIR_KIT.get());
                    event.accept(RandomisfitsModItems.NETHERITE_REPAIR_KIT.get());
                    event.accept(RandomisfitsModItems.LAMP.get());
                    event.accept(RandomisfitsModItems.NETHERITE_LAMP.get());
                })
                .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
                .build());
    }

    public static void init(IEventBus bus) {
        bus.addListener(RandomisfitsModTab::register);
    }

}
