import com.epam.rd.at.java_oop.electricalappliances.*;
import com.epam.rd.at.java_oop.electricalappliances.enums.ApplianceType;
import com.epam.rd.at.java_oop.electricalappliances.enums.BaseType;
import com.epam.rd.at.java_oop.electricalappliances.enums.LoadType;

import java.util.Arrays;

public class Room {
    public static void main(String[] args) {
        SomeAppliance[] roomWithAppliances = new SomeAppliance[10];
        System.out.println("Scanning all registered devices...");
        System.out.println("Initialization...");
        // creating base appliance
        roomWithAppliances[0] = new SomeAppliance();
        // creating base appliance with parameters
        roomWithAppliances[1] = new SomeAppliance("Test Appliance", ApplianceType.WIRED ,
                20, 200, true);
        // creating TV with invalid data
        roomWithAppliances[2] = new Tv(-5);
        //using setter
        roomWithAppliances[2].setPriceInUS(200);
        // creating TV with parameters
        roomWithAppliances[3] = new Tv("Toshiba A1", ApplianceType.WIRELESS, 45,
                300, true, 65);
        //creating Washing machine by default
        roomWithAppliances[4] = new WashingMachine();
        //creating Washing machine with parameters
        roomWithAppliances[5] = new WashingMachine("LG ROG-7", ApplianceType.WIRED,
                30, 200, true, LoadType.VERTICAL);
        //creating Fridges with parameters and with invalid data
        roomWithAppliances[6] = new Fridge("Ariston Cool P13", ApplianceType.WIRED,
                -15, 300, true, 5 );
        roomWithAppliances[7] = new Fridge("Ariston STN-5", ApplianceType.WIRED,
                35, 276, true, 600 );
        //creating not plugged Iron
        roomWithAppliances[8] = new Iron("Tefal T5", ApplianceType.WIRED, 12,
                105, 400, false, BaseType.CERMET);
        //creating iron with 2 unique parameters
        roomWithAppliances[9] = new Iron(450, BaseType.STEEL);
        System.out.println("Scanning have finished, issues were fixed\n\n");
        System.out.println("There are the full list of available appliances in the room: ");
        for (SomeAppliance element: roomWithAppliances) {
            System.out.println(element.toString());
            System.out.println("========================");
        }
        System.out.println("\nLet's check the main functionality of registered appliances");
        for (SomeAppliance element: roomWithAppliances) {
            element.doMainFunctionality();
            System.out.println("*************************");
        }
        System.out.println(".............................");

        for (SomeAppliance element: roomWithAppliances) {
            System.out.println(element.toString());
            System.out.println("========================");
        }
        //Arrays.sort(roomWithAppliances, compare());
    }
}