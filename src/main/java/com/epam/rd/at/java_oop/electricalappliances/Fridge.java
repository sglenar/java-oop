package com.epam.rd.at.java_oop.electricalappliances;

public class Fridge extends  SomeAppliance implements ElectricalAppliances {
    private int numberOfCases;

    //constructors
    public Fridge() {
        super();
        this.numberOfCases = 1;
    }

    public Fridge(int numberOfCases) {
        super();
        this.numberOfCases = numberOfCases;
    }

    public Fridge(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, int numberOfCases) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS);
        this.numberOfCases = numberOfCases;
    }

    //methods
    public int getNumberOfCases() {
        return this.numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    @Override
    public void doMainFunctionality() {
        if (this.getIsPluggedIn()) {
            System.out.println("Cooling...");
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }


}
