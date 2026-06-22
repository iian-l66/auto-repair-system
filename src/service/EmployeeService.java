package service;

import exception.CpfAlreadyRegisteredException;
import exception.EmployeeNotFoundException;
import model.Employee;
import repository.EmployeeRepository;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        if (employeeRepository.getEmployeeMap().values().stream()
                .anyMatch(x -> x.getCpf().equals(employee.getCpf())))
            throw new CpfAlreadyRegisteredException("this cpf already exists");

        employeeRepository.addEmployee(employee);
    }

    public void listEmployees () {
        if (employeeRepository.getEmployeeMap().isEmpty())
            System.out.println("No employees registered yet.");
        else
            employeeRepository.listEmployees();
    }

    public Employee getEmployee (Long id) {
        if (!employeeRepository.getEmployeeMap().containsKey(id))
            throw new EmployeeNotFoundException("This id is not registered.");

        return employeeRepository.getEmployee(id);
    }

    public Employee getEmployee (String cpf) {
        return employeeRepository.getEmployeeMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new EmployeeNotFoundException("This cpf is not registered."));
    }

    public void removeEmployee (Long id) {
        if (!employeeRepository.getEmployeeMap().containsKey(id))
            throw new EmployeeNotFoundException("This id is not registered.");

        employeeRepository.removeEmployee(id);
    }

    public void removeEmployee(String cpf) {
        employeeRepository.removeEmployee(employeeRepository.getEmployeeMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new EmployeeNotFoundException("This cpf is not registered.")).getId());
    }
}
