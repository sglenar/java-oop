package com.epam.rd.at.java_oop.electricalappliances;

import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;

public class Tv extends SomeAppliance implements ElectricalAppliances {
    private int tvSizeInInches;

    //creating constructors

    public Tv() {
        super();
        setModelName("Unknown TV");
        this.tvSizeInInches = 10;
    }

    public Tv(int tvSizeInInches) {
        super();
        setModelName("Unknown TV");
        if (tvSizeInInches < 0 || tvSizeInInches > 150 ) {
            System.out.println("Invalid input data for TV size. Parameter amount have changed to default");
            this.tvSizeInInches = 10;
        } else this.tvSizeInInches = tvSizeInInches;
    }

    public Tv(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, boolean isPluggedIn, int tvSizeInInches) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS, isPluggedIn);
        if (tvSizeInInches < 0 || tvSizeInInches > 150 ) {
            System.out.println("Invalid input data for TV size. Parameter amount have changed to default");
            this.tvSizeInInches = 10;
        } else this.tvSizeInInches = tvSizeInInches;
    }

    // methods

    public int getTvSizeInInches() {
        return this.tvSizeInInches;
    }

    public void setTvSizeInInches(int tvSizeInInches) {
        this.tvSizeInInches = tvSizeInInches;
    }

    @Override
    public String toString() {
        return super.toString() + "My size is " + this.tvSizeInInches + " inches" + "\n";
    }


}

