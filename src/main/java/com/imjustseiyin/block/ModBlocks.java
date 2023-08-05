package com.imjustseiyin.block;

import com.imjustseiyin.JustOutdoorStuffsMod;
import com.imjustseiyin.block.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.shape.VoxelShapes;

public class ModBlocks {

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(JustOutdoorStuffsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(JustOutdoorStuffsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static final Block GARDEN_BAG_FERTILIZERS = registerBlock("garden_bag_fertilizers",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.ROOTED_DIRT),
                    Block.createCuboidShape(2.5,0,2,13.5,15,15)));

    public static final Block GARDEN_BIRDBATH = registerBlock("garden_birdbath",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,17,0,16,20,16),
                            Block.createCuboidShape(3,0,3,13,17,13)
                    )));


    public static final Block GARDEN_BUCKET = registerBlock("garden_bucket",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(5,0,5,11,7,11)));

    public static final Block GARDEN_FLAMINGO = registerBlock("garden_flamingo",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.6D,
                    VoxelShapes.union(
                            Block.createCuboidShape(5.5,0,3,10.5,15,12.5),
                            Block.createCuboidShape(5.5,15,3,10.5,23,8)
                    )));


    public static final Block GARDEN_GNOME_1 = registerBlock("garden_gnome_1",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(3,0,3,13,20,12)));

    public static final Block GARDEN_GNOME_2 = registerBlock("garden_gnome_2",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(3,0,3,13,23,12)));

    public static final Block GARDEN_GNOME_3 = registerBlock("garden_gnome_3",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(3,0,3,13,23,12)));

    public static final Block GARDEN_HOE = registerBlock("garden_hoe",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(0,-6,13,16,16,16)));

    public static final Block GARDEN_HOSE = registerBlock("garden_hose",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(3,0,3,13,12,13)));

    public static final Block GARDEN_LAWN_MOWER = registerBlock("garden_lawn_mower",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(1,0,1,15,8,15)));

    public static final Block GARDEN_PITCHFORK = registerBlock("garden_pitchfork",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(0,-13,13,16,16,16)));

    public static final Block GARDEN_PLANTER = registerBlock("garden_planter",
            new PlanterHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16.5,16),
                            Block.createCuboidShape(1,0,1,15,14,15)
                    )));

    public static final Block GARDEN_RAKE = registerBlock("garden_rake",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(0,-11,13,16,13,16)));

    public static final Block GARDEN_SHOVEL = registerBlock("garden_shovel",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(0,-13,13,16,16,16)));

    public static final Block GARDEN_SPADE = registerBlock("garden_spade",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(0,-14,13,16,16,16)));

    public static final Block GARDEN_STEP_STOOL = registerBlock("garden_step_stool",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,-2,16,4.5,16),
                            Block.createCuboidShape(0,4,0,16,10,14),
                            Block.createCuboidShape(0,10,2,16,15,10)
                    )));

    public static final Block GARDEN_TABLE_LARGE = registerBlock("garden_table_large",
            new QuadTableBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16,16),
                            Block.createCuboidShape(0,0,10, 6 ,14 ,16)
                    )));

    public static final Block GARDEN_TABLE_SMALL = registerBlock("garden_table_small",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16,16),
                            Block.createCuboidShape(6,0,6,10,14,10)

                    )));

    public static final Block GARDEN_TABLE_WIDE = registerBlock("garden_table_wide",
            new DoubleTableBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16,16),
                            Block.createCuboidShape(4,0,4,12,14,16)
                    )));

    public static final Block GARDEN_TOOLS = registerBlock("garden_tools",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(0,6,13,16,14,16)));

    public static final Block GARDEN_WATERING_CAN = registerBlock("garden_watering_can",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(5,0,5,11,7,11)));

    public static final Block GARDEN_WHEELBARROW = registerBlock("garden_wheelbarrow",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(2,0,-3,14,12,16)));

    public static final Block PATIO_BBQ_GRILL = registerBlock("patio_bbq_grill",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(-2,0,2,18,16,14)));

    public static final Block PATIO_CHECKERS_SET = registerBlock("patio_checkers_set",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly(),
                    Block.createCuboidShape(3,0,3,13,1,13)));

    public static final Block PATIO_COFFEE_TABLE = registerBlock("patio_coffee_table",
            new DoubleTableBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(0,0,0,16,8,16)));

    public static final Block PATIO_COFFEE_TABLE_GLASS = registerBlock("patio_coffee_table_glass",
            new DoubleTableBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.GLASS),
                    Block.createCuboidShape(0,0,0,16,8,16)));

    public static final Block PATIO_IRON_PLANTER = registerBlock("patio_iron_planter",
            new PlanterHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    Block.createCuboidShape(0,0,0,16,17,16)));

    public static final Block PATIO_IRON_TABLE_LARGE = registerBlock("patio_iron_table_large",
            new QuadTableBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16,16),
                            Block.createCuboidShape(0,0,1,15 ,14 ,16)
                    )));

    public static final Block PATIO_IRON_TABLE_SMALL = registerBlock("patio_iron_table_small",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16,16),
                            Block.createCuboidShape(1,0,1,15 ,14 ,15)
                    )));

    public static final Block PATIO_IRON_TABLE_WIDE = registerBlock("patio_iron_table_wide",
            new DoubleTableBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(0,14,0,16,16,16),
                            Block.createCuboidShape(1,0,1,15 ,14 ,16)
                    )));

    public static final Block PATIO_MODERN_PLANTER_BLACK = registerBlock("patio_modern_planter_black",
            new PlanterHorizontalFacingBlock(FabricBlockSettings.create().strength(0.3F),
                    Block.createCuboidShape(0,0,0,16,16.5,16)));

    public static final Block PATIO_MODERN_PLANTER_WHITE = registerBlock("patio_modern_planter_white",
            new PlanterHorizontalFacingBlock(FabricBlockSettings.create().strength(0.3F),
                    Block.createCuboidShape(0,0,0,16,16.5,16)));

    public static final Block PATIO_SIDE_TABLE = registerBlock("patio_side_table",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F),
                    VoxelShapes.union(
                            Block.createCuboidShape(1,14,1,15,16,15),
                            Block.createCuboidShape(2,0,2, 14,14,14)
                    )));

    public static final Block PATIO_TEA_SET = registerBlock("patio_tea_set",
            new ModHorizontalFacingBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).nonOpaque().strength(0.3F).breakInstantly().sounds(BlockSoundGroup.GLASS),
                    Block.createCuboidShape(0,0,0,16,8,16)));

    public static final Block GARDEN_BENCH = registerBlock("garden_bench",
            new DoubleChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,15,2),
                            Block.createCuboidShape(0,8,2, 16,10,16),
                            Block.createCuboidShape(14,15,0, 16,24,16)

                    )));

    public static final Block GARDEN_CHAIR = registerBlock("garden_chair",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(2,0,2,14,10,14),
                            Block.createCuboidShape(2,10,12, 14,22,14)
                    )));

    public static final Block GARDEN_STOOL = registerBlock("garden_stool",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    Block.createCuboidShape(3,0,3,13,10,13)));

    public static final Block PATIO_ARMCHAIR = registerBlock("patio_armchair",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,9,17),
                            Block.createCuboidShape(0,9,12,16,19,17),

                            Block.createCuboidShape(13,0,2,18,13,17),
                            Block.createCuboidShape(-2,0,2,3,13,17)
                    )));

    public static final Block PATIO_BENCH = registerBlock("patio_bench",
            new DoubleChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.3D,
                    VoxelShapes.union(
                            Block.createCuboidShape(2,9,0,14,13,3),
                            Block.createCuboidShape(2,0,0,14,9,16)
                    )));


    public static final Block PATIO_IRON_BENCH = registerBlock("patio_iron_bench",
            new DoubleChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,14,2),
                            Block.createCuboidShape(0,8,2, 16,10,16),
                            Block.createCuboidShape(14,14,0, 16,23,16)

                    )));

    public static final Block PATIO_IRON_CHAIR = registerBlock("patio_iron_chair",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(2,0,2,14,10,14),
                            Block.createCuboidShape(2,10,12, 14,22,14)

                    )));

    public static final Block PATIO_IRON_ROCKING_CHAIR = registerBlock("patio_iron_rocking_chair",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    Block.createCuboidShape(0,0,3,16,11,18)));

    public static final Block PATIO_IRON_STOOL = registerBlock("patio_iron_stool",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F), 0.4D,
                    Block.createCuboidShape(3,0,3,13,10,13)));

    public static final Block PATIO_LOUNGE_CHAIR = registerBlock("patio_lounge_chair",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.35D,
                    Block.createCuboidShape(1,0,0,15,9,18.5)));

    public static final Block PATIO_SOFA_CHAISE = registerBlock("patio_sofa_chaise",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.4D,
                    Block.createCuboidShape(0,0,0,16,9,16)));

    public static final Block PATIO_SOFA_CORNER = registerBlock("patio_sofa_corner",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,9,17),
                            Block.createCuboidShape(0,9,12,16,19,17),

                            Block.createCuboidShape(-1,0,0,4,19,17)
                    )));

    public static final Block PATIO_SOFA_LEFT = registerBlock("patio_sofa_left",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,9,17),
                            Block.createCuboidShape(0,9,12,14,19,17),

                            Block.createCuboidShape(12,0,2,17,13,17)
                    )));

    public static final Block PATIO_SOFA_MID = registerBlock("patio_sofa_mid",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,9,17),
                            Block.createCuboidShape(0,9,12,16,19,17)
                    )));

    public static final Block PATIO_SOFA_RIGHT = registerBlock("patio_sofa_right",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.4D,
                    VoxelShapes.union(
                            Block.createCuboidShape(0,0,0,16,9,17),
                            Block.createCuboidShape(2,9,12,16,19,17),

                            Block.createCuboidShape(-1,0,2,4,13,17)
                    )));

    public static final Block PATIO_SOFA_STOOL = registerBlock("patio_sofa_stool",
            new ChairBlock(FabricBlockSettings.create().nonOpaque().strength(0.3F).sounds(BlockSoundGroup.WOOL), 0.35D,
                    Block.createCuboidShape(4,0,4,12,9,12)));


    public static void registerModBlocks() {}
}
