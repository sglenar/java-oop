package com.epam.rd.at.java_oop.electricalappliances;

import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;

public class SomeAppliance implements ElectricalAppliances {
    private String modelName;
    private ApplianceType applianceType;
    private int powerConsumptionInWT;
    private int priceInUS;
    boolean isPluggedIn;

    //constructors

    public SomeAppliance() {
        this.modelName = "Unknown device";
        this.applianceType = ApplianceType.WIRED;
        this.priceInUS = 10;
        this.powerConsumptionInWT = 10;
        this.isPluggedIn = true;
    }

    public SomeAppliance(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS,
                         boolean isPluggedIn) {
        this.modelName = modelName;
        this.applianceType = applianceType;
        if (priceInUS < 0) {
            System.out.println("Invalid input data for Price. Parameter amount have changed to default");
            this.priceInUS = 10;
        } else {
            this.priceInUS = priceInUS;
        }
        if ( powerConsumptionInWT < 0 || powerConsumptionInWT > 100) {
            System.out.println("Invalid input data for Power consumption. Parameter amount have changed to default");
            this.powerConsumptionInWT = 10;
        } else {
            this.powerConsumptionInWT = powerConsumptionInWT;
        }
        this.isPluggedIn = isPluggedIn;
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

    //methods
    @Override
    public boolean compareAppliancesByPrice(ElectricalAppliances device) {
        return this.getPriceInUS() > device.getPriceInUS();
    }


    @Override
    public void doMainFunctionality() {
        System.out.println("I am the " + this.getModelName()) ;
        System.out.println("My main functionality is unknown");
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
        return "Appliance description:\n" +
                "My model is " + modelName + "\n" +
                "My type is " + applianceType.getTitle() + "\n" +
                "My power consumption in WT is " + powerConsumptionInWT + "\n" +
                "My price in US dollars is " + priceInUS + "\n" +
                "My connection status is " + isPluggedIn + "\n";
    }

    @Override
    public boolean equals(SomeAppliance appliance) {
        return this.priceInUS == appliance.priceInUS;
    }

    @Override
    public boolean isDeviceInPowerConsumptionRange(int rangeStart, int rangeEnd) {
        return this.powerConsumptionInWT >= rangeStart && this.powerConsumptionInWT <= rangeEnd;
    }


}
