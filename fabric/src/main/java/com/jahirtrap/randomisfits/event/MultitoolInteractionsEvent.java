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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

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

        Optional<BlockState> optional = Optional.ofNullable(AxeItem.STRIPPABLES.get(state.getBlock())).map(block -> block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)));
        Optional<BlockState> optional1 = WeatheringCopper.getPrevious(state);
        Optional<BlockState> optional2 = Optional.ofNullable(HoneycombItem.WAX_OFF_BY_BLOCK.get().get(state.getBlock())).map(block -> block.withPropertiesOf(state));
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
            if (player != null) stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));

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
                    stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (mode == 0) {
            if (context.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            } else {
                BlockState state2 = ShovelItem.FLATTENABLES.get(state.getBlock());
                if (state2 != null && level.isEmptyBlock(pos.above())) {
                    level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1, 1);

                    if (!level.isClientSide) {
                        level.setBlock(pos, state2, 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state2));
                        if (player != null)
                            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else return InteractionResult.PASS;
            }
        } else {
            Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = HoeItem.TILLABLES.get(level.getBlockState(pos).getBlock());
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
                            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else return InteractionResult.PASS;
            }
        }
    }
}
