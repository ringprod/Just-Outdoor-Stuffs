package com.imjustseiyin.justoutdoorstuffs.block.custom;

import com.imjustseiyin.justoutdoorstuffs.util.LongTablePart;
import com.imjustseiyin.justoutdoorstuffs.util.QuadTablePart;
import com.imjustseiyin.justoutdoorstuffs.util.VoxelHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class QuadTableBlock extends HorizontalDirectionalBlock {

    public static final EnumProperty<QuadTablePart> PART = EnumProperty.create("part", QuadTablePart.class);

    private final VoxelShape SHAPE;

    public QuadTableBlock(Properties pProperties, VoxelShape voxelShape) {
        super(pProperties);
        this.SHAPE = voxelShape;
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, QuadTablePart.FRONTLEFT));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pDirection == getDirectionTowardsBackPart(pState.getValue(PART), pState.getValue(FACING)) || pDirection == getDirectionTowardsSidePart(pState.getValue(PART), pState.getValue(FACING))) {
            if (!(pNeighborState.is(this) && pNeighborState.getValue(PART) != pState.getValue(PART))) {
                return Blocks.AIR.defaultBlockState();
            }
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    private static Direction getDirectionTowardsBackPart(QuadTablePart part, Direction direction) {
        return part == QuadTablePart.FRONTLEFT || part == QuadTablePart.FRONTRIGHT ? direction.getOpposite() : direction;
    }

    private static Direction getDirectionTowardsSidePart(QuadTablePart part, Direction direction) {
        return part == QuadTablePart.FRONTLEFT || part == QuadTablePart.BACKLEFT ? direction.getCounterClockWise() : direction.getClockWise();
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide()) {
            Direction direction = pState.getValue(FACING);
            BlockPos backLeftBlockPos = pPos.relative(direction.getOpposite());
            BlockPos backRightBlockPos = backLeftBlockPos.relative(direction.getCounterClockWise());
            BlockPos frontRightBlockPos = backRightBlockPos.relative(direction);

            pLevel.setBlock(backLeftBlockPos, pState.setValue(PART, QuadTablePart.BACKLEFT).setValue(FACING, pState.getValue(FACING)), 3);
            pLevel.setBlock(backRightBlockPos, pState.setValue(PART, QuadTablePart.BACKRIGHT).setValue(FACING, pState.getValue(FACING)), 3);
            pLevel.setBlock(frontRightBlockPos, pState.setValue(PART, QuadTablePart.FRONTRIGHT).setValue(FACING, pState.getValue(FACING)), 3);

            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            QuadTablePart brokenBlockTablePart = pState.getValue(PART);
            Direction brokenFacing = pState.getValue(FACING);
            if (brokenBlockTablePart == QuadTablePart.FRONTLEFT) {
                BlockPos backLeftBlockPos = pPos.relative(getDirectionTowardsBackPart(brokenBlockTablePart, brokenFacing));
                BlockPos backRightBlockPos = backLeftBlockPos.relative(getDirectionTowardsSidePart(brokenBlockTablePart, pLevel.getBlockState(backLeftBlockPos).getValue(FACING)));
                BlockPos frontRightBlockPos = pPos.relative(getDirectionTowardsSidePart(brokenBlockTablePart, brokenFacing));

                removeBlockIfMatch(pLevel, pPlayer, backRightBlockPos, QuadTablePart.BACKRIGHT);
                removeBlockIfMatch(pLevel, pPlayer, backLeftBlockPos, QuadTablePart.BACKLEFT);
                removeBlockIfMatch(pLevel, pPlayer, frontRightBlockPos, QuadTablePart.FRONTRIGHT);
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    private void removeBlockIfMatch(Level world, Player player, BlockPos pos, QuadTablePart part) {
        BlockState posBlockState = world.getBlockState(pos);
        if (posBlockState.is(this) && posBlockState.getValue(PART) == part) {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
            world.levelEvent(player, 2001, pos, Block.getId(posBlockState));
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getHorizontalDirection().getOpposite();
        BlockPos frontLeftBlockPos = pContext.getClickedPos();
        BlockPos backLeftBlockPos = frontLeftBlockPos.relative(direction.getOpposite());
        BlockPos backRightBlockPos = frontLeftBlockPos.relative(direction.getOpposite()).relative(direction.getCounterClockWise());
        BlockPos frontRightBlockPos = backRightBlockPos.relative(direction);
        Level world = pContext.getLevel();
        return isBlockEmpty(pContext, world, backLeftBlockPos) && isBlockEmpty(pContext, world, backRightBlockPos) && isBlockEmpty(pContext, world, frontRightBlockPos) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    private Boolean isBlockEmpty(BlockPlaceContext ctx, Level world, BlockPos blockPos) {
        return world.getBlockState(blockPos).canBeReplaced(ctx) && world.getWorldBorder().isWithinBounds(blockPos);
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        /*return switch (pState.getValue(PART)) {
            case BACKLEFT -> VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(FACING).getClockWise(), SHAPE);
            case BACKRIGHT -> VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(FACING).getOpposite(), SHAPE);
            case FRONTRIGHT -> VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(FACING).getCounterClockWise(), SHAPE);
            case FRONTLEFT -> VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(FACING), SHAPE);
        };*/
        return Shapes.block();
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return pState.getValue(PART) == QuadTablePart.FRONTLEFT ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
        super.createBlockStateDefinition(builder);
        builder.add(FACING, PART);
    }

    @Override
    public long getSeed(BlockState pState, BlockPos pPos) {
        BlockPos blockpos = pPos.relative(pState.getValue(FACING), pState.getValue(PART) == QuadTablePart.BACKLEFT ? 0 : 1);
        return Mth.getSeed(blockpos.getX(), pPos.getY(), blockpos.getZ());
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }
}
