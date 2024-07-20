package com.jahirtrap.randomisfits.init;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum RandomisfitsTiers implements Tier {
    IRON_MULTITOOL(Tiers.IRON, null, 2, 0),
    DIAMOND_MULTITOOL(Tiers.DIAMOND, null, 2, 0),
    NETHERITE_MULTITOOL(Tiers.NETHERITE, null, 2, 0);

    private final TagKey<Block> incorrect;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> ingredient;

    RandomisfitsTiers(Tier tier, TagKey<Block> incorrect, int j, float k) {
        this.incorrect = incorrect == null ? tier.getIncorrectBlocksForDrops() : incorrect;
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

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrect;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }
}
