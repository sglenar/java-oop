package com.epam.rd.at.java_oop.electricalappliances.enums;

// creating enum type variable
public enum ApplianceType {
    WIRED("Wired"),
    WIRELESS("Wireless");

    private final String title;

    ApplianceType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
