package com.jahirtrap.randomisfits.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseLightBlock extends Block implements SimpleWaterloggedBlock {
    private static final DirectionProperty FACING = BlockStateProperties.FACING;
    private final float width, height;

    public BaseLightBlock(float width, float height) {
        super(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.METAL).strength(0.5f).lightLevel($ -> 15));
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
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor accessor, BlockPos currentPos, BlockPos facingPos) {
        return (facing == state.getValue(FACING).getOpposite() && !state.canSurvive(accessor, currentPos)) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, accessor, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(final BlockState state, final LevelReader level, final BlockPos pos) {
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
