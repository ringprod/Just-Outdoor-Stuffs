package com.imjustseiyin.item;

import com.imjustseiyin.JustOutdoorStuffsMod;
import com.imjustseiyin.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JUSTOUTDOORSTUFF_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(JustOutdoorStuffsMod.MOD_ID, "justoutdoorstuff"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.justoutdoorstuffs.just_outdoor_stuffs"))
                    .icon(() -> new ItemStack(ModBlocks.GARDEN_WATERING_CAN))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GARDEN_CHAIR);
                        entries.add(ModBlocks.GARDEN_STOOL);
                        entries.add(ModBlocks.GARDEN_BENCH);
                        entries.add(ModBlocks.GARDEN_TABLE_SMALL);
                        entries.add(ModBlocks.GARDEN_TABLE_WIDE);
                        entries.add(ModBlocks.GARDEN_TABLE_LARGE);
                        entries.add(ModBlocks.GARDEN_PLANTER);
                        entries.add(ModBlocks.GARDEN_LAWN_MOWER);
                        entries.add(ModBlocks.GARDEN_WHEELBARROW);
                        entries.add(ModBlocks.GARDEN_HOSE);
                        entries.add(ModBlocks.GARDEN_WATERING_CAN);
                        entries.add(ModBlocks.GARDEN_STEP_STOOL);
                        entries.add(ModBlocks.GARDEN_BAG_FERTILIZERS);
                        entries.add(ModBlocks.GARDEN_TOOLS);
                        entries.add(ModBlocks.GARDEN_HOE);
                        entries.add(ModBlocks.GARDEN_RAKE);
                        entries.add(ModBlocks.GARDEN_SHOVEL);
                        entries.add(ModBlocks.GARDEN_SPADE);
                        entries.add(ModBlocks.GARDEN_PITCHFORK);
                        entries.add(ModBlocks.GARDEN_BUCKET);
                        entries.add(ModBlocks.GARDEN_BIRDBATH);
                        entries.add(ModBlocks.GARDEN_FLAMINGO);
                        entries.add(ModBlocks.GARDEN_GNOME_1);
                        entries.add(ModBlocks.GARDEN_GNOME_2);
                        entries.add(ModBlocks.GARDEN_GNOME_3);
                        entries.add(ModBlocks.PATIO_IRON_CHAIR);
                        entries.add(ModBlocks.PATIO_IRON_STOOL);
                        entries.add(ModBlocks.PATIO_IRON_BENCH);
                        entries.add(ModBlocks.PATIO_IRON_TABLE_SMALL);
                        entries.add(ModBlocks.PATIO_IRON_TABLE_WIDE);
                        entries.add(ModBlocks.PATIO_IRON_TABLE_LARGE);
                        entries.add(ModBlocks.PATIO_IRON_PLANTER);
                        entries.add(ModBlocks.PATIO_MODERN_PLANTER_BLACK);
                        entries.add(ModBlocks.PATIO_MODERN_PLANTER_WHITE);
                        entries.add(ModBlocks.PATIO_IRON_ROCKING_CHAIR);
                        entries.add(ModBlocks.PATIO_ARMCHAIR);
                        entries.add(ModBlocks.PATIO_SOFA_LEFT);
                        entries.add(ModBlocks.PATIO_SOFA_MID);
                        entries.add(ModBlocks.PATIO_SOFA_RIGHT);
                        entries.add(ModBlocks.PATIO_SOFA_CORNER);
                        entries.add(ModBlocks.PATIO_SOFA_CHAISE);
                        entries.add(ModBlocks.PATIO_SOFA_STOOL);
                        entries.add(ModBlocks.PATIO_BENCH);
                        entries.add(ModBlocks.PATIO_LOUNGE_CHAIR);
                        entries.add(ModBlocks.PATIO_SIDE_TABLE);
                        entries.add(ModBlocks.PATIO_COFFEE_TABLE);
                        entries.add(ModBlocks.PATIO_COFFEE_TABLE_GLASS);
                        entries.add(ModBlocks.PATIO_TEA_SET);
                        entries.add(ModBlocks.PATIO_CHECKERS_SET);
                        entries.add(ModBlocks.PATIO_BBQ_GRILL);
                        entries.add(ModItems.BLUEPRINT_GARDEN_STUFFS);
                        entries.add(ModItems.BLUEPRINT_PATIO_STUFFS);
                    }).build());
    public static void registerItemGroups() {
        JustOutdoorStuffsMod.LOGGER.debug("Registering Item Groups for " + JustOutdoorStuffsMod.MOD_ID);
    }
}
