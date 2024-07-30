package com.jahirtrap.randomisfits.event;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ToolActions;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MultitoolInteractionsEvent {
    public static InteractionResult execute(UseOnContext context, int mode) {
        if (!ModConfig.multitoolInteractions) return InteractionResult.PASS;
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        SoundEvent sound = null;

        Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(context, ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(state.getToolModifiedState(context, ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isEmpty() && optional1.isEmpty() ? Optional.ofNullable(state.getToolModifiedState(context, ToolActions.AXE_WAX_OFF, false)) : Optional.empty();
        Optional<BlockState> optional3 = Optional.empty();

        if (optional.isPresent()) {
            sound = SoundEvents.AXE_STRIP;
            optional3 = optional;
        } else if (optional1.isPresent()) {
            sound = SoundEvents.AXE_SCRAPE;
            level.levelEvent(player, 3005, pos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            sound = SoundEvents.AXE_WAX_OFF;
            level.levelEvent(player, 3004, pos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent()) {
            level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            if (player instanceof ServerPlayer serverPlayer)
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);

            level.setBlock(pos, optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, optional3.get()));
            if (player != null) stack.hurtAndBreak(1, player, a -> a.broadcastBreakEvent(context.getHand()));

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        BlockState state1 = null;
        if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
            if (!level.isClientSide()) level.levelEvent(null, 1009, pos, 0);

            CampfireBlock.dowse(context.getPlayer(), level, pos, state);
            state1 = state.setValue(CampfireBlock.LIT, false);
        }

        if (state1 != null) {
            if (!level.isClientSide) {
                level.setBlock(pos, state1, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state1));
                if (player != null)
                    stack.hurtAndBreak(1, player, a -> a.broadcastBreakEvent(context.getHand()));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (mode == 0) {
            if (context.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            } else {
                BlockState state2 = state.getToolModifiedState(context, ToolActions.SHOVEL_FLATTEN, false);
                if (state2 != null && level.isEmptyBlock(pos.above())) {
                    level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1, 1);

                    if (!level.isClientSide) {
                        level.setBlock(pos, state2, 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state2));
                        if (player != null)
                            stack.hurtAndBreak(1, player, a -> a.broadcastBreakEvent(context.getHand()));
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else return InteractionResult.PASS;
            }
        } else {
            BlockState toolModifiedState = level.getBlockState(pos).getToolModifiedState(context, ToolActions.HOE_TILL, false);
            Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of((ctx) -> true, HoeItem.changeIntoState(toolModifiedState));
            if (pair == null) {
                return InteractionResult.PASS;
            } else {
                Predicate<UseOnContext> predicate = pair.getFirst();
                Consumer<UseOnContext> consumer = pair.getSecond();
                if (predicate.test(context)) {
                    level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1, 1);
                    if (!level.isClientSide) {
                        consumer.accept(context);
                        if (player != null)
                            stack.hurtAndBreak(1, player, a -> a.broadcastBreakEvent(context.getHand()));
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else return InteractionResult.PASS;
            }
        }
    }
}
