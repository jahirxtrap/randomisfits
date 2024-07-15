package com.jahirtrap.randomisfits.event;

import com.jahirtrap.randomisfits.item.BaseRepairKitItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class RepairItemEvent {
    public static boolean execute(Player player, int amount) {
        ItemStack mainHandIst = player.getMainHandItem(), offHandIst = player.getOffhandItem();

        if (isRepairKit(mainHandIst) && isRepairable(offHandIst))
            return repairItem(player, offHandIst, mainHandIst, amount);
        else if (isRepairKit(offHandIst) && isRepairable(mainHandIst))
            return repairItem(player, mainHandIst, offHandIst, amount);

        return false;
    }

    private static boolean isRepairKit(ItemStack stack) {
        return stack.getItem() instanceof BaseRepairKitItem;
    }

    private static boolean isRepairable(ItemStack stack) {
        return stack.getDamageValue() > 0 && stack.getCount() == 1;
    }

    private static boolean repairItem(Player player, ItemStack result, ItemStack stack, int amount) {
        result.setDamageValue(result.getDamageValue() - amount);
        if (!player.getAbilities().instabuild) stack.shrink(1);

        player.playSound(SoundEvents.ANVIL_USE, 1, 1);
        return true;
    }
}
