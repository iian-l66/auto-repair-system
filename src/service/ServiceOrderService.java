package service;

import exception.ServiceOrderAlreadyRegisteredException;
import exception.ServiceOrderNotFoundException;
import model.ServiceOrder;
import model.ServiceOrderStatus;
import repository.ServiceOrderRepository;

import java.util.List;


public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    public void addServiceOrder (ServiceOrder serviceOrder) {
        if (serviceOrderRepository.getServiceOrderMap().values()
            .stream().anyMatch(x  -> x.getCar().getPlate()
                        .equals(serviceOrder.getCar().getPlate()) && x.getStatus() != ServiceOrderStatus.CLOSED))
            throw new ServiceOrderAlreadyRegisteredException("This car is already registered.");

        serviceOrderRepository.addServiceOrder(serviceOrder);
    }

    public void listServiceOrders (ServiceOrderStatus status) {
        if (serviceOrderRepository.getServiceOrderMap().isEmpty())
            System.out.println("No ServiceOrders registered yet");
        else if (status == null)
            serviceOrderRepository.listServiceOrders();
        else {
            List<ServiceOrder> orders = serviceOrderRepository.getServiceOrderMap().values()
                    .stream().filter(x -> x.getStatus() == status).toList();
            if (orders.isEmpty()) {
                System.out.println("No ServiceOrders " + status.name() + " registered yet");
                return;
            }
            for (ServiceOrder order : orders) {
                System.out.println(order);
            }
        }
    }

    public ServiceOrder getServiceOrder (Long id) {
        if (!serviceOrderRepository.getServiceOrderMap().containsKey(id))
            throw new ServiceOrderNotFoundException("This OS is not registered");
        return serviceOrderRepository.getServiceOrder(id);
    }

    public void removeServiceOrder (Long id) {
        if (!serviceOrderRepository.getServiceOrderMap().containsKey(id))
            throw new ServiceOrderNotFoundException("This OS is not registered");

        serviceOrderRepository.removeServiceOrder(id);
    }
}