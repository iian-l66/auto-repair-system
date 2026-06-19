package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServiceOrder extends BaseEntity {
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static Long nextId = 1L;
    private Client client;
    private Car car;
    private ServiceOrderStatus status;
    private LocalDateTime date;
    private List<Employee> employees = new ArrayList<>();
    private List<Part> parts = new ArrayList<>();
    private BigDecimal totalPrice;

    public ServiceOrder(Car car, Client client) {
        super(nextId++);
        this.car = car;
        this.client = client;
        this.status = ServiceOrderStatus.OPEN;
        this.date = LocalDateTime.now();
        this.totalPrice = new BigDecimal("0");
    }

    public void calculateTotalPrice () {
        totalPrice = new BigDecimal("0");
        for (Part part : parts) {
            totalPrice = totalPrice.add(part.getPrice());
        }
    }

    public void addEmployee (Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee (Employee employee) {
        employees.remove(employee);
    }

    public void addPart (Part part) {
        parts.add(part);
    }

    public void removePart (Part part) {
        parts.remove(part);
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Part> getParts() {
        return parts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("==Service Order===\nID: %d\nClient: %s\nCar: %s\n" +
                "Status: %s\nDate: %s", id, client.getName(), car, status.toString(), DATE_FORMAT.format(date));
    }
}
