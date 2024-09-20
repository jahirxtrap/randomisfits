package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseLumberaxeItem extends AxeItem {
    private static final String FELLING_KEY = "Felling";

    public BaseLumberaxeItem(Tier tier, Properties properties) {
        super(tier, 6, -3f, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.toggleLumberaxeFelling && !level.isClientSide() && player.isShiftKeyDown()) {
            setMode(stack, !getMode(stack));
            player.displayClientMessage(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GOLD), true);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.toggleLumberaxeFelling)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return blueBar(stack);
    }

    private boolean getMode(ItemStack stack) {
        if (stack.getTag() != null && !stack.getTag().contains(FELLING_KEY))
            setMode(stack, true);

        return stack.getOrCreateTag().getBoolean(FELLING_KEY);
    }

    private void setMode(ItemStack stack, Boolean felling) {
        stack.getOrCreateTag().putBoolean(FELLING_KEY, felling);
    }

    private String getModeText(Boolean felling) {
        String mode;
        if (felling) mode = Component.translatable("randomisfits.lumberaxe.felling.yes").getString();
        else mode = Component.translatable("randomisfits.lumberaxe.felling.no").getString();

        return mode;
    }

    public boolean enableFelling(ItemStack stack) {
        if (!ModConfig.toggleLumberaxeFelling) return true;
        return getMode(stack);
    }
}
