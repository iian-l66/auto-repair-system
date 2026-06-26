package ui;

import exception.CpfAlreadyRegisteredException;
import model.Client;
import service.ClientService;
import service.EmployeeService;
import service.PartService;
import service.ServiceOrderService;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final PartService partService;
    private final ServiceOrderService serviceOrderService;

    public Menu(Scanner scanner, ClientService clientService, EmployeeService employeeService,
                PartService partService, ServiceOrderService serviceOrderService) {
        this.scanner = scanner;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.partService = partService;
        this.serviceOrderService = serviceOrderService;
    }

    public void option (int input) {
        switch (input) {
            case 1: clientMenu(); break;
            case 2: employeeMenu(); break;
            case 3: partMenu(); break;
            case 4: serviceOrderMenu(); break;
        }
    }

    public void initialMenu () {
        int choice = 0;
        while (choice != 5) {
            clearScreen();
            System.out.println("===AUTO REPAIR SYSTEM===");
            System.out.println("[1]- Clients");
            System.out.println("[2]- Employees");
            System.out.println("[3]- Parts");
            System.out.println("[4]- Service Orders");
            System.out.println("[5]- Exit");
            choice = getInput();
            clearScreen();
            option(choice);
        }
    }

    public void clientMenu () {
        int choice = 0;
        while (choice != 5) {
            System.out.println("===CLIENTS===");
            System.out.println("[1]- Add Client");
            System.out.println("[2]- Search Client");
            System.out.println("[3]- List Clients");
            System.out.println("[4]- Remove Client");
            System.out.println("[5]- Back");
            choice = getInput();
        }
    }

    public void employeeMenu () {
        int choice = 0;
        while (choice != 5) {
            System.out.println("===EMPLOYEES===");
            System.out.println("[1]- Add Employee");
            System.out.println("[2]- Search Employee");
            System.out.println("[3]- List Employees");
            System.out.println("[4]- Remove Employee");
            System.out.println("[5]- Back");
            choice = getInput();
        }
    }

    public void partMenu () {
        int choice = 0;
        while (choice != 5) {
            System.out.println("===PARTS===");
            System.out.println("[1]- Add Part");
            System.out.println("[2]- Search Part");
            System.out.println("[3]- List Parts");
            System.out.println("[4]- Remove Part");
            System.out.println("[5]- Back");
            choice = getInput();
        }
    }

    public void serviceOrderMenu () {
        int choice = 0;
        while (choice != 5) {
            System.out.println("===SERVICE ORDERS===");
            System.out.println("[1]- Add Service Order");
            System.out.println("[2]- Search Service Order");
            System.out.println("[3]- List Service Orders");
            System.out.println("[4]- Remove Service Order");
            System.out.println("[5]- Back");
            choice = getInput();
        }
    }

    public int getInput () {
        int input = 0;
        while (input == 0) try {
            System.out.print("Enter: ");
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        return input;
    }

    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
