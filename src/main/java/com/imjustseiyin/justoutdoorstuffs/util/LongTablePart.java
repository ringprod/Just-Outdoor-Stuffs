package com.imjustseiyin.justoutdoorstuffs.util;

import net.minecraft.util.StringRepresentable;

public enum LongTablePart implements StringRepresentable {
    HEAD("head"),
    FOOT("foot");

    private final String name;

    private LongTablePart(String name) {
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
