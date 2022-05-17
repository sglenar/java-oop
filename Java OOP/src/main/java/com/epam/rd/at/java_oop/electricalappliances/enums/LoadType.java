package com.epam.rd.at.java_oop.electricalappliances.enums;

// creating enum type variable
public enum LoadType {
    VERTICAL("Vertical"),
    HORIZONTAL("Horizontal");

    private final String title;

    LoadType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
