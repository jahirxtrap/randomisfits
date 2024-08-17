package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;
import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseMultitoolItem extends DiggerItem {
    private static final TagKey<Block> MINEABLE_WITH_MULTITOOL = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, "mineable/multitool"));
    private static final Item[] items = {Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE};
    private static final String MODE_KEY = "MultitoolMode";
    private static final String SHOVEL_MODE = "Shovel";
    private static final String HOE_MODE = "Hoe";

    public BaseMultitoolItem(Tier tier, Properties properties) {
        super(6, -3f, tier, MINEABLE_WITH_MULTITOOL, properties.tab(TAB_RANDOMISFITS));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.multitoolInteractions && !level.isClientSide && player.isShiftKeyDown()) {
            String mode = getMode(stack);

            if (Objects.equals(mode, SHOVEL_MODE)) mode = HOE_MODE;
            else mode = SHOVEL_MODE;

            setMode(stack, mode);
            player.displayClientMessage(coloredTextComponent(getModeText(mode), ChatFormatting.GOLD), true);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return super.use(level, player, hand);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.multitoolInteractions)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
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
        if (stack.getTag() != null && !stack.getTag().contains(MODE_KEY))
            setMode(stack, SHOVEL_MODE);

        return stack.getOrCreateTag().getString(MODE_KEY);
    }

    private void setMode(ItemStack stack, String mode) {
        stack.getOrCreateTag().putString(MODE_KEY, mode);
    }

    private String getModeText(String mode) {
        if (Objects.equals(mode, HOE_MODE))
            mode = new TranslatableComponent("randomisfits.multitool.mode.hoe").getString();
        else mode = new TranslatableComponent("randomisfits.multitool.mode.shovel").getString();

        return mode;
    }
}
