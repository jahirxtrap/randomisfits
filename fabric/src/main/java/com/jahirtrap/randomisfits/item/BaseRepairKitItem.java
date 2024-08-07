package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.event.RepairItemEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

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
        if (RepairItemEvent.execute(player, amount))
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(coloredTextComponent(Component.translatable("randomisfits.repair_kit.amount").getString() + formatText(amount), ChatFormatting.GRAY));
    }
}
