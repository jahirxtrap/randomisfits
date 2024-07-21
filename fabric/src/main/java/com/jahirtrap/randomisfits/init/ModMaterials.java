package com.jahirtrap.randomisfits.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModMaterials implements ArmorMaterial {
    INVISIBLE("randomisfits_invisible", 15, createMap(new int[]{2, 5, 6, 2}),
            9, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(Blocks.GLASS)),
    REINFORCED_INVISIBLE("randomisfits_invisible", 30, createMap(new int[]{3, 6, 8, 3}),
            10, SoundEvents.ARMOR_EQUIP_GENERIC, 2f, 0f, () -> Ingredient.of(Blocks.GLASS));

    private static EnumMap<EquipmentSlot, Integer> createMap(int[] values) {
        EnumMap<EquipmentSlot, Integer> enumMap = new EnumMap<>(EquipmentSlot.class);
        EquipmentSlot[] slots = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
        for (int i = 0; i < values.length; i++) enumMap.put(slots[i], values[i]);
        return enumMap;
    }

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<EquipmentSlot, Integer> defense;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> ingredient;

    ModMaterials(String name, int durabilityMultiplier, EnumMap<EquipmentSlot, Integer> defense, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.defense = defense;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.ingredient = ingredient;
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
        return createMap(new int[]{13, 15, 16, 11}).get(slot) * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.defense.get(slot);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
