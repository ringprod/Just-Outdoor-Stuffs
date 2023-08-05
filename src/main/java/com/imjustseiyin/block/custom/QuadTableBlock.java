package com.imjustseiyin.block.custom;

import com.imjustseiyin.util.QuadTablePart;
import com.imjustseiyin.util.VoxelHelper;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import org.jetbrains.annotations.Nullable;

public class QuadTableBlock extends HorizontalFacingBlock {

    public static final EnumProperty<QuadTablePart> PART = EnumProperty.of("part", QuadTablePart.class);
    protected final VoxelShape SHAPE;

    public QuadTableBlock(AbstractBlock.Settings settings, VoxelShape voxelShape) {
        super(settings);
        this.SHAPE = voxelShape;
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(PART, QuadTablePart.FRONTLEFT)));
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance * 0.5F);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == getDirectionTowardsBackPart((QuadTablePart)state.get(PART), (Direction)state.get(FACING)) || direction == getDirectionTowardsSidePart((QuadTablePart)state.get(PART), (Direction)state.get(FACING))) {
            if (!(neighborState.isOf(this) && neighborState.get(PART) != state.get(PART))) {
                return Blocks.AIR.getDefaultState();
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }


    private static Direction getDirectionTowardsBackPart(QuadTablePart part, Direction direction) {
        return part == QuadTablePart.FRONTLEFT || part == QuadTablePart.FRONTRIGHT ? direction.getOpposite() : direction;
    }

    private static Direction getDirectionTowardsSidePart(QuadTablePart part, Direction direction) {
        return part == QuadTablePart.FRONTLEFT || part == QuadTablePart.BACKLEFT ? direction.rotateYCounterclockwise() : direction.rotateYClockwise();
    }


    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            Direction direction = (Direction)state.get(FACING);
            BlockPos backLeftBlockPos = pos.offset(direction.getOpposite());
            BlockPos backRightBlockPos = backLeftBlockPos.offset(direction.rotateYCounterclockwise());
            BlockPos frontRightBlockPos = backRightBlockPos.offset(direction);

            world.setBlockState(backLeftBlockPos, (BlockState)state.with(PART, QuadTablePart.BACKLEFT).with(FACING, state.get(FACING)), 3);
            world.setBlockState(backRightBlockPos, (BlockState)state.with(PART, QuadTablePart.BACKRIGHT).with(FACING, state.get(FACING)), 3);
            world.setBlockState(frontRightBlockPos, (BlockState)state.with(PART, QuadTablePart.FRONTRIGHT).with(FACING, state.get(FACING)), 3);

            world.updateNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(world, pos, 3);
        }

    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            QuadTablePart brokenBlockTablePart = (QuadTablePart)state.get(PART);
            Direction brokenFacing = state.get(FACING);
            if (brokenBlockTablePart == QuadTablePart.FRONTLEFT) {
                BlockPos backLeftBlockPos = pos.offset(getDirectionTowardsBackPart(brokenBlockTablePart, brokenFacing));
                BlockPos backRightBlockPos = backLeftBlockPos.offset(getDirectionTowardsSidePart(brokenBlockTablePart, (Direction)world.getBlockState(backLeftBlockPos).get(FACING)));
                BlockPos frontRightBlockPos = pos.offset(getDirectionTowardsSidePart(brokenBlockTablePart, brokenFacing));

                removeBlockIfMatch(world, player, backRightBlockPos, QuadTablePart.BACKRIGHT);
                removeBlockIfMatch(world, player, backLeftBlockPos, QuadTablePart.BACKLEFT);
                removeBlockIfMatch(world, player, frontRightBlockPos, QuadTablePart.FRONTRIGHT);
            }
        }

        super.onBreak(world, pos, state, player);
    }

    private void removeBlockIfMatch(World world, PlayerEntity player, BlockPos pos, QuadTablePart part) {
        BlockState posBlockState = world.getBlockState(pos);
        if (posBlockState.isOf(this) && posBlockState.get(PART) == part) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 35);
            world.syncWorldEvent(player, 2001, pos, Block.getRawIdFromState(posBlockState));
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getHorizontalPlayerFacing().getOpposite();
        BlockPos frontLeftBlockPos = ctx.getBlockPos();
        BlockPos backLeftBlockPos = frontLeftBlockPos.offset(direction.getOpposite());
        BlockPos backRightBlockPos = frontLeftBlockPos.offset(direction.getOpposite()).offset(direction.rotateYCounterclockwise());
        BlockPos frontRightBlockPos = backRightBlockPos.offset(direction);
        World world = ctx.getWorld();
        return isBlockEmpty(ctx, world, backLeftBlockPos) && isBlockEmpty(ctx, world, backRightBlockPos) && isBlockEmpty(ctx, world, frontRightBlockPos) ? (BlockState)this.getDefaultState().with(FACING, direction) : null;
    }

    private Boolean isBlockEmpty(ItemPlacementContext ctx, World world, BlockPos blockPos) {
        return world.getBlockState(blockPos).canReplace(ctx) && world.getWorldBorder().contains(blockPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(PART)) {
            case BACKLEFT -> VoxelHelper.rotateShape(Direction.NORTH, state.get(FACING).rotateYClockwise(), SHAPE);
            case BACKRIGHT -> VoxelHelper.rotateShape(Direction.NORTH, state.get(FACING).getOpposite(), SHAPE);
            case FRONTRIGHT -> VoxelHelper.rotateShape(Direction.NORTH, state.get(FACING).rotateYCounterclockwise(), SHAPE);
            case FRONTLEFT -> VoxelHelper.rotateShape(Direction.NORTH, state.get(FACING), SHAPE);
        };
    }

    public BlockRenderType getRenderType(BlockState state) {
        return state.get(PART) == QuadTablePart.FRONTLEFT ? BlockRenderType.MODEL : BlockRenderType.INVISIBLE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }

    public long getRenderingSeed(BlockState state, BlockPos pos) {
        BlockPos blockPos = pos.offset((Direction)state.get(FACING), state.get(PART) == QuadTablePart.BACKLEFT ? 0 : 1);
        return MathHelper.hashCode(blockPos.getX(), pos.getY(), blockPos.getZ());
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}

