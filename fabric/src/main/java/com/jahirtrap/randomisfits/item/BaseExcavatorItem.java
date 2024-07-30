package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseExcavatorItem extends ShovelItem implements RangeItem {
    public BaseExcavatorItem(Tier tier, Properties properties) {
        super(tier, 3, -3f, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> holder = super.use(level, player, hand);
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.toggleExcavatorMode && !level.isClientSide && player.isShiftKeyDown()) {
            setMode(stack, !getMode(stack));
            player.displayClientMessage(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GOLD), true);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return holder;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.toggleExcavatorMode)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    @Override
    public boolean enableRange(ItemStack stack) {
        if (!ModConfig.toggleExcavatorMode) return true;
        return getMode(stack);
    }
}
