package com.imjustseiyin.justoutdoorstuffs.block.custom;

import com.imjustseiyin.justoutdoorstuffs.util.LongTablePart;
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

public class DoubleTableBlock extends HorizontalDirectionalBlock {

    public static final EnumProperty<LongTablePart> PART = EnumProperty.create("part", LongTablePart.class);

    private final VoxelShape SHAPE;

    public DoubleTableBlock(Properties pProperties, VoxelShape voxelShape) {
        super(pProperties);
        this.SHAPE = voxelShape;
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, LongTablePart.FOOT));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pDirection == getDirectionTowardsOtherPart(pState.getValue(PART), pState.getValue(FACING))) {
            if (!(pNeighborState.is(this) && pNeighborState.getValue(PART) != pState.getValue(PART))) {
                return Blocks.AIR.defaultBlockState();
            }
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    private static Direction getDirectionTowardsOtherPart(LongTablePart part, Direction direction) {
        return part == LongTablePart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide()) {
            BlockPos blockpos = pPos.relative(pState.getValue(FACING));
            pLevel.setBlock(blockpos, pState.setValue(PART, LongTablePart.HEAD), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            LongTablePart longTablePart = pState.getValue(PART);
            if (longTablePart == LongTablePart.FOOT) {
                BlockPos blockpos = pPos.relative(getDirectionTowardsOtherPart(longTablePart, pState.getValue(FACING)));
                BlockState blockstate = pLevel.getBlockState(blockpos);
                if (blockstate.is(this) && blockstate.getValue(PART) == LongTablePart.HEAD) {
                    pLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        Level level = pContext.getLevel();
        return level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(PART) == LongTablePart.FOOT ? pState.getValue(FACING).getOpposite() : pState.getValue(FACING), SHAPE);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return pState.getValue(PART) == LongTablePart.FOOT ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
        builder.add(FACING, PART);
    }

    @Override
    public long getSeed(BlockState pState, BlockPos pPos) {
        BlockPos blockpos = pPos.relative(pState.getValue(FACING), pState.getValue(PART) == LongTablePart.HEAD ? 0 : 1);
        return Mth.getSeed(blockpos.getX(), pPos.getY(), blockpos.getZ());
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }
}
