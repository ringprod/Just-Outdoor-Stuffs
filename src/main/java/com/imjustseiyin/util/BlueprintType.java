package com.imjustseiyin.util;

import net.minecraft.util.StringIdentifiable;
public enum BlueprintType implements StringIdentifiable {
    GARDEN("garden"),
    PATIO("patio");

    private final String name;

    private BlueprintType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}