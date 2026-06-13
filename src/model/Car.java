package model;

public class Car {
    private String model;
    private String brand;
    private int year;
    private String plate;

    public Car(String model, String brand, int year, String plate) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
