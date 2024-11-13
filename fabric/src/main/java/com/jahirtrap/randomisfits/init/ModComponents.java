package com.jahirtrap.randomisfits.init;

import com.mojang.serialization.Codec;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModComponents {
    public static final DataComponentType<String> MODE_KEY = register("multitool_mode", DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());
    public static final DataComponentType<Boolean> FELLING_KEY = register("felling", DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final DataComponentType<Boolean> RANGE_KEY = register("range", DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final DataComponentType<GlobalPos> GLOBAL_POS_KEY = register("global_pos", DataComponentType.<GlobalPos>builder().persistent(GlobalPos.CODEC).networkSynchronized(GlobalPos.STREAM_CODEC).build());
    public static final DataComponentType<String> PLAYER_NAME_KEY = register("player_name", DataComponentType.<String>builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());

    private static <T> DataComponentType<T> register(String name, DataComponentType<T> component) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, name), component);
    }

    public static void init() {
    }
}
