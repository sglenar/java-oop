import com.epam.rd.at.java_oop.electricalappliances.Iron;
import com.epam.rd.at.java_oop.electricalappliances.WashingMachine;

public class Main {
    public static void main(String[] args) {
        Iron iron1 = new Iron();
        WashingMachine iron2 = new WashingMachine();
        iron1.setPriceInUS(5);
        boolean result = iron1.compareAppliancesByPrice(iron2);
        System.out.println(result);

    }
}