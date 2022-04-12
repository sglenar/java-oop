package com.epam.rd.at.java_oop.electricalappliances;

public class SomeWirelessAppliance extends  SomeAppliance implements WirelessAppliances {

    int batteryLevelInPercents;


    @Override
    public boolean chargeDevice() {
        return false;
    }

    @Override
    public boolean changeBattery() {
        return false;
    }
}

