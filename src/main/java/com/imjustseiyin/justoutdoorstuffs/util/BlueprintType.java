package com.imjustseiyin.justoutdoorstuffs.util;

import net.minecraft.util.StringRepresentable;

public enum BlueprintType implements StringRepresentable {
    GARDEN("garden"),
    PATIO("patio");

    private final String name;

    private BlueprintType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}