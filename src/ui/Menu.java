package ui;

import com.sun.security.jgss.GSSUtil;
import exception.*;
import model.*;
import service.ClientService;
import service.EmployeeService;
import service.PartService;
import service.ServiceOrderService;

import java.math.BigDecimal;
import java.util.List;
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
            switch (choice) {
                case 1: try {
                    System.out.print("Client name: ");
                    String name = scanner.nextLine();
                    System.out.print("Client age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Client CPF: ");
                    String cpf = scanner.nextLine();
                    clientService.addClient(new Client(name, age, cpf));
                }
                catch (CpfAlreadyRegisteredException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 2:
                    try {
                        System.out.println("Do you want to search by CPF or ID? (1-CPF/2-ID): ");
                        int option = Integer.parseInt(scanner.nextLine());
                        if (option == 1) {
                            System.out.print("Enter CPF: ");
                            String cpf = scanner.nextLine();
                            Client client = clientService.getClient(cpf);
                            System.out.println(client);
                        }
                        else {
                            System.out.print("Enter ID: ");
                            Long id = Long.parseLong(scanner.nextLine());
                            Client client = clientService.getClient(id);
                            System.out.println(client);
                        }
                    }
                    catch (ClientNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: clientService.listClients(); break;
                case 4:
                    try {
                        System.out.println("Do you want to remove by CPF or ID? (1-CPF/2-ID): ");
                        int option = Integer.parseInt(scanner.nextLine());
                        if (option == 1) {
                            System.out.print("Enter CPF: ");
                            String cpf = scanner.nextLine();
                            clientService.removeClient(cpf);
                            System.out.println("Client removed!");
                        }
                        else {
                            System.out.print("Enter ID: ");
                            Long id = Long.parseLong(scanner.nextLine());
                            clientService.removeClient(id);
                            System.out.println("Client removed!");
                        }
                    }
                    catch (ClientNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
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
            switch (choice) {
                case 1: try {
                    System.out.print("Employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Employee age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Employee CPF: ");
                    String cpf = scanner.nextLine();
                    employeeService.addEmployee(new Employee(name, age, cpf));
                }
                catch (CpfAlreadyRegisteredException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 2:
                    try {
                        System.out.println("Do you want to search by CPF or ID? (1-CPF/2-ID): ");
                        int option = Integer.parseInt(scanner.nextLine());
                        if (option == 1) {
                            System.out.print("Enter CPF: ");
                            String cpf = scanner.nextLine();
                            Employee employee = employeeService.getEmployee(cpf);
                            System.out.println(employee);
                        }
                        else {
                            System.out.print("Enter ID: ");
                            Long id = Long.parseLong(scanner.nextLine());
                            Employee employee = employeeService.getEmployee(id);
                            System.out.println(employee);
                        }
                    }
                    catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: employeeService.listEmployees(); break;
                case 4:
                    try {
                        System.out.println("Do you want to remove by CPF or ID? (1-CPF/2-ID): ");
                        int option = Integer.parseInt(scanner.nextLine());
                        if (option == 1) {
                            System.out.print("Enter CPF: ");
                            String cpf = scanner.nextLine();
                            employeeService.removeEmployee(cpf);
                            System.out.println("Employee removed!");
                        }
                        else {
                            System.out.print("Enter ID: ");
                            Long id = Long.parseLong(scanner.nextLine());
                            employeeService.removeEmployee(id);
                            System.out.println("Employee removed!");
                        }
                    }
                    catch (EmployeeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
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
            switch (choice) {
                case 1:
                    System.out.print("Part name: ");
                    String name = scanner.nextLine();
                    System.out.print("Part Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Part price: ");
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    partService.addPart(new Part(name, brand, price));
                    break;
                case 2: try {
                    System.out.print("Enter Part ID: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    Part part = partService.getPart(id);
                    System.out.println(part);
                }
                catch (PartNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 3: partService.listParts(); break;
                case 4:
                    try {
                        System.out.print("Enter Part ID: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        partService.removePart(id);
                        System.out.println("Part removed!");
                    }
                    catch (PartNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
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
            switch (choice) {
                case 1:
                    try {
                        Client client;
                        System.out.println("On behalf of which client do you wish to open the order?");
                        System.out.println("Do you want to search by CPF or ID? (1-CPF/2-ID): ");
                        int option = Integer.parseInt(scanner.nextLine());
                        if (option == 1) {
                            System.out.print("Enter CPF: ");
                            String cpf = scanner.nextLine();
                            client = clientService.getClient(cpf);
                            System.out.println(client);
                        }
                        else {
                            System.out.print("Enter ID: ");
                            Long id = Long.parseLong(scanner.nextLine());
                            client = clientService.getClient(id);
                            System.out.println(client);
                        }
                        List<Car> cars = client.listCars();
                        if (!cars.isEmpty()) {
                            System.out.println("Choose which car you want to add to the order.");
                            for (int i = 0; i < cars.size(); i++) {
                                System.out.println((i + 1) + "- " + cars.get(i));
                            }
                            System.out.println("Enter the index: ");
                            int index = Integer.parseInt(scanner.nextLine());;
                            while (index <= 0 || index > cars.size()) {
                                System.out.println("Invalid Index");
                                System.out.print("Enter: ");
                                index = Integer.parseInt(scanner.nextLine());
                            }
                            Car car = cars.get(index - 1);
                            System.out.println(car);
                            serviceOrderService.addServiceOrder(new ServiceOrder(car, client));
                            System.out.println("Service Order created successfully!");
                        }
                        else {
                            System.out.println("There are no cars registered for this customer; register them first.");
                        }
                    }
                    catch (ClientNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: try {
                    System.out.print("Enter Service Order ID: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    ServiceOrder serviceOrder = serviceOrderService.getServiceOrder(id);
                    System.out.println(serviceOrder);
                }
                catch (ServiceOrderNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                    break;
                case 3:
                    System.out.println("Which types of service orders do you want to list?");
                    System.out.println("1- Open\n2- Closed\n3-In Progress\n4- All");
                    int index = Integer.parseInt(scanner.nextLine());
                    serviceOrderService.listServiceOrders(
                            switch (index) {
                                case 1 -> ServiceOrderStatus.OPEN;
                                case 2 -> ServiceOrderStatus.CLOSED;
                                case 3 -> ServiceOrderStatus.IN_PROGRESS;
                                default -> null;
                            }
                    ); break;
                case 4:
                    try {
                        System.out.print("Enter Service Order ID: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        serviceOrderService.removeServiceOrder(id);
                        System.out.println("Service Order Removed!");
                    }
                    catch (ServiceOrderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
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
