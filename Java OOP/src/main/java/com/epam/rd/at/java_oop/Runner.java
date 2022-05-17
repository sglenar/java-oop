package com.epam.rd.at.java_oop;

import com.epam.rd.at.java_oop.electricalappliances.*;
import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;
import com.epam.rd.at.java_oop.electricalappliances.enums.BaseType;
import com.epam.rd.at.java_oop.electricalappliances.enums.LoadType;

public class Runner {
    public static void main(String[] args) {
        Room myRoom = new Room();
        myRoom.addAppliance(new SomeAppliance("Test Appliance", ApplianceType.WIRED ,
                20, 200, true));
        myRoom.addAppliance(new Tv(-5));
        myRoom.addAppliance(new Tv("Toshiba A1", ApplianceType.WIRELESS, 45,
                300, true, 65));
        myRoom.addAppliance(new WashingMachine());
        myRoom.addAppliance(new WashingMachine("LG ROG-7", ApplianceType.WIRED,
                30, 200, true, LoadType.VERTICAL));
        myRoom.addAppliance(new Fridge("Ariston Cool P13", ApplianceType.WIRED,
                -15, 300, true, 5 ));
        myRoom.addAppliance(new Fridge("Ariston STN-5", ApplianceType.WIRED,
                35, 276, true, 600 ));
        myRoom.addAppliance(new Iron("Tefal T5", ApplianceType.WIRED, 12,
                105, 400, false, BaseType.CERMET));
        myRoom.addAppliance(new Iron(450, BaseType.STEEL));
        myRoom.sortByPrice();
        System.out.println(myRoom.findApplianceByPower(31,40));
        System.out.println(myRoom.calculateTotalPowerConsumption());
    }
}
