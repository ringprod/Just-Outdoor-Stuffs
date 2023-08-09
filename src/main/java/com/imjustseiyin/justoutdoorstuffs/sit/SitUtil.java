package com.imjustseiyin.justoutdoorstuffs.sit;

import com.imjustseiyin.justoutdoorstuffs.JustOutdoorStuffsMod;
import com.imjustseiyin.justoutdoorstuffs.block.custom.ChairBlock;
import com.imjustseiyin.justoutdoorstuffs.block.custom.DoubleChairBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class SitUtil {

    private static final Map<ResourceLocation, Map<BlockPos, Pair<SitEntity, BlockPos>>> OCCUPIED = new HashMap<>();

    public static boolean addSitEntity(Level level, BlockPos blockPos, SitEntity entity, BlockPos playerPos) {
        if (!level.isClientSide()) {
            ResourceLocation id = level.dimension().registry();

            if (!OCCUPIED.containsKey(id))
                OCCUPIED.put(id, new HashMap<>());

            OCCUPIED.get(id).put(blockPos, Pair.of(entity, playerPos));
            return true;
        }

        return false;
    }

    public static boolean removeSitEntity(Level level, BlockPos pos) {
        if (!level.isClientSide()) {
            ResourceLocation id = level.dimension().registry();


            if (OCCUPIED.containsKey(id)) {
                OCCUPIED.get(id).remove(pos);
                return true;
            }
        }

        return false;
    }

    public static SitEntity getSitEntity(Level level, BlockPos pos) {
        if (!level.isClientSide()) {
            ResourceLocation id = level.dimension().registry();

            if (OCCUPIED.containsKey(id) && OCCUPIED.get(id).containsKey(pos))
                return OCCUPIED.get(id).get(pos).getLeft();
        }

        return null;
    }

    public static BlockPos getPreviousPlayerPosition(Player player, SitEntity sitEntity) {
        if (!player.level().isClientSide()) {
            ResourceLocation id = player.level().dimension().registry();

            if (OCCUPIED.containsKey(id)) {
                for (Pair<SitEntity, BlockPos> pair : OCCUPIED.get(id).values()) {
                    if (pair.getLeft() == sitEntity)
                    {
                        BlockPos pos = pair.getRight();
                        Block block = player.level().getBlockState(pos).getBlock();
                        Block blockAbove = player.level().getBlockState(pos.above()).getBlock();
                        if (block instanceof ChairBlock || block instanceof DoubleChairBlock) {
                            return pos.above();
                        } else if (blockAbove instanceof ChairBlock || blockAbove instanceof DoubleChairBlock) {
                            return pos.above(2);
                        }
                        return pos;
                    }
                }
            }
        }

        return null;
    }

    public static boolean isOccupied(Level level, BlockPos pos) {
        ResourceLocation id = level.dimension().registry();

        return SitUtil.OCCUPIED.containsKey(id) && SitUtil.OCCUPIED.get(id).containsKey(pos);
    }
}
