package com.imjustseiyin.justoutdoorstuffs.item;

import com.imjustseiyin.justoutdoorstuffs.JustOutdoorStuffsMod;
import com.imjustseiyin.justoutdoorstuffs.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JustOutdoorStuffsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JUSTOUTDOORSTUFF_GROUP = CREATIVE_MODE_TABS.register("justoutdoorstuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GARDEN_WATERING_CAN.get()))
                    .title(Component.translatable("itemGroup.justoutdoorstuffs.just_outdoor_stuffs"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.GARDEN_CHAIR.get());
                        pOutput.accept(ModBlocks.GARDEN_STOOL.get());
                        pOutput.accept(ModBlocks.GARDEN_BENCH.get());
                        pOutput.accept(ModBlocks.GARDEN_TABLE_SMALL.get());
                        pOutput.accept(ModBlocks.GARDEN_TABLE_WIDE.get());
                        pOutput.accept(ModBlocks.GARDEN_TABLE_LARGE.get());
                        pOutput.accept(ModBlocks.GARDEN_PLANTER.get());
                        pOutput.accept(ModBlocks.GARDEN_LAWN_MOWER.get());
                        pOutput.accept(ModBlocks.GARDEN_WHEELBARROW.get());
                        pOutput.accept(ModBlocks.GARDEN_HOSE.get());
                        pOutput.accept(ModBlocks.GARDEN_WATERING_CAN.get());
                        pOutput.accept(ModBlocks.GARDEN_STEP_STOOL.get());
                        pOutput.accept(ModBlocks.GARDEN_BAG_FERTILIZERS.get());
                        pOutput.accept(ModBlocks.GARDEN_TOOLS.get());
                        pOutput.accept(ModBlocks.GARDEN_HOE.get());
                        pOutput.accept(ModBlocks.GARDEN_RAKE.get());
                        pOutput.accept(ModBlocks.GARDEN_SHOVEL.get());
                        pOutput.accept(ModBlocks.GARDEN_SPADE.get());
                        pOutput.accept(ModBlocks.GARDEN_PITCHFORK.get());
                        pOutput.accept(ModBlocks.GARDEN_BUCKET.get());
                        pOutput.accept(ModBlocks.GARDEN_BIRDBATH.get());
                        pOutput.accept(ModBlocks.GARDEN_FLAMINGO.get());
                        pOutput.accept(ModBlocks.GARDEN_GNOME_1.get());
                        pOutput.accept(ModBlocks.GARDEN_GNOME_2.get());
                        pOutput.accept(ModBlocks.GARDEN_GNOME_3.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_CHAIR.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_STOOL.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_BENCH.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_TABLE_SMALL.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_TABLE_WIDE.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_TABLE_LARGE.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_PLANTER.get());
                        pOutput.accept(ModBlocks.PATIO_MODERN_PLANTER_BLACK.get());
                        pOutput.accept(ModBlocks.PATIO_MODERN_PLANTER_WHITE.get());
                        pOutput.accept(ModBlocks.PATIO_IRON_ROCKING_CHAIR.get());
                        pOutput.accept(ModBlocks.PATIO_ARMCHAIR.get());
                        pOutput.accept(ModBlocks.PATIO_SOFA_LEFT.get());
                        pOutput.accept(ModBlocks.PATIO_SOFA_MID.get());
                        pOutput.accept(ModBlocks.PATIO_SOFA_RIGHT.get());
                        pOutput.accept(ModBlocks.PATIO_SOFA_CORNER.get());
                        pOutput.accept(ModBlocks.PATIO_SOFA_CHAISE.get());
                        pOutput.accept(ModBlocks.PATIO_SOFA_STOOL.get());
                        pOutput.accept(ModBlocks.PATIO_BENCH.get());
                        pOutput.accept(ModBlocks.PATIO_LOUNGE_CHAIR.get());
                        pOutput.accept(ModBlocks.PATIO_SIDE_TABLE.get());
                        pOutput.accept(ModBlocks.PATIO_COFFEE_TABLE.get());
                        pOutput.accept(ModBlocks.PATIO_COFFEE_TABLE_GLASS.get());
                        pOutput.accept(ModBlocks.PATIO_TEA_SET.get());
                        pOutput.accept(ModBlocks.PATIO_CHECKERS_SET.get());
                        pOutput.accept(ModBlocks.PATIO_BBQ_GRILL.get());
                        pOutput.accept(ModItems.BLUEPRINT_GARDEN_STUFFS.get());
                        pOutput.accept(ModItems.BLUEPRINT_PATIO_STUFFS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
