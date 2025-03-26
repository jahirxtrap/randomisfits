package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.util.RangeItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseExcavatorItem extends ShovelItem implements RangeItem {
    public BaseExcavatorItem(ToolMaterial material, Properties properties) {
        super(material, 3f, -3f, properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.toggleExcavatorMode && !level.isClientSide() && player.isSecondaryUseActive()) {
            setMode(stack, !getMode(stack));
            player.displayClientMessage(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GOLD), true);
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.toggleExcavatorMode)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return blueBar(stack);
    }

    @Override
    public boolean enableRange(ItemStack stack) {
        if (!ModConfig.toggleExcavatorMode) return true;
        return getMode(stack);
    }
}
