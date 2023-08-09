package com.imjustseiyin.justoutdoorstuffs.block.custom;

import com.imjustseiyin.justoutdoorstuffs.util.LongTablePart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class TestDoubleBlock extends HorizontalDirectionalBlock {

    public static final EnumProperty<LongTablePart> PART = EnumProperty.create("part", LongTablePart.class);

    private final VoxelShape SHAPE;

    public TestDoubleBlock(BlockBehaviour.Properties pProperties, VoxelShape voxelShape) {
        super(pProperties);
        this.SHAPE = voxelShape;
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, LongTablePart.FOOT));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {

        if (direction == getNeighbourDirection(state.getValue(PART), state.getValue(FACING))) {
            if (!(neighborState.is(this) && neighborState.getValue(PART) != state.getValue(PART))) {
                return Blocks.AIR.defaultBlockState();
            }
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    private static Direction getNeighbourDirection(LongTablePart pPart, Direction pDirection) {
        return pPart == LongTablePart.FOOT ? pDirection : pDirection.getOpposite();
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide) {
            BlockPos blockpos = pPos.relative(pState.getValue(FACING));
            pLevel.setBlock(blockpos, pState.setValue(PART, LongTablePart.HEAD).setValue(FACING, pState.getValue(FACING)), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }

    }

    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            LongTablePart longtablepart = pState.getValue(PART);
            if (longtablepart == LongTablePart.FOOT) {
                BlockPos blockpos = pPos.relative(getNeighbourDirection(longtablepart, pState.getValue(FACING)));
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
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        Level level = pContext.getLevel();
        return level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        /*Direction direction = getConnectedDirection(pState).getOpposite();
        switch (direction) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return EAST_SHAPE;
        }*/
        return Shapes.block();
    }


    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, PART);
    }

    public long getSeed(BlockState pState, BlockPos pPos) {
        BlockPos blockpos = pPos.relative(pState.getValue(FACING), pState.getValue(PART) == LongTablePart.HEAD ? 0 : 1);
        return Mth.getSeed(blockpos.getX(), pPos.getY(), blockpos.getZ());
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }
}
