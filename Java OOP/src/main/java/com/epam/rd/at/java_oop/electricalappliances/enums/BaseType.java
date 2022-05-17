package com.epam.rd.at.java_oop.electricalappliances.enums;

public enum BaseType {
    CERMET("Cermet"),
    TEFLON("Teflon"),
    STEEL("Steel");

    private final String title;

    BaseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
