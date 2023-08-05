package com.imjustseiyin.util;

import net.minecraft.util.StringIdentifiable;

public enum QuadTablePart implements StringIdentifiable {
    FRONTLEFT("front_left"),
    FRONTRIGHT("front_right"),
    BACKLEFT("back_left"),
    BACKRIGHT("back_right");

    private final String name;

    private QuadTablePart(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}