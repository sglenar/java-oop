package com.epam.rd.at.java_oop.electricalappliances;

import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;
import com.epam.rd.at.java_oop.electricalappliances.enums.LoadType;

import javax.sound.midi.Soundbank;

public class WashingMachine extends SomeAppliance implements  ElectricalAppliances{
    private LoadType loadType;

    //creating constructors
    public WashingMachine() {
        super();
        setModelName("Unknown Washing machine");
        this.loadType = LoadType.HORIZONTAL;
    }

    public WashingMachine(LoadType loadType) {
        setModelName("Unknown Washing machine");
        this.loadType = loadType;
    }

    public WashingMachine(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, boolean isPluggedIn, LoadType loadType) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS, isPluggedIn);
        this.loadType = loadType;
    }

    //methods

    public LoadType getLoadType() {
        return this.loadType;
    }

    public void setLoadType(LoadType loadType) {
        this.loadType = loadType;
    }

    @Override
    public void doMainFunctionality() {
        if (this.getIsPluggedIn()) {
            System.out.println("I am the " + this.getModelName()) ;
            System.out.println("Washing clothes...");
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "My load type is " + this.loadType.getTitle() + "\n";
    }
}

