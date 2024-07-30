package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.event.MultitoolInteractionsEvent;
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
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.init.ModTab.TAB_RANDOMISFITS;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseMultitoolItem extends DiggerItem {
    public static final TagKey<Block> MINEABLE_WITH_MULTITOOL = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, "mineable/multitool"));
    private static final String MODE_KEY = "MultitoolMode";
    private static final String SHOVEL_MODE = "Shovel";
    private static final String HOE_MODE = "Hoe";

    public BaseMultitoolItem(Tier tier, Properties properties) {
        super(6, -3f, tier, MINEABLE_WITH_MULTITOOL, properties.tab(TAB_RANDOMISFITS));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> holder = super.use(level, player, hand);
        ItemStack stack = player.getItemInHand(hand);

        if (ModConfig.multitoolInteractions && !level.isClientSide && player.isShiftKeyDown()) {
            String mode = getMode(stack);

            if (Objects.equals(mode, SHOVEL_MODE)) mode = HOE_MODE;
            else mode = SHOVEL_MODE;

            setMode(stack, mode);
            player.displayClientMessage(coloredTextComponent(getModeText(mode), ChatFormatting.GOLD), true);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
        }

        return holder;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.multitoolInteractions)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    public InteractionResult useOn(UseOnContext context) {
        return MultitoolInteractionsEvent.execute(context, getMode(context.getItemInHand()).equals(HOE_MODE) ? 1 : 0);
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
