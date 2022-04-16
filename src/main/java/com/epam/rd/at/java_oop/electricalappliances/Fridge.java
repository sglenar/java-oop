package com.epam.rd.at.java_oop.electricalappliances;

import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;

public class Fridge extends  SomeAppliance implements ElectricalAppliances {
    private int numberOfCases;

    //constructors
    public Fridge() {
        super();
        setModelName("Unknown Fridge");
        this.numberOfCases = 1;
    }

    public Fridge(int numberOfCases) {
        super();
        setModelName("Unknown Fridge");
        if (numberOfCases < 0 || numberOfCases > 10 ) {
            System.out.println("Invalid input data for TV size. Parameter amount have changed to default");
            this.numberOfCases = 1;
        } else this.numberOfCases = numberOfCases;
    }

    public Fridge(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, boolean isPluggedIn, int numberOfCases) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS, isPluggedIn);
        if (numberOfCases < 0 || numberOfCases > 10 ) {
            System.out.println("Invalid input data for Number of Cases. Parameter amount have changed to default");
            this.numberOfCases = 1;
        } else this.numberOfCases = numberOfCases;
    }

    //methods
    public int getNumberOfCases() {
        return this.numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public String toString() {
        return super.toString() + "I have " + this.numberOfCases + " cases" + "\n";
    }

}
