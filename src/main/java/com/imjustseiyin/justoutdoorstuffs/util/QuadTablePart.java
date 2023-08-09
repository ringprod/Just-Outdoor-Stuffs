package com.imjustseiyin.justoutdoorstuffs.util;

import net.minecraft.util.StringRepresentable;

public enum QuadTablePart implements StringRepresentable {
    FRONTLEFT("front_left"),
    FRONTRIGHT("front_right"),
    BACKLEFT("back_left"),
    BACKRIGHT("back_right");

    private final String name;

    private QuadTablePart(String name) {
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