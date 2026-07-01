package model;

import java.util.HashMap;
import java.util.List;
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

    public List<Car> listCars () {
        return cars.values().stream().toList();
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age + ", " + cpf;
    }
}
