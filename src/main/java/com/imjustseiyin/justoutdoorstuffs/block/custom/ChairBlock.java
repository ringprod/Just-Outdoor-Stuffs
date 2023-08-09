package com.imjustseiyin.justoutdoorstuffs.block.custom;

import com.imjustseiyin.justoutdoorstuffs.JustOutdoorStuffsMod;
import com.imjustseiyin.justoutdoorstuffs.sit.SitEntity;
import com.imjustseiyin.justoutdoorstuffs.sit.SitUtil;
import com.imjustseiyin.justoutdoorstuffs.util.VoxelHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ChairBlock extends HorizontalDirectionalBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private final VoxelShape SHAPE;

    private final double sitHeight;


    public ChairBlock(Properties pProperties, double sitHeight, VoxelShape voxelShape) {
        super(pProperties);
        this.sitHeight = sitHeight;
        this.SHAPE = voxelShape;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockPos hitPos = pHit.getBlockPos();
        if(!SitUtil.isOccupied(pLevel, hitPos) && pPlayer.getMainHandItem().isEmpty()) {
            SitEntity sit = JustOutdoorStuffsMod.SIT_ENTITY_TYPE.get().create(pLevel);
            sit.setPos(hitPos.getX() + 0.5D, hitPos.getY() + sitHeight, hitPos.getZ() + 0.5D);

            if (SitUtil.addSitEntity(pLevel, hitPos, sit, pPlayer.blockPosition())) {
                pLevel.addFreshEntity(sit);
                pPlayer.startRiding(sit);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        SitEntity sit = SitUtil.getSitEntity(pLevel, pPos);
        if (sit != null) {
            sit.ejectPassengers();
            sit.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(FACING), SHAPE);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.setValue(FACING, pMirror.mirror(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}
