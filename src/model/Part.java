package model;

import java.math.BigDecimal;

public class Part {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;

    public Part(Long id, String name, String brand, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Long getId() {
        return id;
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
