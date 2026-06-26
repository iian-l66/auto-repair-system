import repository.ClientRepository;
import repository.EmployeeRepository;
import repository.PartRepository;
import repository.ServiceOrderRepository;
import service.ClientService;
import service.EmployeeService;
import service.PartService;
import service.ServiceOrderService;
import ui.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientService clientService = new ClientService(new ClientRepository());
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository());
        PartService partService = new PartService(new PartRepository());
        ServiceOrderService serviceOrderService = new ServiceOrderService(new ServiceOrderRepository());

        Menu menu = new Menu(scanner, clientService, employeeService,
                partService, serviceOrderService);
        menu.initialMenu();
    }
}
