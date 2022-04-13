package com.epam.rd.at.java_oop.electricalappliances;

import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;
import com.epam.rd.at.java_oop.electricalappliances.enums.BaseType;

public class Iron extends SomeAppliance implements ElectricalAppliances {
    private final int steamPower; // using final to be sure that this parameter will be unchangeable
    private BaseType baseType;

    //creating constructors
    public Iron() {
        super();
        setModelName("Unknown iron");
        this.steamPower = 0;
        this.baseType = BaseType.CERMET;
    }

    public Iron(int steamPower, BaseType baseType) {
        super();
        setModelName("Unknown iron");
        this.steamPower = steamPower ;
        this.baseType = baseType;

    }

    public Iron(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, int steamPower, boolean isPluggedIn, BaseType baseType) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS, isPluggedIn);
        this.steamPower = steamPower;
        this.baseType = baseType;
    }

    //methods
    public int getSteamPower() {
        return this.steamPower;
    }

    public void setBaseType(BaseType baseType) {
        this.baseType = baseType;
    }

    public BaseType getBaseType() {
        return this.baseType;
    }

    @Override
    public void doMainFunctionality() {
        if (this.getIsPluggedIn()) {
            System.out.println("I am the " + this.getModelName()) ;
            System.out.println("Ironing...");
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "My base type is " + this.baseType.getTitle() + "\n" +
                "My steam power is " + this.steamPower + "\n";
    }
}
