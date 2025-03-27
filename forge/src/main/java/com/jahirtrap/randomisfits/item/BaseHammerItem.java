package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.util.RangeItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseHammerItem extends Item implements RangeItem {
    public BaseHammerItem(ToolMaterial material, Properties properties) {
        super(properties.pickaxe(material, 7f, -3f));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.toggleHammerMode && !level.isClientSide() && player.isSecondaryUseActive()) {
            setMode(stack, !getMode(stack));
            player.displayClientMessage(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GOLD), true);
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.toggleHammerMode)
            tooltip.accept(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return blueBar(stack);
    }

    @Override
    public boolean enableRange(ItemStack stack) {
        if (!ModConfig.toggleHammerMode) return true;
        return getMode(stack);
    }
}
