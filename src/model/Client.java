package model;

import java.util.HashMap;
import java.util.Map;

public class Client extends Person{
    private static Long nextId = 1L;
    private Map<String, Car> cars = new HashMap<>();

    public Client(String name, int age, String cpf) {
        super(nextId++, name, age, cpf);
    }

    public void addCar (Car car) {
        cars.put(car.getPlate(), car);
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age + ", " + cpf;
    }
}
