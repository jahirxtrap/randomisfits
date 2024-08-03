package com.jahirtrap.randomisfits.init.mixin;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.item.BaseLumberaxeItem;
import com.jahirtrap.randomisfits.item.RangeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {

    @Shadow
    protected ServerLevel level;
    @Final
    @Shadow
    protected ServerPlayer player;
    @Unique
    private Direction direction;
    @Unique
    private final List<BlockPos> destroyedBlocks = new CopyOnWriteArrayList<>();
    @Unique
    private final List<BlockPos> rangeBlocks = new CopyOnWriteArrayList<>();
    @Unique
    private final List<BlockPos> fellingBlocks = new CopyOnWriteArrayList<>();

    @Inject(method = "handleBlockBreakAction", at = @At("HEAD"))
    private void getDirection(BlockPos blockPos, ServerboundPlayerActionPacket.Action action, Direction direction, int i, int j, CallbackInfo ci) {
        this.direction = direction;
    }

    @Inject(method = "destroyBlock", at = @At("HEAD"))
    public void destroyBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = player.getMainHandItem();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (stack.getItem() instanceof RangeItem rangeItem && stack.isCorrectToolForDrops(state) && rangeItem.enableRange(stack)) {
            if (rangeBlocks.isEmpty()) {
                getRangeBlocks(pos, direction, stack, rangeItem.getRange());
                for (BlockPos targetPos : rangeBlocks) {
                    if (stack.getDamageValue() >= stack.getMaxDamage()) {
                        rangeBlocks.clear();
                        break;
                    }
                    player.gameMode.destroyBlock(targetPos);
                    rangeBlocks.remove(targetPos);
                }
            }
        } else if (stack.getItem() instanceof BaseLumberaxeItem lumberaxeItem && stack.isCorrectToolForDrops(state) && lumberaxeItem.enableFelling(stack) && !(block instanceof BonemealableBlock || block instanceof VineBlock || block instanceof SugarCaneBlock || block instanceof HangingRootsBlock || block instanceof BushBlock || block instanceof SporeBlossomBlock || block instanceof ScaffoldingBlock)) {
            getFellingBlocks(pos, stack);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci) {
        int i = 0;
        if (!fellingBlocks.isEmpty()) {
            for (BlockPos targetPos : fellingBlocks) {
                if (player.getMainHandItem().getDamageValue() >= player.getMainHandItem().getMaxDamage()) {
                    fellingBlocks.clear();
                    break;
                }
                player.gameMode.destroyBlock(targetPos);
                fellingBlocks.remove(targetPos);
                if (i++ > 32) break;
            }
            if (destroyedBlocks.size() > ModConfig.fellingLimit) fellingBlocks.clear();
            if (fellingBlocks.isEmpty()) destroyedBlocks.clear();
        }
    }

    @Unique
    private void getRangeBlocks(BlockPos pos, Direction direction, ItemStack stack, int range) {
        for (int i = -range; i <= range; i++) {
            for (int j = -range; j <= range; j++) {
                BlockPos targetPos = pos;
                switch (direction) {
                    case DOWN, UP -> targetPos = pos.offset(i, 0, j);
                    case NORTH, SOUTH -> targetPos = pos.offset(i, j, 0);
                    case WEST, EAST -> targetPos = pos.offset(0, i, j);
                }
                BlockState targetState = level.getBlockState(targetPos);
                if (!stack.isCorrectToolForDrops(targetState) || rangeBlocks.contains(targetPos)) continue;
                rangeBlocks.add(targetPos);
            }
        }
    }

    @Unique
    private void getFellingBlocks(BlockPos pos, ItemStack stack) {
        destroyedBlocks.add(pos);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    BlockPos targetPos = pos.offset(i, j, k);
                    BlockState targetState = level.getBlockState(targetPos);
                    Block targetBlock = targetState.getBlock();
                    if (!stack.isCorrectToolForDrops(targetState) || targetBlock instanceof BonemealableBlock || targetBlock instanceof VineBlock || targetBlock instanceof SugarCaneBlock || targetBlock instanceof HangingRootsBlock || targetBlock instanceof BushBlock || targetBlock instanceof SporeBlossomBlock || targetBlock instanceof ScaffoldingBlock)
                        continue;
                    if (fellingBlocks.contains(targetPos) || destroyedBlocks.contains(targetPos)) continue;
                    fellingBlocks.add(targetPos);
                }
            }
        }
    }
}
