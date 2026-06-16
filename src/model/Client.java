package model;

import java.util.HashMap;
import java.util.Map;

public class Client extends Person{
    private Map<String, Car> cars = new HashMap<>();

    public Client(String name, int age, String cpf) {
        super(name, age, cpf);
    }

    public void addCar (Car car) {
        cars.put(car.getPlate(), car);
    }
}
