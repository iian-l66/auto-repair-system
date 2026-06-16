import model.Part;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Part part = new Part(45553L, "Vela", "bosch", new BigDecimal("399.00"));

        System.out.println(part);
    }
}
