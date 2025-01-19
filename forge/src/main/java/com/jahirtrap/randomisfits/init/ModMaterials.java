package com.jahirtrap.randomisfits.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class ModMaterials {
    public static final DeferredRegister<ArmorMaterial> MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);

    public static final RegistryObject<ArmorMaterial> ZURITE = register("zurite", createMap(new int[]{3, 6, 8, 3, 11}),
            16, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5f, 0.1f, () -> Ingredient.of(ModTags.Items.ZURITE_INGOTS));
    public static final RegistryObject<ArmorMaterial> INVISIBLE = register("invisible", createMap(new int[]{2, 5, 6, 2, 5}),
            9, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(Tags.Items.GLASS_BLOCKS_COLORLESS));
    public static final RegistryObject<ArmorMaterial> REINFORCED_INVISIBLE = register("reinforced_invisible", createMap(new int[]{3, 6, 8, 3, 11}),
            10, SoundEvents.ARMOR_EQUIP_GENERIC, 2f, 0f, () -> Ingredient.of(Tags.Items.GLASS_BLOCKS_COLORLESS));

    private static EnumMap<Type, Integer> createMap(int[] values) {
        EnumMap<Type, Integer> enumMap = new EnumMap<>(Type.class);
        for (int i = 0; i < values.length; i++) enumMap.put(Type.values()[i], values[i]);
        return enumMap;
    }

    private static RegistryObject<ArmorMaterial> register(String name, EnumMap<Type, Integer> defense, int i, Holder<SoundEvent> holder, float f, float g, Supplier<Ingredient> supplier) {
        return MATERIALS.register(name, () -> new ArmorMaterial(defense, i, holder, supplier, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, name))), f, g));
    }

    public static void init(IEventBus bus) {
        MATERIALS.register(bus);
    }
}
