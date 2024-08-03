package com.jahirtrap.randomisfits.item;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EnderBagItem extends BaseItem {
    public EnderBagItem() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.playSound(SoundEvents.ENDER_CHEST_OPEN, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
        player.openMenu(new MenuProvider() {
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                return ChestMenu.threeRows(id, inventory, player.getEnderChestInventory());
            }

            @Override
            public Component getDisplayName() {
                return Component.translatable("item.randomisfits.ender_bag");
            }
        });

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}
