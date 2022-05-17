package com.epam.rd.at.java_oop;

import com.epam.rd.at.java_oop.electricalappliances.*;

import java.util.Arrays;

public class Room  {

   private SomeAppliance[] manyAppliances;

    public Room() {
        this.manyAppliances = new SomeAppliance[0];
    }

    public void addAppliance(SomeAppliance appliance) {
        SomeAppliance[] result = new SomeAppliance[this.manyAppliances.length + 1];
        for (int i = 0; i < this.manyAppliances.length; i++) {
            result[i] = this.manyAppliances[i];
        }
        result[this.manyAppliances.length] = appliance;
        this.manyAppliances = result;
    }

    public void  sortByPrice() {
        Arrays.sort(this.manyAppliances, new PriceComparator());
    }

    public int calculateTotalPowerConsumption(){
        int result = 0;
        for (SomeAppliance appliance: manyAppliances) {
            if (appliance.getIsPluggedIn()){
                result += appliance.getPowerConsumptionInWT();
            }
        }
        return result;
    }

    public SomeAppliance findApplianceByPower(int minPower, int maxPower) {
        for (SomeAppliance appliance: manyAppliances) {
            if (appliance.isDeviceInPowerConsumptionRange(minPower, maxPower)) {
                return appliance;
            }
        } return null;
    }


}