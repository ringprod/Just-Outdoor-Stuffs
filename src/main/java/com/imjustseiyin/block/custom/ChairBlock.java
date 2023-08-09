package com.imjustseiyin.block.custom;

import com.imjustseiyin.JustOutdoorStuffsMod;
import com.imjustseiyin.sit.SitEntity;
import com.imjustseiyin.sit.SitUtil;
import com.imjustseiyin.util.VoxelHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

public class ChairBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.FACING;

    private final VoxelShape originalVoxelShape;

    private final double sitHeight;

    public ChairBlock(Settings settings, Double sitHeight, VoxelShape voxelShape) {
        super(settings);
        this.sitHeight = sitHeight;
        this.originalVoxelShape = voxelShape;
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
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        SitEntity sit = SitUtil.getSitEntity(world, pos);
        if (sit != null) {
            sit.removeAllPassengers();
            sit.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelHelper.rotateShape(Direction.NORTH, state.get(FACING), originalVoxelShape);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
