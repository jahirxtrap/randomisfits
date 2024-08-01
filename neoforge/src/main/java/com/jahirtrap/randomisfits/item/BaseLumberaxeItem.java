package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseLumberaxeItem extends AxeItem {
    DataComponentType<Boolean> FELLING_KEY = DataComponents.register("felling", (builder) -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL));

    public BaseLumberaxeItem(Tier tier, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, 6f, -3f)));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> holder = super.use(level, player, hand);
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.toggleLumberaxeFelling && !level.isClientSide && player.isShiftKeyDown()) {
            setMode(stack, !getMode(stack));
            player.displayClientMessage(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GOLD), true);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return holder;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.toggleLumberaxeFelling)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
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
