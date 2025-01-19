package com.jahirtrap.randomisfits.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModTiers implements Tier {
    ZURITE(4, 1320, 8.5f, 4f, 16, () -> Ingredient.of(ModTags.Items.ZURITE_INGOTS)),
    STEEL(2, 501, 6.5f, 2f, 14, () -> Ingredient.of(ModTags.Items.STEEL_INGOTS)),
    BRONZE(2, 350, 7f, 2f, 16, () -> Ingredient.of(ModTags.Items.BRONZE_INGOTS)),
    ENDERITE(4, 4096, 15f, 5f, 17, () -> Ingredient.of(ModTags.Items.ENDERITE_INGOTS)),
    IRON_HARD(Tiers.IRON, 2, 0),
    GOLD_HARD(Tiers.GOLD, 10, 0),
    DIAMOND_HARD(Tiers.DIAMOND, 2, 0),
    NETHERITE_HARD(Tiers.NETHERITE, 2, 0),
    ZURITE_HARD(ZURITE, 2, 0),
    STEEL_HARD(STEEL, 2, 0),
    BRONZE_HARD(BRONZE, 2, 0),
    ENDERITE_HARD(ENDERITE, 2, 0);

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> ingredient;

    ModTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> ingredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.ingredient = ingredient;
    }

    ModTiers(Tier tier, int i, float j) {
        this.level = tier.getLevel();
        this.uses = tier.getUses() * i;
        this.speed = tier.getSpeed() + j;
        this.damage = tier.getAttackDamageBonus();
        this.enchantmentValue = tier.getEnchantmentValue();
        this.ingredient = tier::getRepairIngredient;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }
}
