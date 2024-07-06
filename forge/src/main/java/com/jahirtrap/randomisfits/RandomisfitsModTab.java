package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RandomisfitsModTab {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomisfitsMod.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_RANDOMISFITS = TAB_REGISTER.register("tab_randomisfits", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE.get()))
            .displayItems((features, event) -> {
                event.accept(RandomisfitsModItems.INVISIBLE_HELMET.get());
                event.accept(RandomisfitsModItems.INVISIBLE_CHESTPLATE.get());
                event.accept(RandomisfitsModItems.INVISIBLE_LEGGINGS.get());
                event.accept(RandomisfitsModItems.INVISIBLE_BOOTS.get());
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_HELMET.get());
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE.get());
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_LEGGINGS.get());
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_BOOTS.get());
                event.accept(RandomisfitsModItems.LAMP.get());
                event.accept(RandomisfitsModItems.NETHERITE_LAMP.get());
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TAB_REGISTER.register(bus);
    }

}
