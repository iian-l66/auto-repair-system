package repository;

import model.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {
    private Map<String, Client> clientMap = new HashMap<>();

    public Client getClient (String cpf) {
        return clientMap.get(cpf);
    }

    public void listClients () {
        clientMap.forEach((key, value) -> System.out.println(value));
    }

    public void addClient (Client client) {
        clientMap.put(client.getCpf(), client);
    }

    public void removeClient (String cpf) {
        clientMap.remove(cpf);
    }


    public Map<String, Client> getClientMap() {
        return clientMap;
    }
}
