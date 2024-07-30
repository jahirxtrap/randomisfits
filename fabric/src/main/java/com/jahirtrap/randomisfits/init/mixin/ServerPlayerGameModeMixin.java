package com.jahirtrap.randomisfits.init.mixin;

import com.jahirtrap.randomisfits.item.RangeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GameMasterBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {

    @Shadow
    protected ServerLevel level;
    @Final
    @Shadow
    protected ServerPlayer player;
    @Unique
    private Direction direction;

    @Inject(method = "handleBlockBreakAction", at = @At("HEAD"))
    private void getDirection(BlockPos blockPos, ServerboundPlayerActionPacket.Action action, Direction direction, int i, CallbackInfo ci) {
        this.direction = direction;
    }

    @Inject(method = "destroyBlock", at = @At("HEAD"), cancellable = true)
    public void destroyBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = player.getMainHandItem();
        BlockState state = level.getBlockState(pos);

        if (stack.getItem() instanceof RangeItem rangeItem && stack.isCorrectToolForDrops(state) && rangeItem.enableRange(stack)) {
            List<Vec3i> blocks = getTargetBlocks(direction, rangeItem.getRange());
            for (Vec3i block : blocks) {
                if (stack.getDamageValue() >= stack.getMaxDamage()) break;
                BlockPos targetPos = pos.offset(block);
                BlockState targetState = level.getBlockState(targetPos);

                if (stack.getItem().canAttackBlock(targetState, level, targetPos, player) && stack.isCorrectToolForDrops(targetState)) {
                    BlockEntity targetBlockEntity = level.getBlockEntity(targetPos);
                    Block targetBlock = targetState.getBlock();
                    if (targetBlock instanceof GameMasterBlock && !player.canUseGameMasterBlocks()) {
                        level.sendBlockUpdated(targetPos, targetState, targetState, 3);
                    } else if (!player.blockActionRestricted(level, targetPos, player.gameMode.getGameModeForPlayer())) {
                        targetBlock.playerWillDestroy(level, targetPos, targetState, player);
                        boolean bl = level.removeBlock(targetPos, false);
                        if (bl) targetBlock.destroy(level, targetPos, targetState);

                        if (!player.isCreative()) {
                            ItemStack stack1 = stack.copy();
                            boolean bl1 = player.hasCorrectToolForDrops(targetState);
                            stack.mineBlock(level, targetState, targetPos, player);
                            if (bl && bl1)
                                targetBlock.playerDestroy(level, player, targetPos, targetState, targetBlockEntity, stack1);
                        }
                    }
                }
            }
            cir.setReturnValue(true);
        }
    }

    @Unique
    private List<Vec3i> getTargetBlocks(Direction direction, int range) {
        List<Vec3i> blocks = new ArrayList<>(List.of(new Vec3i(0, 0, 0)));

        for (int i = -range; i <= range; i++) {
            for (int j = -range; j <= range; j++) {
                if (i == 0 && j == 0) continue;
                switch (direction) {
                    case DOWN, UP -> blocks.add(new Vec3i(i, 0, j));
                    case NORTH, SOUTH -> blocks.add(new Vec3i(i, j, 0));
                    case WEST, EAST -> blocks.add(new Vec3i(0, i, j));
                }
            }
        }

        return blocks;
    }
}
