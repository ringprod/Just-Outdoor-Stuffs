package com.imjustseiyin.justoutdoorstuffs.block.custom;

import com.imjustseiyin.justoutdoorstuffs.JustOutdoorStuffsMod;
import com.imjustseiyin.justoutdoorstuffs.sit.SitEntity;
import com.imjustseiyin.justoutdoorstuffs.sit.SitUtil;
import com.imjustseiyin.justoutdoorstuffs.util.LongTablePart;
import com.imjustseiyin.justoutdoorstuffs.util.VoxelHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DoubleChairBlock extends DoubleTableBlock {

    private final VoxelShape SHAPE;

    private final double sitHeight;
    public DoubleChairBlock(Properties pProperties, Double sitHeight, VoxelShape voxelShape) {
        super(pProperties, voxelShape);
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
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        VoxelShape shape = VoxelHelper.rotateShape(Direction.NORTH, pState.getValue(FACING).getOpposite(), SHAPE);
        return pState.getValue(PART) == LongTablePart.FOOT ? shape : VoxelHelper.mirrorShapeHorizontally(pState.getValue(FACING), shape);
    }
}
