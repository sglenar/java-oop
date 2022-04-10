package com.epam.rd.at.java_oop.electricalappliances;

public class Iron extends SomeWiredAppliance implements WiredAppliances {
    private final int steamPower;
    private final String baseType;

    public Iron() {
        super();
        this.steamPower = 0;
        this. baseType = "Cermet";
    }


    public Iron(int steamPower, String baseType) {
        super();
        this.steamPower = steamPower;
        this.baseType = baseType;
    }

    public Iron(String modelName, String applianceType, int powerConsumptionInWT, int priceInUS, boolean isWired, boolean isPluggedIn, int steamPower, String baseType) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS, isWired, isPluggedIn);
        this.steamPower = steamPower;
        this.baseType = baseType;
    }

    @Override
    public void plugIn() {
        super.plugIn();
    }

    @Override
    public void plugOut() {
        super.plugOut();
    }

    @Override
    public void doMainFunctionality() {
        if (this.isPluggedIn ) {
            System.out.println("Ironing...");
            //System.out.println("My main functionality is iron and my main characteristic is Steam power which is equal to " + steamPower+ ", and Base typa which is equal to "+ baseType);
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }


}
