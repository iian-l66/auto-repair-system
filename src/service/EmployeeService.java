package service;

import exception.CpfAlreadyRegisteredException;
import exception.EmployeeNotFoundException;
import model.Employee;
import repository.EmployeeRepository;

public class EmployeeService implements CrudService<Employee>{
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void add(Employee employee) {
        if (employeeRepository.getEmployeeMap().values().stream()
                .anyMatch(x -> x.getCpf().equals(employee.getCpf())))
            throw new CpfAlreadyRegisteredException("this cpf already exists");

        employeeRepository.addEmployee(employee);
    }

    @Override
    public void list () {
        if (employeeRepository.getEmployeeMap().isEmpty())
            System.out.println("No employees registered yet.");
        else
            employeeRepository.listEmployees();
    }

    @Override
    public Employee get (Long id) {
        if (!employeeRepository.getEmployeeMap().containsKey(id))
            throw new EmployeeNotFoundException("This id is not registered.");

        return employeeRepository.getEmployee(id);
    }

    @Override
    public Employee get (String cpf) {
        return employeeRepository.getEmployeeMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new EmployeeNotFoundException("This cpf is not registered."));
    }

    @Override
    public void remove (Long id) {
        if (!employeeRepository.getEmployeeMap().containsKey(id))
            throw new EmployeeNotFoundException("This id is not registered.");

        employeeRepository.removeEmployee(id);
    }

    @Override
    public void remove (String cpf) {
        employeeRepository.removeEmployee(employeeRepository.getEmployeeMap().values().stream()
                .filter(x -> x.getCpf().equals(cpf)).findFirst().orElseThrow(
                        () -> new EmployeeNotFoundException("This cpf is not registered.")).getId());
    }
}
