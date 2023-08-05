package com.imjustseiyin.sit;

import com.imjustseiyin.block.custom.ChairBlock;
import com.imjustseiyin.block.custom.DoubleChairBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class SitUtil {
    private static final Map<Identifier, Map<BlockPos, Pair<SitEntity, BlockPos>>> OCCUPIED = new HashMap<>();

    public static boolean addSitEntity(World level, BlockPos blockPos, SitEntity entity, BlockPos playerPos) {
        if (!level.isClient()) {
            Identifier id = level.getDimensionKey().getValue();

            if (!OCCUPIED.containsKey(id))
                OCCUPIED.put(id, new HashMap<>());

            OCCUPIED.get(id).put(blockPos, Pair.of(entity, playerPos));
            return true;
        }

        return false;
    }

    public static boolean removeSitEntity(World level, BlockPos pos) {
        if (!level.isClient()) {
            Identifier id = level.getDimensionKey().getValue();


            if (OCCUPIED.containsKey(id)) {
                OCCUPIED.get(id).remove(pos);
                return true;
            }
        }

        return false;
    }

    public static SitEntity getSitEntity(World level, BlockPos pos) {
        if (!level.isClient()) {
            Identifier id = level.getDimensionKey().getValue();

            if (OCCUPIED.containsKey(id) && OCCUPIED.get(id).containsKey(pos))
                return OCCUPIED.get(id).get(pos).getLeft();
        }

        return null;
    }

    public static BlockPos getPreviousPlayerPosition(PlayerEntity player, SitEntity sitEntity) {
        if (!player.getWorld().isClient()) {
            Identifier id = player.getWorld().getDimensionKey().getValue();

            if (OCCUPIED.containsKey(id)) {
                for (Pair<SitEntity, BlockPos> pair : OCCUPIED.get(id).values()) {
                    if (pair.getLeft() == sitEntity)
                    {
                        BlockPos pos = pair.getRight();
                        Block block = player.getWorld().getBlockState(pos).getBlock();
                        Block blockAbove = player.getWorld().getBlockState(pos.up()).getBlock();
                        if (block instanceof ChairBlock || block instanceof DoubleChairBlock) {
                            return pos.up();
                        } else if (blockAbove instanceof ChairBlock || blockAbove instanceof DoubleChairBlock) {
                            return pos.up(2);
                        }
                        return pos;
                    }
                }
            }
        }

        return null;
    }

    public static boolean isOccupied(World level, BlockPos pos) {
        Identifier id = level.getDimensionKey().getValue();

        return SitUtil.OCCUPIED.containsKey(id) && SitUtil.OCCUPIED.get(id).containsKey(pos);
    }
}
