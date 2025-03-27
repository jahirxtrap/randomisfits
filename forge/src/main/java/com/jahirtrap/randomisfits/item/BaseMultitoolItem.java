package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModComponents;
import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.Objects;
import java.util.function.Consumer;

import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseMultitoolItem extends Item {
    private static final Item[] items = {Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE};
    private static final DataComponentType<String> MODE_KEY = ModComponents.MODE_KEY.get();
    private static final String SHOVEL_MODE = "shovel";
    private static final String HOE_MODE = "hoe";

    public BaseMultitoolItem(ToolMaterial material, Properties properties) {
        super(properties.tool(material, ModTags.Blocks.MINEABLE_WITH_MULTITOOL, 6f, -3f, 0));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.multitoolInteractions && !level.isClientSide() && player.isSecondaryUseActive()) {
            String mode = getMode(stack);

            if (Objects.equals(mode, SHOVEL_MODE)) mode = HOE_MODE;
            else mode = SHOVEL_MODE;

            setMode(stack, mode);
            player.displayClientMessage(coloredTextComponent(getModeText(mode), ChatFormatting.GOLD), true);
            return InteractionResult.SUCCESS_SERVER;
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.multitoolInteractions)
            tooltip.accept(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return blueBar(stack);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!ModConfig.multitoolInteractions) return InteractionResult.PASS;
        InteractionResult result = items[0].useOn(context);
        if (result == InteractionResult.PASS) {
            result = items[1].useOn(context);
            if (result == InteractionResult.PASS)
                result = items[getMode(context.getItemInHand()).equals(SHOVEL_MODE) ? 2 : 3].useOn(context);
        }

        return result;
    }

    private String getMode(ItemStack stack) {
        if (!stack.getComponents().has(MODE_KEY))
            setMode(stack, SHOVEL_MODE);

        return stack.getOrDefault(MODE_KEY, SHOVEL_MODE);
    }

    private void setMode(ItemStack stack, String mode) {
        stack.set(MODE_KEY, mode);
    }

    private String getModeText(String mode) {
        if (Objects.equals(mode, HOE_MODE))
            mode = Component.translatable("randomisfits.multitool.mode.hoe").getString();
        else mode = Component.translatable("randomisfits.multitool.mode.shovel").getString();

        return mode;
    }
}
