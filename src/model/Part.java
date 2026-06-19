package model;

import java.math.BigDecimal;

public class Part extends BaseEntity{
    private static Long nextId = 1L;
    private String name;
    private String brand;
    private BigDecimal price;

    public Part(String name, String brand, BigDecimal price) {
        super(nextId++);
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nId: %d%nBrand: %s%nPrice: %s%n", name, id,
                brand, price);
    }
}
