package com.imjustseiyin.item;

import com.imjustseiyin.JustOutdoorStuffsMod;
import com.imjustseiyin.util.BlueprintType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JustOutdoorStuffsMod.MOD_ID, name), item);
    }

    public static final Item BLUEPRINT_GARDEN_STUFFS = registerItem("blueprint_garden_stuffs", new BlueprintItem(new FabricItemSettings(), BlueprintType.GARDEN));
    public static final Item BLUEPRINT_PATIO_STUFFS = registerItem("blueprint_patio_stuffs", new BlueprintItem(new FabricItemSettings(), BlueprintType.PATIO));

    public static void registerModItems() {}
}
