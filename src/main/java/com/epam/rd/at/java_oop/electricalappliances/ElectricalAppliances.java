package com.epam.rd.at.java_oop.electricalappliances;

public interface ElectricalAppliances {
    int getPowerConsumptionInWT();
    int getPriceInUS();
    boolean compareAppliancesByPrice(ElectricalAppliances device);
    void doMainFunctionality();

}
