package com.jahirtrap.randomisfits.event;

import com.jahirtrap.randomisfits.item.BaseRepairKitItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class RepairItemEvent {
    public static boolean execute(Player player, int amount) {
        ItemStack mainHand = player.getMainHandItem(), offHand = player.getOffhandItem();
        return attemptRepair(player, mainHand, offHand, amount) || attemptRepair(player, offHand, mainHand, amount);
    }

    private static boolean attemptRepair(Player player, ItemStack kit, ItemStack item, int amount) {
        if (kit.getItem() instanceof BaseRepairKitItem && item.isDamaged()) {
            item.setDamageValue(item.getDamageValue() - amount);
            if (!player.getAbilities().instabuild) kit.shrink(1);
            player.playSound(SoundEvents.ANVIL_USE, 1, 1);
            return true;
        }
        return false;
    }
}
