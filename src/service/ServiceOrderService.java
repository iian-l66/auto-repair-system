package service;

import exception.ServiceOrderAlreadyRegisteredException;
import exception.ServiceOrderNotFoundException;
import model.ServiceOrder;
import model.ServiceOrderStatus;
import repository.ServiceOrderRepository;

import java.util.List;


public class ServiceOrderService implements CrudService<ServiceOrder> {
    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    @Override
    public void add (ServiceOrder serviceOrder) {
        if (serviceOrderRepository.getServiceOrderMap().values()
            .stream().anyMatch(x  -> x.getCar().getPlate()
                        .equals(serviceOrder.getCar().getPlate()) && x.getStatus() != ServiceOrderStatus.CLOSED))
            throw new ServiceOrderAlreadyRegisteredException("This car is already registered.");

        serviceOrderRepository.addServiceOrder(serviceOrder);
    }

    @Override
    public void list() {
        serviceOrderRepository.listServiceOrders();
    }

    public void list (ServiceOrderStatus status) {
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

    @Override
    public ServiceOrder get (Long id) {
        if (!serviceOrderRepository.getServiceOrderMap().containsKey(id))
            throw new ServiceOrderNotFoundException("This OS is not registered");
        return serviceOrderRepository.getServiceOrder(id);
    }

    @Override
    public void remove (Long id) {
        if (!serviceOrderRepository.getServiceOrderMap().containsKey(id))
            throw new ServiceOrderNotFoundException("This OS is not registered");

        serviceOrderRepository.removeServiceOrder(id);
    }
}