package com.epam.rd.at.java_oop.electricalappliances;

public class WashingMachine extends SomeAppliance implements  ElectricalAppliances{
    private boolean isVertical;

    //creating constructors
    public WashingMachine() {
        super();
        this.isVertical = false;
    }

    public WashingMachine(boolean isVertical) {
        this.isVertical = isVertical;
    }

    public WashingMachine(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, boolean isVertical) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS);
        this.isVertical = isVertical;
    }

    //methods

    public boolean getIsVertical() {
        return this.isVertical;
    }

    public void setVertical(boolean vertical) {
        this.isVertical = vertical;
    }

    @Override
    public void doMainFunctionality() {
        if (this.getIsPluggedIn()) {
            System.out.println("Washing clothes...");
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }
}
