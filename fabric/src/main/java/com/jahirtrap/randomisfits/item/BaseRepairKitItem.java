package com.jahirtrap.randomisfits.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;
import static com.jahirtrap.randomisfits.util.CommonUtils.formatText;

public class BaseRepairKitItem extends Item {
    private final int amount;

    public BaseRepairKitItem(Properties properties, int repairAmount) {
        super(properties.stacksTo(16));
        this.amount = repairAmount;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack kit = player.getItemInHand(hand), item = player.getItemInHand(hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
        if (attemptRepair(player, kit, item, amount))
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(coloredTextComponent(Component.translatable("randomisfits.repair_kit.amount").getString() + formatText(amount), ChatFormatting.GRAY));
    }

    private static boolean attemptRepair(Player player, ItemStack kit, ItemStack item, int amount) {
        if (item.isDamaged()) {
            item.setDamageValue(item.getDamageValue() - amount);
            if (!player.getAbilities().instabuild) kit.shrink(1);
            player.playSound(SoundEvents.ANVIL_USE, 1, 1);
            return true;
        }

        return false;
    }
}
