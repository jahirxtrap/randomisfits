package com.jahirtrap.randomisfits;

import com.jahirtrap.randomisfits.init.RandomisfitsModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RandomisfitsModTab {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomisfitsMod.MODID);

    public static final Supplier<CreativeModeTab> TAB_RANDOMISFITS = TAB_REGISTER.register("tab_randomisfits", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE.get()))
            .displayItems((features, event) -> {
                event.accept(RandomisfitsModItems.INVISIBLE_HELMET);
                event.accept(RandomisfitsModItems.INVISIBLE_CHESTPLATE);
                event.accept(RandomisfitsModItems.INVISIBLE_LEGGINGS);
                event.accept(RandomisfitsModItems.INVISIBLE_BOOTS);
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_HELMET);
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_CHESTPLATE);
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_LEGGINGS);
                event.accept(RandomisfitsModItems.REINFORCED_INVISIBLE_BOOTS);
                event.accept(RandomisfitsModItems.LAMP);
                event.accept(RandomisfitsModItems.NETHERITE_LAMP);
            })
            .title(Component.translatable("itemGroup.randomisfits.tab_randomisfits"))
            .build());

    public static void init(IEventBus bus) {
        TAB_REGISTER.register(bus);
    }

}
