package com.epam.rd.at.java_oop.electricalappliances;

public interface ElectricalAppliances {
    int getPowerConsumptionInWT();
    int getPriceInUS();
    boolean compareAppliancesByPrice(ElectricalAppliances device);
    //boolean compareAppliancesByPowerConsumption(ElectricalAppliances device);
    void doMainFunctionality();
    void plugIn();
    void plugOut();
    boolean equals(SomeAppliance appliance);
}
