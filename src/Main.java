import model.*;
import repository.ClientRepository;
import repository.ServiceOrderRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ServiceOrderRepository serviceOrderRepository = new ServiceOrderRepository();
        serviceOrderRepository.addServiceOrder(new ServiceOrder(new Car("corsel", "gm", 2001, "ASR456"),
                new Client("Jose", 33, "0988989032")));
        serviceOrderRepository.addServiceOrder(new ServiceOrder(new Car("GOL", "VW", 2001, "ATY987"),
                new Client("Miguel", 33, "435546466")));


    }
}
