package com.jahirtrap.randomisfits.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum RandomisfitsTiers implements Tier {
    IRON_MULTITOOL(Tiers.IRON, 0, 2, 0),
    DIAMOND_MULTITOOL(Tiers.DIAMOND, 0, 2, 0),
    NETHERITE_MULTITOOL(Tiers.NETHERITE, 0, 2, 0);

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> ingredient;

    RandomisfitsTiers(Tier tier, int i, int j, float k) {
        this.level = tier.getLevel() + i;
        this.uses = tier.getUses() * j;
        this.speed = tier.getSpeed() + k;
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
