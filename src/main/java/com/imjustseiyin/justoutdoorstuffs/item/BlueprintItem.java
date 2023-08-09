package com.imjustseiyin.justoutdoorstuffs.item;

import com.imjustseiyin.justoutdoorstuffs.util.BlueprintType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlueprintItem extends Item {
    BlueprintType type;
    public BlueprintItem(Properties pProperties, BlueprintType type) {
        super(pProperties);
        this.type = type;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable(type == BlueprintType.GARDEN ? "tooltip.justoutdoorstuffs.garden" : "tooltip.justoutdoorstuffs.patio"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
