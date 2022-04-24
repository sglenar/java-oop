package com.epam.rd.at.java_oop;

import com.epam.rd.at.java_oop.electricalappliances.*;

import java.util.Arrays;

public class Room  {

   private SomeAppliance[] roomWithAppliance;

    public Room() {
        this.roomWithAppliance = new SomeAppliance[0];
    }

    public void addAppliance(SomeAppliance appliance) {
        SomeAppliance[] result = new SomeAppliance[this.roomWithAppliance.length + 1];
        for ( int i =0; i < this.roomWithAppliance.length; i++) {
            result[i] = this.roomWithAppliance[i];
        }
        result[this.roomWithAppliance.length] = appliance;
        this.roomWithAppliance = result;
    }

    public void  sortByPrice() {
        Arrays.sort(this.roomWithAppliance, new PriceComparator());
    }

    public int calculateTotalPowerConsumption(){
        int result = 0;
        for (SomeAppliance appliance: roomWithAppliance) {
            if (appliance.getIsPluggedIn()){
                result += appliance.getPowerConsumptionInWT();
            }
        }
        return result;
    }

    public SomeAppliance findApplianceByPower(int minPower, int maxPower) {
        for (SomeAppliance appliance: roomWithAppliance) {
            if (appliance.isDeviceInPowerConsumptionRange(minPower, maxPower)) {
                return appliance;
            }
        } return null;
    }


}