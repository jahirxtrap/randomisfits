package com.jahirtrap.randomisfits.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EnderBagItem extends Item {
    public EnderBagItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            level.playSound(null, player.blockPosition(), SoundEvents.ENDER_CHEST_OPEN, SoundSource.PLAYERS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            player.openMenu(new SimpleMenuProvider(EnderBagMenu::new, Component.translatable("item.randomisfits.ender_bag")));
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (entity instanceof Player player) {
            if (player.getMainHandItem() == stack || player.getOffhandItem() == stack) {
                for (int j = 0; j < 2; j++)
                    level.sendParticles(ParticleTypes.PORTAL, player.getRandomX(0.5), player.getRandomY() - 0.25, player.getRandomZ(0.5), 1, 0, (level.random.nextDouble() - 0.5) * 2, -level.random.nextDouble(), (level.random.nextDouble() - 0.5) * 2);
            }
        }
    }

    private static class EnderBagMenu extends ChestMenu {
        public EnderBagMenu(int id, Inventory inventory, Player player) {
            super(MenuType.GENERIC_9x3, id, inventory, player.getEnderChestInventory(), 3);
        }

        @Override
        public void removed(Player player) {
            player.level().playSound(null, player.blockPosition(), SoundEvents.ENDER_CHEST_CLOSE, SoundSource.PLAYERS, 0.5f, player.level().random.nextFloat() * 0.1f + 0.9f);
            super.removed(player);
        }
    }
}
