package com.imjustseiyin.util;

import net.minecraft.util.StringIdentifiable;

public enum LongTablePart implements StringIdentifiable {
    HEAD("head"),
    FOOT("foot");

    private final String name;

    private LongTablePart(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
