import model.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Part part = new Part(45553L, "Vela", "bosch", new BigDecimal("399.00"));
        Part part2 = new Part(45553L, "Vela", "bosch", new BigDecimal("100.00"));
        Car car = new Car("Gol", "vw", 2008, "AYU678");
        Client client = new Client("Maylu", 23, "455.786.897-78");
        Employee employee = new Employee("Jhon", 44, "091.838.455-99");
        ServiceOrder s1 = new ServiceOrder(car, client);
        s1.calculateTotalPrice();
        System.out.println(s1.getTotalPrice());
        System.out.println("----------------");
        s1.addPart(part);
        s1.calculateTotalPrice();
        System.out.println(s1.getTotalPrice());
        System.out.println("----------");
        s1.addPart(part2);
        s1.calculateTotalPrice();
        s1.calculateTotalPrice();
        System.out.println(s1.getTotalPrice());
    }
}
