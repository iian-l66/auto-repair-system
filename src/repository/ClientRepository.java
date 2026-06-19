package repository;

import model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {
    private Map<Long, Client> clientMap = new HashMap<>();

    public Client getClient (Long id) {
        return clientMap.get(id);
    }

    public void listClients () {
        clientMap.forEach((key, value) -> System.out.println(value));
    }

    public void addClient (Client client) {
        clientMap.put(client.getId(), client);
    }

    public void removeClient (Long id) {
        clientMap.remove(id);
    }


    public Map<Long, Client> getClientMap() {
        return clientMap;
    }
}
