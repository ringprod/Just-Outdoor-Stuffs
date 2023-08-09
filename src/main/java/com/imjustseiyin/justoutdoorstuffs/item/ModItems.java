package com.imjustseiyin.justoutdoorstuffs.item;

import com.imjustseiyin.justoutdoorstuffs.JustOutdoorStuffsMod;
import com.imjustseiyin.justoutdoorstuffs.util.BlueprintType;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JustOutdoorStuffsMod.MOD_ID);

    public static final RegistryObject<Item> BLUEPRINT_GARDEN_STUFFS = ITEMS.register("blueprint_garden_stuffs",
            () -> new BlueprintItem(new Item.Properties(),BlueprintType.GARDEN));
    public static final RegistryObject<Item> BLUEPRINT_PATIO_STUFFS = ITEMS.register("blueprint_patio_stuffs",
            () -> new BlueprintItem(new Item.Properties(),BlueprintType.PATIO));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
