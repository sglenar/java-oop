package com.epam.rd.at.java_oop.electricalappliances;

public class SomeAppliance implements ElectricalAppliances {
    private String modelName;
    private String applianceType;
    private int powerConsumptionInWT;
    private int priceInUS;
    private final boolean isWired;

    //constructors

    public SomeAppliance() {
        this.modelName = "Unknown device name";
        this.applianceType = "Unknown device type";
        this.isWired = true;
        this.priceInUS = 1;
        this.powerConsumptionInWT = 10;
    }

    public SomeAppliance(String modelName, String applianceType, int powerConsumptionInWT, int priceInUS, boolean isWired) {
        this.modelName = modelName;
        this.applianceType = applianceType;
        this.powerConsumptionInWT = powerConsumptionInWT;
        this.priceInUS = priceInUS;
        this.isWired = isWired;
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

    public String getApplianceType() {
        return applianceType;
    }
    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

    public int getPowerConsumptionInWT() {
        return powerConsumptionInWT;
    }
    public void setPowerConsumptionInWT(int powerConsumptionInWT) {
        this.powerConsumptionInWT = powerConsumptionInWT;
    }


    public boolean getIsWired() {
        return isWired;
    }

    @Override
    public boolean compareAppliancesByPrice(ElectricalAppliances device) {
        return this.getPriceInUS() > device.getPriceInUS();
    }

    @Override
    public void doMainFunctionality() {
        System.out.println("Doing main functionality");
    }



}
