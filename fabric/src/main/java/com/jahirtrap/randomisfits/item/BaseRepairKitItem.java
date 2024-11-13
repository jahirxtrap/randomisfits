package com.jahirtrap.randomisfits.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;
import static com.jahirtrap.randomisfits.util.CommonUtils.formatText;

public class BaseRepairKitItem extends Item {
    private final int amount;

    public BaseRepairKitItem(int repairAmount, Properties properties) {
        super(properties.stacksTo(16));
        this.amount = repairAmount;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack kit = player.getItemInHand(hand), item = player.getItemInHand(hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
        if (!level.isClientSide() && attemptRepair(level, player, kit, item, amount))
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(coloredTextComponent(Component.translatable("randomisfits.repair_kit.amount").getString() + formatText(amount), ChatFormatting.GRAY));
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
