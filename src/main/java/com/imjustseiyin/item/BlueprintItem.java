package com.imjustseiyin.item;

import com.imjustseiyin.util.BlueprintType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlueprintItem extends Item {
    BlueprintType type;
    public BlueprintItem(Settings settings, BlueprintType type) {
        super(settings);
        this.type = type;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(type == BlueprintType.GARDEN ? "tooltip.justoutdoorstuffs.garden" : "tooltip.justoutdoorstuffs.patio"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
