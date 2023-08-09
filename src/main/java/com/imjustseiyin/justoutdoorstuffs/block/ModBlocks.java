package com.imjustseiyin.justoutdoorstuffs.block;

import com.imjustseiyin.justoutdoorstuffs.JustOutdoorStuffsMod;
import com.imjustseiyin.justoutdoorstuffs.block.custom.*;
import com.imjustseiyin.justoutdoorstuffs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JustOutdoorStuffsMod.MOD_ID);
    public static final RegistryObject<Block> GARDEN_BAG_FERTILIZERS = registerBlock("garden_bag_fertilizers",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.ROOTED_DIRT),
                    Block.box(2.5,0,2,13.5,15,15)));

    public static final RegistryObject<Block> GARDEN_BIRDBATH = registerBlock("garden_birdbath",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,17,0,16,20,16),
                            Block.box(3,0,3,13,17,13)
                    )));


    public static final RegistryObject<Block> GARDEN_BUCKET = registerBlock("garden_bucket",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).instabreak(),
                    Block.box(5,0,5,11,7,11)));

    public static final RegistryObject<Block> GARDEN_FLAMINGO = registerBlock("garden_flamingo",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.6D,
                    Shapes.or(
                            Block.box(5.5,0,3,10.5,15,12.5),
                            Block.box(5.5,15,3,10.5,23,8)
                    )));


    public static final RegistryObject<Block> GARDEN_GNOME_1 = registerBlock("garden_gnome_1",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(3,0,3,13,20,12)));

    public static final RegistryObject<Block> GARDEN_GNOME_2 = registerBlock("garden_gnome_2",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(3,0,3,13,23,12)));

    public static final RegistryObject<Block> GARDEN_GNOME_3 = registerBlock("garden_gnome_3",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(3,0,3,13,23,12)));

    public static final RegistryObject<Block> GARDEN_HOE = registerBlock("garden_hoe",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).instabreak(),
                    Block.box(0,-6,13,16,16,16)));

    public static final RegistryObject<Block> GARDEN_HOSE = registerBlock("garden_hose",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(3,0,3,13,12,13)));

    public static final RegistryObject<Block> GARDEN_LAWN_MOWER = registerBlock("garden_lawn_mower",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(1,0,1,15,8,15)));

    public static final RegistryObject<Block> GARDEN_PITCHFORK = registerBlock("garden_pitchfork",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(0,-13,13,16,16,16)));

    public static final RegistryObject<Block> GARDEN_PLANTER = registerBlock("garden_planter",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16.5,16),
                            Block.box(1,0,1,15,14,15)
                    )));

    public static final RegistryObject<Block> GARDEN_RAKE = registerBlock("garden_rake",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(0,-11,13,16,13,16)));

    public static final RegistryObject<Block> GARDEN_SHOVEL = registerBlock("garden_shovel",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(0,-13,13,16,16,16)));

    public static final RegistryObject<Block> GARDEN_SPADE = registerBlock("garden_spade",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(0,-14,13,16,16,16)));

    public static final RegistryObject<Block> GARDEN_STEP_STOOL = registerBlock("garden_step_stool",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,0,-2,16,4.5,16),
                            Block.box(0,4,0,16,10,14),
                            Block.box(0,10,2,16,15,10)
                    )));

    public static final RegistryObject<Block> GARDEN_TABLE_LARGE = registerBlock("garden_table_large",
            () -> new QuadTableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16,16),
                            Block.box(0,0,10, 6 ,14 ,16)
                    )));

    public static final RegistryObject<Block> GARDEN_TABLE_SMALL = registerBlock("garden_table_small",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16,16),
                            Block.box(6,0,6,10,14,10)

                    )));

    public static final RegistryObject<Block> GARDEN_TABLE_WIDE = registerBlock("garden_table_wide",
            () -> new DoubleTableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16,16),
                            Block.box(4,0,4,12,14,16)
                    )));

    public static final RegistryObject<Block> GARDEN_TOOLS = registerBlock("garden_tools",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(0,6,13,16,14,16)));

    public static final RegistryObject<Block> GARDEN_WATERING_CAN = registerBlock("garden_watering_can",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(5,0,5,11,7,11)));

    public static final RegistryObject<Block> GARDEN_WHEELBARROW = registerBlock("garden_wheelbarrow",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(2,0,-3,14,12,16)));

    public static final RegistryObject<Block> PATIO_BBQ_GRILL = registerBlock("patio_bbq_grill",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(-2,0,2,18,16,14)));

    public static final RegistryObject<Block> PATIO_CHECKERS_SET = registerBlock("patio_checkers_set",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak(),
                    Block.box(3,0,3,13,1,13)));

    public static final RegistryObject<Block> PATIO_COFFEE_TABLE = registerBlock("patio_coffee_table",
            () -> new DoubleTableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(0,0,0,16,8,16)));

    public static final RegistryObject<Block> PATIO_COFFEE_TABLE_GLASS = registerBlock("patio_coffee_table_glass",
            () -> new DoubleTableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.GLASS),
                    Block.box(0,0,0,16,8,16)));

    public static final RegistryObject<Block> PATIO_IRON_PLANTER = registerBlock("patio_iron_planter",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Block.box(0,0,0,16,17,16)));

    public static final RegistryObject<Block> PATIO_IRON_TABLE_LARGE = registerBlock("patio_iron_table_large",
            () -> new QuadTableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16,16),
                            Block.box(0,0,1,15 ,14 ,16)
                    )));

    public static final RegistryObject<Block> PATIO_IRON_TABLE_SMALL = registerBlock("patio_iron_table_small",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16,16),
                            Block.box(1,0,1,15 ,14 ,15)
                    )));

    public static final RegistryObject<Block> PATIO_IRON_TABLE_WIDE = registerBlock("patio_iron_table_wide",
            () -> new DoubleTableBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(0,14,0,16,16,16),
                            Block.box(1,0,1,15 ,14 ,16)
                    )));

    public static final RegistryObject<Block> PATIO_MODERN_PLANTER_BLACK = registerBlock("patio_modern_planter_black",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().strength(0.3F),
                    Block.box(0,0,0,16,16.5,16)));

    public static final RegistryObject<Block> PATIO_MODERN_PLANTER_WHITE = registerBlock("patio_modern_planter_white",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().strength(0.3F),
                    Block.box(0,0,0,16,16.5,16)));

    public static final RegistryObject<Block> PATIO_SIDE_TABLE = registerBlock("patio_side_table",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F),
                    Shapes.or(
                            Block.box(1,14,1,15,16,15),
                            Block.box(2,0,2, 14,14,14)
                    )));

    public static final RegistryObject<Block> PATIO_TEA_SET = registerBlock("patio_tea_set",
            () -> new ModHorizontalFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noOcclusion().strength(0.3F).instabreak().sound(SoundType.GLASS),
                    Block.box(0,0,0,16,8,16)));

    public static final RegistryObject<Block> GARDEN_BENCH = registerBlock("garden_bench",
            () -> new DoubleChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,15,2),
                            Block.box(0,8,2, 16,10,16),
                            Block.box(14,15,0, 16,24,16)

                    )));

    public static final RegistryObject<Block> GARDEN_CHAIR = registerBlock("garden_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Shapes.or(
                            Block.box(2,0,2,14,10,14),
                            Block.box(2,10,12, 14,22,14)
                    )));

    public static final RegistryObject<Block> GARDEN_STOOL = registerBlock("garden_stool",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Block.box(3,0,3,13,10,13)));

    public static final RegistryObject<Block> PATIO_ARMCHAIR = registerBlock("patio_armchair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,9,17),
                            Block.box(0,9,12,16,19,17),

                            Block.box(13,0,2,18,13,17),
                            Block.box(-2,0,2,3,13,17)
                    )));

    public static final RegistryObject<Block> PATIO_BENCH = registerBlock("patio_bench",
            () -> new DoubleChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.3D,
                    Shapes.or(
                            Block.box(2,9,0,14,13,3),
                            Block.box(2,0,0,14,9,16)
                    )));


    public static final RegistryObject<Block> PATIO_IRON_BENCH = registerBlock("patio_iron_bench",
            () -> new DoubleChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,14,2),
                            Block.box(0,8,2, 16,10,16),
                            Block.box(14,14,0, 16,23,16)

                    )));

    public static final RegistryObject<Block> PATIO_IRON_CHAIR = registerBlock("patio_iron_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Shapes.or(
                            Block.box(2,0,2,14,10,14),
                            Block.box(2,10,12, 14,22,14)

                    )));

    public static final RegistryObject<Block> PATIO_IRON_ROCKING_CHAIR = registerBlock("patio_iron_rocking_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Block.box(0,0,3,16,11,18)));

    public static final RegistryObject<Block> PATIO_IRON_STOOL = registerBlock("patio_iron_stool",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F), 0.4D,
                    Block.box(3,0,3,13,10,13)));

    public static final RegistryObject<Block> PATIO_LOUNGE_CHAIR = registerBlock("patio_lounge_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.35D,
                    Block.box(1,0,0,15,9,18.5)));

    public static final RegistryObject<Block> PATIO_SOFA_CHAISE = registerBlock("patio_sofa_chaise",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.4D,
                    Block.box(0,0,0,16,9,16)));

    public static final RegistryObject<Block> PATIO_SOFA_CORNER = registerBlock("patio_sofa_corner",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,9,17),
                            Block.box(0,9,12,16,19,17),

                            Block.box(-1,0,0,4,19,17)
                    )));

    public static final RegistryObject<Block> PATIO_SOFA_LEFT = registerBlock("patio_sofa_left",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,9,17),
                            Block.box(0,9,12,14,19,17),

                            Block.box(12,0,2,17,13,17)
                    )));

    public static final RegistryObject<Block> PATIO_SOFA_MID = registerBlock("patio_sofa_mid",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,9,17),
                            Block.box(0,9,12,16,19,17)
                    )));

    public static final RegistryObject<Block> PATIO_SOFA_RIGHT = registerBlock("patio_sofa_right",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.4D,
                    Shapes.or(
                            Block.box(0,0,0,16,9,17),
                            Block.box(2,9,12,16,19,17),

                            Block.box(-1,0,2,4,13,17)
                    )));

    public static final RegistryObject<Block> PATIO_SOFA_STOOL = registerBlock("patio_sofa_stool",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.3F).sound(SoundType.WOOL), 0.35D,
                    Block.box(4,0,4,12,9,12)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
