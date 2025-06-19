package com.jahirtrap.randomisfits.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MODID);

    public static final RegistryObject<DataComponentType<String>> MODE_KEY = register("multitool_mode", () -> DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final RegistryObject<DataComponentType<Boolean>> FELLING_KEY = register("felling", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final RegistryObject<DataComponentType<Boolean>> RANGE_KEY = register("range", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());

    private static <T> RegistryObject<DataComponentType<T>> register(String name, Supplier<DataComponentType<T>> supplier) {
        return COMPONENTS.register(name, supplier);
    }

    public static void init(BusGroup bus) {
        COMPONENTS.register(bus);
    }
}
