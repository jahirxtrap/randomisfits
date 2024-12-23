package com.jahirtrap.randomisfits.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseLightBlock extends Block implements SimpleWaterloggedBlock {
    private static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private final float width, height;

    public BaseLightBlock(float width, float height, Properties properties) {
        super(properties.pushReaction(PushReaction.DESTROY).sound(SoundType.METAL).strength(0.5f).lightLevel($ -> 15));
        this.registerDefaultState(stateDefinition.any().setValue(FACING, Direction.UP).setValue(BlockStateProperties.WATERLOGGED, false));
        this.width = width;
        this.height = height;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        float a = (16 - width) / 2;
        float b = 16 - a;
        float c = 0 + height;
        float d = 16 - c;

        return switch (direction) {
            case UP -> Block.box(a, 0, a, b, c, b);
            case DOWN -> Block.box(a, d, a, b, 16, b);
            case NORTH -> Block.box(a, a, d, b, b, 16);
            case SOUTH -> Block.box(a, a, 0, b, b, c);
            case WEST -> Block.box(d, a, a, 16, b, b);
            case EAST -> Block.box(0, a, a, c, b, b);
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction direction = context.getClickedFace();
        return this.defaultBlockState().setValue(FACING, direction).setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
        return (facing == state.getValue(FACING).getOpposite() && !state.canSurvive(level, currentPos)) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, tickAccess, currentPos, facing, facingPos, facingState, random);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        return canSupportCenter(level, pos.relative(direction.getOpposite()), direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(FACING, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
