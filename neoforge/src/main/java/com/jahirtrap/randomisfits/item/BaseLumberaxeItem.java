package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModComponents;
import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseLumberaxeItem extends AxeItem {
    private static final DataComponentType<Boolean> FELLING_KEY = ModComponents.FELLING_KEY.get();

    public BaseLumberaxeItem(ToolMaterial material, Properties properties) {
        super(material, 6f, -3f, properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.toggleLumberaxeFelling && !level.isClientSide() && player.isShiftKeyDown()) {
            setMode(stack, !getMode(stack));
            player.displayClientMessage(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GOLD), true);
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.toggleLumberaxeFelling)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return blueBar(stack);
    }

    boolean getMode(ItemStack stack) {
        if (!stack.getComponents().has(FELLING_KEY))
            setMode(stack, true);

        return stack.getOrDefault(FELLING_KEY, true);
    }

    private void setMode(ItemStack stack, Boolean range) {
        stack.set(FELLING_KEY, range);
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
