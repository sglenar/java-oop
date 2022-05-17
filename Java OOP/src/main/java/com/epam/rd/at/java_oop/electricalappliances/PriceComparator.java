package com.epam.rd.at.java_oop.electricalappliances;

import java.util.Comparator;

public class PriceComparator implements Comparator<SomeAppliance> {
    public int compare(SomeAppliance appliance1, SomeAppliance appliance2) {
        return Integer.compare(appliance1.getPriceInUS(),appliance2.getPriceInUS());
    }
}
