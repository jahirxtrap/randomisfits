package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModComponents;
import com.jahirtrap.randomisfits.init.ModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;
import java.util.Objects;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.util.CommonUtils.blueBar;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseMultitoolItem extends DiggerItem {
    private static final TagKey<Block> MINEABLE_WITH_MULTITOOL = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "mineable/multitool"));
    private static final Item[] items = {Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.WOODEN_HOE};
    private static final DataComponentType<String> MODE_KEY = ModComponents.MODE_KEY.get();
    private static final String SHOVEL_MODE = "shovel";
    private static final String HOE_MODE = "hoe";

    public BaseMultitoolItem(Tier tier, Properties properties) {
        super(tier, MINEABLE_WITH_MULTITOOL, properties.attributes(createAttributes(tier, 6f, -3f)));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.multitoolInteractions && !level.isClientSide() && player.isShiftKeyDown()) {
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
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility) || ItemAbilities.DEFAULT_PICKAXE_ACTIONS.contains(itemAbility) || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(itemAbility) || ItemAbilities.DEFAULT_HOE_ACTIONS.contains(itemAbility);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flag) {
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
