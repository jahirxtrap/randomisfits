package com.jahirtrap.randomisfits.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;
import static com.jahirtrap.randomisfits.util.CommonUtils.formatText;

public class BaseRepairKitItem extends Item {
    private final int amount;

    public BaseRepairKitItem(int repairAmount, Properties properties) {
        super(properties.stacksTo(16));
        this.amount = repairAmount;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack kit = player.getItemInHand(hand), item = player.getItemInHand(hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
        if (!level.isClientSide() && attemptRepair(level, player, kit, item, amount))
            return InteractionResult.SUCCESS_SERVER;

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        tooltip.accept(coloredTextComponent(Component.translatable("randomisfits.repair_kit.amount").getString() + formatText(amount), ChatFormatting.GRAY));
    }

    private static boolean attemptRepair(Level level, Player player, ItemStack kit, ItemStack item, int amount) {
        if (item.isDamaged()) {
            item.setDamageValue(item.getDamageValue() - amount);
            if (!player.getAbilities().instabuild) kit.shrink(1);
            level.playSound(null, player.blockPosition(), SoundEvents.ANVIL_USE, SoundSource.PLAYERS);
            return true;
        } else return false;
    }
}
