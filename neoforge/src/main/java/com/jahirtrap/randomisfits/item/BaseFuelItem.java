package com.jahirtrap.randomisfits.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;

public class BaseFuelItem extends Item {
    private final int burnTime;

    public BaseFuelItem(int burnTime, Properties properties) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack, RecipeType<?> recipeType, FuelValues fuelValues) {
        return burnTime;
    }
}
