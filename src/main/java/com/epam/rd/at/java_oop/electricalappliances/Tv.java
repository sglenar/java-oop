package com.epam.rd.at.java_oop.electricalappliances;

public class Tv extends SomeAppliance implements ElectricalAppliances {
    private int tvSizeInInches;

    //creating constructors

    public Tv() {
        super();
    }

    public Tv(int tvSizeInInches) {
        this.tvSizeInInches = tvSizeInInches;
    }

    public Tv(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, int tvSizeInInches) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS);
        this.tvSizeInInches = tvSizeInInches;
    }

    // methods

    public int getTvSizeInInches() {
        return this.tvSizeInInches;
    }

    public void setTvSizeInInches(int tvSizeInInches) {
        this.tvSizeInInches = tvSizeInInches;
    }

    @Override
    public void doMainFunctionality() {
        if (this.getIsPluggedIn()) {
            System.out.println("Showing TV show...");
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }

}
