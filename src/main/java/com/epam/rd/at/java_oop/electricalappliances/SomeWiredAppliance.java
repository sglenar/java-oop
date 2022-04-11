package com.epam.rd.at.java_oop.electricalappliances;

public class SomeWiredAppliance extends SomeAppliance implements WiredAppliances{
    private boolean isPluggedIn;

    //constructors
    public SomeWiredAppliance() {
        super();
        isPluggedIn = false;
    }


    public SomeWiredAppliance(boolean isPluggedIn) {
        super();
        this.isPluggedIn = isPluggedIn;
    }

    public SomeWiredAppliance(String modelName, String applianceType, int powerConsumptionInWT, int priceInUS, boolean isWired, boolean isPluggedIn) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS, isWired);
        this.isPluggedIn = isPluggedIn;
    }

    // methods
    @Override
    public void plugIn() {
        this.isPluggedIn = true;
    }

    @Override
    public void plugOut() {
        this.isPluggedIn = false;
    }

    public boolean getIsPluggedIn() {
        return isPluggedIn;
    }
}
