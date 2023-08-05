package com.imjustseiyin.block.custom;

import com.imjustseiyin.JustOutdoorStuffsMod;
import com.imjustseiyin.sit.SitEntity;
import com.imjustseiyin.sit.SitUtil;
import com.imjustseiyin.util.LongTablePart;
import com.imjustseiyin.util.VoxelHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DoubleChairBlock extends DoubleTableBlock {
    protected final VoxelShape SHAPE;
    private final double sitHeight;
    public DoubleChairBlock(Settings settings, Double sitHeight, VoxelShape voxelShape) {
        super(settings, voxelShape);
        this.sitHeight = sitHeight;
        this.SHAPE = voxelShape;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockPos hitPos = hit.getBlockPos();
        if (!SitUtil.isOccupied(world, hitPos) && player.getMainHandStack().isEmpty())
        {
            SitEntity sit = JustOutdoorStuffsMod.SIT_ENTITY_TYPE.create(world);

            sit.updatePosition(hitPos.getX() + 0.5D, hitPos.getY() + sitHeight, hitPos.getZ() + 0.5D);

            if (SitUtil.addSitEntity(world, hitPos, sit, player.getBlockPos())) {
                world.spawnEntity(sit);
                player.startRiding(sit);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelHelper.rotateShape(Direction.NORTH, state.get(FACING).getOpposite(), SHAPE);
        return (state.get(PART) == LongTablePart.FOOT ? shape : VoxelHelper.mirrorShapeHorizontally(state.get(FACING), shape));
    }
}
