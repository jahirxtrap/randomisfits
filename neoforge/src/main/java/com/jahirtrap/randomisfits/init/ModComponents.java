package com.jahirtrap.randomisfits.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(MODID);

    public static final Supplier<DataComponentType<String>> MODE_KEY = register("multitool_mode", () -> DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final Supplier<DataComponentType<Boolean>> FELLING_KEY = register("felling", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final Supplier<DataComponentType<Boolean>> RANGE_KEY = register("range", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());

    private static <T> Supplier<DataComponentType<T>> register(String name, Supplier<DataComponentType<T>> supplier) {
        return COMPONENTS.register(name, supplier);
    }

    public static void init(IEventBus bus) {
        COMPONENTS.register(bus);
    }
}
