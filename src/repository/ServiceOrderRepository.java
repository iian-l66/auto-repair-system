package repository;

import model.Client;
import model.ServiceOrder;

import java.util.HashMap;
import java.util.Map;

public class ServiceOrderRepository {
    private Map<Long, ServiceOrder> serviceOrderMap = new HashMap<>();

    public ServiceOrder getServiceOrder (Long id) {
        return serviceOrderMap.get(id);
    }

    public void listServiceOrders () {
        serviceOrderMap.forEach((key, value) -> System.out.println(value));
    }

    public void addServiceOrder (ServiceOrder serviceOrder) {
        serviceOrderMap.put(serviceOrder.getId(), serviceOrder);
    }

    public void removeServiceOrder (Long id) {
        serviceOrderMap.remove(id);
    }

    public Map<Long, ServiceOrder> getServiceOrderMap() {
        return serviceOrderMap;
    }
}