package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.event.MultitoolInteractionsEvent;
import com.jahirtrap.randomisfits.init.ModConfig;
import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
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

import java.util.List;
import java.util.Objects;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;
import static com.jahirtrap.randomisfits.util.CommonUtils.coloredTextComponent;

public class BaseMultitoolItem extends DiggerItem {
    private static final TagKey<Block> MINEABLE_WITH_MULTITOOL = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "mineable/multitool"));
    private static final DataComponentType<String> MODE_KEY = DataComponents.register("multitool_mode", (builder) -> builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8));
    private static final String SHOVEL_MODE = "shovel";
    private static final String HOE_MODE = "hoe";

    public BaseMultitoolItem(Tier tier, Properties properties) {
        super(tier, MINEABLE_WITH_MULTITOOL, properties.attributes(createAttributes(tier, 6f, -3f)));
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
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flag) {
        if (ModConfig.multitoolInteractions)
            tooltip.add(coloredTextComponent(getModeText(getMode(stack)), ChatFormatting.GRAY));
    }

    public InteractionResult useOn(UseOnContext context) {
        return MultitoolInteractionsEvent.execute(context, getMode(context.getItemInHand()).equals(HOE_MODE) ? 1 : 0);
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
