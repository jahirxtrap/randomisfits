package com.jahirtrap.randomisfits.event;

import com.jahirtrap.randomisfits.item.BaseRepairKitItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.jahirtrap.randomisfits.util.CommonUtils.checkCreativeMode;

public class RepairItemEvent {
    public static boolean execute(Level level, Player player, int amount) {
        ItemStack mainHandIst = player.getMainHandItem(), offHandIst = player.getOffhandItem();

        if (isRepairKit(mainHandIst) && isRepairable(offHandIst))
            return repairItem(level, player, offHandIst, mainHandIst, amount);
        else if (isRepairKit(offHandIst) && isRepairable(mainHandIst))
            return repairItem(level, player, mainHandIst, offHandIst, amount);

        return false;
    }

    private static boolean isRepairKit(ItemStack stack) {
        return stack.getItem() instanceof BaseRepairKitItem;
    }

    private static boolean isRepairable(ItemStack stack) {
        return stack.getDamageValue() > 0 && stack.getCount() == 1;
    }

    private static boolean repairItem(Level level, Player player, ItemStack result, ItemStack stack, int amount) {
        result.setDamageValue(result.getDamageValue() - amount);
        if (!checkCreativeMode(player)) stack.shrink(1);
        player.getInventory().setChanged();

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_USE, SoundSource.PLAYERS, 1, 1);
        return true;
    }
}
