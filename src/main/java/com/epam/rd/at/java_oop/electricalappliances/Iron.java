package com.epam.rd.at.java_oop.electricalappliances;

public class Iron extends SomeAppliance implements ElectricalAppliances {
    private final int steamPower; // using final to be sure that this parameter will be unchangeable
    private BaseType baseType;

    //creating constructors
    public Iron() {
        super();
        this.steamPower = 0;
        this.baseType = BaseType.CERMET;
    }

    public Iron(int steamPower, BaseType baseType) {
        super();
        this.steamPower = steamPower ;
        this.baseType = baseType;

    }

    public Iron(String modelName, ApplianceType applianceType, int powerConsumptionInWT, int priceInUS, int steamPower, BaseType baseType) {
        super(modelName, applianceType, powerConsumptionInWT, priceInUS);
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
            System.out.println("Ironing...");
        } else {
            System.out.println("Can't do my functionality now. Please plug me in");
        }
    }
}
enum BaseType {
    CERMET("Cermet"),
    TEFLON("Teflon"),
    STEEL("Steel");

    private String title;

    BaseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
