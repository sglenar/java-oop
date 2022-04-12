package com.epam.rd.at.java_oop.electricalappliances;

public class SomeAppliance implements ElectricalAppliances {
    private String modelName;
    private ApplianceType applianceType;
    private int powerConsumptionInWT;
    private int priceInUS;
    boolean isPluggedIn;

    //constructors

    public SomeAppliance() {
        this.modelName = "Unknown device name";
        this.applianceType = ApplianceType.WIRED;
        this.priceInUS = 1;
        this.powerConsumptionInWT = 10;
    }

    public SomeAppliance(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS) {
        this.modelName = modelName;
        this.applianceType = applianceType;
        this.powerConsumptionInWT = powerConsumptionInWT;
        this.priceInUS = priceInUS;
    }

    //setters and getters

    public void setPriceInUS(int priceInUS) {
        this.priceInUS = priceInUS;
    }
    public int getPriceInUS() {
        return this.priceInUS;
    }

    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public ApplianceType getApplianceType() {
        return applianceType;
    }
    public void setApplianceType(ApplianceType applianceType) {
        this.applianceType = applianceType;
    }

    public int getPowerConsumptionInWT() {
        return powerConsumptionInWT;
    }
    public void setPowerConsumptionInWT(int powerConsumptionInWT) {
        this.powerConsumptionInWT = powerConsumptionInWT;
    }


    @Override
    public boolean compareAppliancesByPrice(ElectricalAppliances device) {
        return this.getPriceInUS() > device.getPriceInUS();
    }

    @Override
    public void doMainFunctionality() {
        System.out.println("Doing main functionality");
    }

    @Override
    public void plugIn() {
        this.isPluggedIn = true;
    }

    @Override
    public void plugOut() {
        this.isPluggedIn = false;
    }

    public boolean getIsPluggedIn() {
        return this.isPluggedIn;
    }

    @Override
    public String toString() {
        return "SomeAppliance description:\n" +
                "My model is '" + modelName + "\n" +
                "My appliance type is " + applianceType + "\n" +
                "My power consumption in WT is" + powerConsumptionInWT + "\n" +
                "My price in US dollars is" + priceInUS + "\n" +
                "My connection status is " + isPluggedIn +
                '.';
    }

    @Override
    public boolean equals(SomeAppliance appliance) {
        return this.priceInUS == appliance.priceInUS;
    }
}
// creating enum type variable
enum ApplianceType {
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
