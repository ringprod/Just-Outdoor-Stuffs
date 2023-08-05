package com.imjustseiyin.sit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SitEntity extends MobEntity {
    public SitEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(true);
        this.setInvulnerable(true);
        this.noClip = true;
    }

    @Override
    public void tick() {
        Entity sittingPlayer = this.getFirstPassenger();
        if (sittingPlayer != null) {
            this.setRotation(sittingPlayer.getYaw(), 0);
        }
        super.tick();
    }

    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        super.tickControlled(controllingPlayer, movementInput);
        this.setRotation(controllingPlayer.getYaw(), 0);
        this.prevYaw = this.bodyYaw = this.headYaw = this.getYaw();
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof LivingEntity)
            return (LivingEntity) this.getFirstPassenger();
        return null;
    }

    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        if (passenger instanceof PlayerEntity player) {
            BlockPos pos = SitUtil.getPreviousPlayerPosition(player, this);

            if (pos != null) {
                discard();
                return new Vec3d(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);
            }
        }

        discard();
        return super.updatePassengerForDismount(passenger);
    }

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);
        SitUtil.removeSitEntity(getWorld(), getBlockPos());
    }
}
