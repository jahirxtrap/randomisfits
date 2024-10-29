package com.jahirtrap.randomisfits.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class CraftingPlateItem extends Item {
    public CraftingPlateItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider((i, inventory, p) -> new CraftingPlateMenu(i, inventory, ContainerLevelAccess.create(level, player.blockPosition())), Component.translatable("container.crafting")));
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, hand);
    }

    private static class CraftingPlateMenu extends CraftingMenu {
        CraftingPlateMenu(int id, Inventory inventory, ContainerLevelAccess levelAccess) {
            super(id, inventory, levelAccess);
        }

        @Override
        public boolean stillValid(Player player) {
            return true;
        }
    }
}
