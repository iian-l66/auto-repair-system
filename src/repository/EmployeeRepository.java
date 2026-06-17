package repository;

import model.Client;
import model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {
    private Map<Long, Employee> employeeMap = new HashMap<>();

    public Employee getEmployee (Long id) {
        return employeeMap.get(id);
    }

    public void listEmployees () {
        employeeMap.forEach((key, value) -> System.out.println(value));
    }

    public void addClient (Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    public void removeEmployee (Long id) {
        employeeMap.remove(id);
    }

    public Map<Long, Employee> getEmployeeMap() {
        return employeeMap;
    }
}
